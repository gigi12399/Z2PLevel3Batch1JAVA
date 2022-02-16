package Day5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CustomDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MMM dd yy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("HH-mm-ss a");
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' h:m:s");
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.println("Default Date: " + date);
		System.out.println("Format: " + date.format(f1));
		
		System.out.println("Default Time: " + time);
		System.out.println("Format: " + time.format(f2));
		
		System.out.println("Default DateTime: " + dateTime);
		System.out.println("Format: " + dateTime.format(f3));
	}

}
