package Assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date_Time_Ass_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("E, MMM dd yyy");
		LocalDate now = LocalDate.now();
		String[] weekend = {"SATURDAY","SUNDAY"};
		String dayOfWeek = String.valueOf(now.getDayOfWeek());
		int count = -1;
		System.out.println(now.format(f1));
		System.out.println("****************************");
		for(var d : weekend) {
			if(dayOfWeek == d) {
				count = 1;
				break;
			}
		}
		if(count == 1) {
			System.out.println("Today is my holiday");
		}else {
			System.out.println("I have no time. I am studying Programming Language.");
		}
	}

	

	

}
