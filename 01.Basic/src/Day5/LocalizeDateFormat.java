package Day5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LocalizeDateFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter f1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		
		LocalDate date = LocalDate.now();
		
		System.out.format("LONG: %s\n", date.format(f1));
		System.out.println("FULL: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		System.out.println("MEDIUM: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
		System.out.println("SHORT: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
	
		LocalTime time = LocalTime.now();
		
		System.out.println("Default: " + time);
		System.out.println("MEDIUM: " + time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
		System.out.println("SHORT: " + time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		System.out.println("Default: " + dateTime);
		System.out.println("MEDIUM: " + dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		System.out.println("SHORT: " + dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
	}  

}
