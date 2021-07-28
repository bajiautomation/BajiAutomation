package ezyBillV2;

import java.time.LocalDate;
import java.time.YearMonth;

public class DaysInMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate date = LocalDate.of(2021,5, 30);
		int days = date.lengthOfMonth();
		System.out.println("Days in Month- 1st Method:"+days);
		
		// Get the number of days in that month
		YearMonth yearMonthObject = YearMonth.of(2021, 2);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		System.out.println("Days in Month- 2nd Method:"+daysInMonth);
		
		//String date = "2010-01-19";
		//String[] ymd = date.split("-");
		//int year = Integer.parseInt(ymd[0]);
		//int month = Integer.parseInt(ymd[1]);
		//int day = Integer.parseInt(ymd[2]);
		//Calendar calendar = Calendar.getInstance();
		//calendar.set(Calendar.YEAR,year);
		//calendar.set(Calendar.MONTH,month);
		//int daysQty = calendar.getDaysNumber(); // Something like this

	}

}
