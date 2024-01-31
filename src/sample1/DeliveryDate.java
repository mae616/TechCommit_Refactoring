package sample1;

import java.time.LocalDate;
import java.time.Month;

public class DeliveryDate {
	public LocalDate getDeliveryDate() {
		LocalDate localDate = LocalDate.now();
		int day = localDate.getDayOfMonth();
		Month month = localDate.getMonth();
		int year = localDate.getYear();
		
		if (day >= 25) {
			month.plus(1L);
		} else if (month.equals(Month.DECEMBER) && day >= 2) {
			month.plus(1L);
		}
		
		int lastDay;
		
		// ......
		
		// temp return
		return localDate;
	}
}
