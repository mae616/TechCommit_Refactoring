package sample2;

public class Player {
	
    private int point = 0;
    private String playerName;
    
    public Player(String playerName) {
        this.playerName = playerName;
    }
    
    public void incrementPoint() {
    	this.point++;
    }
    
    public int getPoint() {
    	return this.point;
    }
    
    public String getPlayerName() {
    	return this.playerName;
    }
}
