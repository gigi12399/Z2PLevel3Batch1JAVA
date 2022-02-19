package Day7;

import java.util.Scanner;

public class try_with_resources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter your salary: ");
			int salary = Integer.parseInt(sc.nextLine());
			System.out.println("Salary: " + salary);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
