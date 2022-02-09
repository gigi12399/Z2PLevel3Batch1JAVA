package Day3;

import java.util.Scanner;

public class Conditional_Statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter language name: ");
		String input = sc.nextLine();
		
		if(input.equals("java")) // Java = java
			System.out.println("Best Programming Language");
	}

}
