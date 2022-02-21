package Assignment;

import java.util.Scanner;

class InvalidMarkException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidMarkException() {
		
	}
	public InvalidMarkException(String msg) {
		super(msg);
	}
}

public class Exception_Assignment_3 {
	static void checkMark(int mark) throws InvalidMarkException {
		if(mark < 0 || mark > 100) {
			throw new InvalidMarkException ("Your mark is invalid!");
		}else {
			System.out.println("Your mark: " + mark);
		}
	}
	public static void main(String[] args){
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("Enter any mark between 0 and 100: ");
			int mark = sc.nextInt();
			checkMark(mark);
		}catch(InvalidMarkException e) {
			System.err.println(e.getMessage());
		}
	}
}
