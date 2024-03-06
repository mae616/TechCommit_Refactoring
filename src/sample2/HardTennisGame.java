package sample2;

import java.util.function.BiFunction;

public class HardTennisGame extends TennisGame {
    
    private Player player1;
    private Player player2;
    
    private static int GAME_FINISH = 4;

    public HardTennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String playerName) {
    	if(this.player1.getPlayerName().equals(playerName)) {
    		this.player1.incrementPoint();
    	}else if(this.player2.getPlayerName().equals(playerName)) {
    		this.player2.incrementPoint();
    	}
    }

    public String getScore() {
        
        if (this.player1.getPoint() == this.player2.getPoint()) {
            return this.getSameScoreName(this.player1.getPoint());
        
        }else if (this.player1.getPoint() >= GAME_FINISH 
        	|| this.player2.getPoint() >= GAME_FINISH ){
        	
        	return this.getGameFinishScoreName(this.player1, this.player2);
        
        }else {

        	BiFunction<Player, Player, String> getGamScoreName = (Player argPlayer1, Player argPlayer2) -> 
        													this.getScoreName(argPlayer1.getPoint()) + "-" + this.getScoreName(argPlayer2.getPoint());
        	
            return getGamScoreName.apply(this.player1, this.player2);
        }
    }
    

    private String getSameScoreName(int point) {
    	
        if (point == 0){
        	return "Love-All";
        
        }else if(point == 1){
        	return "Fifteen-All";
        
        }else if(point == 2){
        	return "Thirty-All";
        	
        }else{
        	return "Deuce";
        }
    }
    
    private String getGameFinishScoreName(Player player1, Player player2) {
    	
    	BiFunction<Player, Player, Integer> getPointDifference = (Player argPlayer1, Player argPlayer2) -> 
    														Math.abs(argPlayer1.getPoint() - argPlayer2.getPoint());
    																
    	BiFunction<Player, Player, Player> getWonPlayer = (Player argPlayer1, Player argPlayer2) -> 
    														argPlayer1.getPoint() > argPlayer2.getPoint() ? argPlayer1 : argPlayer2;
   	
        int minusResult = getPointDifference.apply(player1, player2);
        String wonPlayerName =  getWonPlayer.apply(player1, player2).getPlayerName();
        
        if (minusResult == 1) {
        	return "Advantage " + wonPlayerName;
        }
        return "Win for " + wonPlayerName;
    }
    

    private String getScoreName(int point) {
    	
        if(point == 0){
        	return "Love";
        }else if(point == 1){
        	return "Fifteen";
        }else if(point == 2){
        	return "Thirty";
        }else{
        	// point == 3
        	return "Forty";
        }
    }
}