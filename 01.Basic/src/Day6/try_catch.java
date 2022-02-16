package Day6;

import java.util.Scanner;

public class try_catch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number1: ");
			int num1 = Integer.parseInt(sc.nextLine()); // create NumberFormatExp obj
			
			System.out.println("Enter number2: ");
			int num2 = Integer.parseInt(sc.nextLine());
			
			int result = num1/num2; // create Arithmetic, throw obj
			System.out.println("Output: " + result);
		}catch(ArithmeticException | NumberFormatException e) {
			System.err.println(e.getMessage());
		}
		//catch(ArithmeticException e){
//			System.err.println(e.getMessage());
//		}catch(NumberFormatException e) {
//			System.err.println("User input is not a number");
//		}
		System.out.println("Outside try_catch block!");
	}

}
