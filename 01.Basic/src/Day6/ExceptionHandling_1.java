package Day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExceptionHandling_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number1: ");
		int num1 = sc.nextInt();
		System.out.println("Enter number2: ");
		int num2 = sc.nextInt();
		
		int result = num1/num2; // create ArithmeticException, throws obj
		System.out.println("Output: " + result);
		
		sc.close();
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter age: ");
//		int age = Integer.parseInt(br.readLine());
//		
//		System.out.println("Your age: " + age);
	}

}
