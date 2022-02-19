package Day6;

import java.util.Scanner;

public class try_finally {
	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.println("Enter salary: ");
			int salary = Integer.parseInt(sc.nextLine());
			if(salary == 0)
				return;
			System.out.println("Your salary: " + salary);
		} finally {
			sc.close();
			System.out.println("This is finally block");
		}
		System.out.println("Outside try finally block");
	}
}
