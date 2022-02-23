package Basic_Assignment;

import java.util.Scanner;

public class Basic_ass_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers you want to type: ");
		int total_no = sc.nextInt();
		int positive = 0;
		int negative = 0;
		int zero = 0;
		for(var i = 0; i < total_no; i++) {
			System.out.println("Enter any number: ");
			int no = sc.nextInt();
			if(no > 0)
				positive++;
			else if(no < 0)
				negative++;
			else
				zero++;
		}
		
		System.out.println("____________________________");
		System.out.println("Numbers of zero: " + zero);
		System.out.println("Numbers of positive number: " + positive);
		System.out.println("Numbers of negative number: " + negative);
		sc.close();
			
		
	}

}
