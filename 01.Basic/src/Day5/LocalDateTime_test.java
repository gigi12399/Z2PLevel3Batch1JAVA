package Day5;

import java.time.LocalDateTime;

public class LocalDateTime_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime date1 = LocalDateTime.of(2016, 10, 16, 4, 30);
		System.out.println("Current: " + now);
		System.out.println("Date1: " + date1);
		System.out.println("Year: " + now.getYear());
		System.out.println("Month: " + now.getMonthValue());
		System.out.println("Hour: " + now.getHour());
	}

}
