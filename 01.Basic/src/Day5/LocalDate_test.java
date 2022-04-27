package Day5;

import java.time.LocalDate;

public class LocalDate_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date = LocalDate.now();
		LocalDate date1 = LocalDate.of(2016, 10, 31);
		LocalDate date2 = LocalDate.parse("2023-11-02");
		System.out.println(date1);
		System.out.println(date2);
		System.out.println("Current: " + date);
		LocalDate yesterday = date.minusDays(1);
		System.out.println("Yesterday: " + yesterday);
		System.out.println("Tomorrow: " + date.plusDays(1));
		
		System.out.println("Year: " + date.getYear());
		System.out.println("Month: " + date.getMonth());
		System.out.println("Month: " + date.getMonthValue());
		System.out.println("Day of Week: " + date.getDayOfWeek());
		System.out.println("Day of Month: " + date.getDayOfMonth());
		System.out.println("Day of Year: " + date.getDayOfYear());
		System.out.println("Leap year(2022): " + date.isLeapYear());
		System.out.println("Leap year(2016): " + date1.isLeapYear());
		System.out.println(date1.equals(date2));
		System.out.println("2022 is after 2016: " + date.isAfter(date1));
		System.out.println("2022 is after 2016: " + date.isBefore(date1));
		System.out.println("2022 is after 2016: " + date2.getDayOfYear());
		
	}

}
