package sample1;

import java.time.LocalDate;
import java.time.Month;

public class DeliveryDate {
	
	public LocalDate getDeliveryDate() {
		
		LocalDate orderDate = LocalDate.now(); // 注文日
		LocalDate deliveryDate = LocalDate.parse(orderDate.toString()); // TODO これできるのかわからないけど
		
		// 配達日の導出
		if (isEndOfMonth(orderDate.getDayOfMonth()) // 月末
			|| isEndOfYear(orderDate.getMonth(), orderDate.getDayOfMonth())) { // 年末
			// 次月に繰越す
			deliveryDate.getMonth().plus(1L);
		}
		
		// 月末の日を配達日にする
		return convertEndOfMonthDate(deliveryDate);
	}

	// 月末の日付に変換する
	private LocalDate convertEndOfMonthDate(LocalDate deliveryDate) {
		// 月の最後の日を取得する
		int lastDay =  getLastDayOfMonth(deliveryDate.getMonth(), deliveryDate.getYear());
		
		return LocalDate.of(deliveryDate.getYear(), deliveryDate.getMonth(), lastDay);
	}

	// 月の最後の日を取得する
	private int getLastDayOfMonth(Month month, int year) {
		
		if (month.equals(Month.APRIL)
			|| month.equals(Month.JUNE)
			|| month.equals(Month.SEPTEMBER)
			|| month.equals(Month.NOVEMBER)) {
			return 30;
		}else if(month.equals(Month.FEBRUARY)) {
			if(isLeapYear(year)) {
				return 29;
			}
			return 28;
		}
		return 31;
	}
	
	// 月末か判定
	private boolean isEndOfMonth(int day) {
		return day >= 25;
	}
	
	// 年末か判定
	private boolean isEndOfYear(Month month, int day) {
		return month.equals(Month.DECEMBER) && day >= 2;
	}
	
	// 閏年か判定
	private boolean isLeapYear(int year) {
		return (year % 4) == 0;
	}
}
