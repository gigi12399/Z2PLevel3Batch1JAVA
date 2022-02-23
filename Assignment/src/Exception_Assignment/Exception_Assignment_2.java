package Exception_Assignment;

import java.util.Scanner;

public class Exception_Assignment_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try(Scanner sc = new Scanner(System.in)){
			String[] division = {"AA", "BB", "CC", "DD", "EE", "FF", "GG", "HH", "II", "JJ", "KK", "LL", "MM", "NN"};
			
			System.out.print("Enter your NRC NO: ");
			String nrc = sc.nextLine();
			
			String[] s = nrc.split("/");
			String[] t = s[1].split("[(]");
			String[] n = t[1].split("[)]");
			int index = Integer.parseInt(s[0])-1;
			System.out.println("Your NRC NO: " + nrc);
			if(index > division.length) {
				throw new ArrayIndexOutOfBoundsException ("The input NRC is invalid!");
			}
			System.out.println("Division: " + division[index]);
			System.out.println("Township: " + t[0]);
			System.out.println("Number: " + n[1]);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
