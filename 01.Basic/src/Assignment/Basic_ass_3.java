package Assignment;

import java.util.Scanner;

public class Basic_ass_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sleep_hours;
		int copy;
		
		do {
			System.out.println("When do you go bed?");
			int sleep_time = sc.nextInt();
			System.out.println("When do you get up?");
			int getup_time = sc.nextInt();
			if(sleep_time > 6)
				sleep_hours = (12 - sleep_time) + getup_time;
			else
				sleep_hours = getup_time - sleep_time;
			
			System.out.println("Total sleep hours: " + sleep_hours);
			if(sleep_hours >= 5 && sleep_hours <= 8)
				System.out.println("You take care your health...");
			else if(sleep_hours < 5)
				System.out.println("You are very hardworking!!!");
			else if(sleep_hours > 8)
				System.out.println("You are abnormal!!");
			System.out.println("The process will continue when enter \"1\" and will stop when enter \"0\" ");
			int word = sc.nextInt();
			copy = word;
		}while(copy == 1);
		
		
		sc.close();
	}

}
