package Assignment;

import java.util.Scanner;

public class Basic_ass_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		System.out.println("Enter email: ");
		String email = sc.nextLine();
		System.out.println("Enter phone number: ");
		String ph_no = sc.nextLine();
		System.out.println("Enter your education: ");
		String edu = sc.nextLine();
		System.out.println("Enter income: ");
		double income = sc.nextDouble();
		System.out.println("Enter age: ");
		int age = sc.nextInt();
		
		
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("Phone No: " + ph_no);
		System.out.println("Education: " + edu);
		System.out.println("Income: " + income);
		System.out.println("Age: " + age);
		sc.close();
	}

}
