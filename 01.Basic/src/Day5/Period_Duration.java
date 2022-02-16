package Day5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Period_Duration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date1 = LocalDate.parse("2019-09-25");
		LocalDate date2 = LocalDate.parse("2016-03-06");
		
		Period diff = Period.between(date1, date2);
		System.out.println("Year: " + diff.getYears());
		System.out.println("Month: " + diff.getMonths());
		System.out.println("Day: " + diff.getDays());
		
		LocalTime time1 = LocalTime.parse("11:30");
		LocalTime time2 = LocalTime.parse("12:00");
		
		Duration timeDiff = Duration.between(time1, time2);
		System.out.println("No of sec: " + timeDiff.getSeconds());
	}

}
