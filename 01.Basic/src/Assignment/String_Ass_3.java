package Assignment;

import java.util.Scanner;

public class String_Ass_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your NRC NO: ");
		String nrc = sc.nextLine();
		
		String[] s = nrc.split("/");
		String[] t = s[1].split("[(]");
		String[] n = t[1].split("[)]");
		
		System.out.println("Your NRC NO: " + nrc);
		System.out.println("Township: " + t[0]);
		System.out.println("Number: " + n[1]);
		
		sc.close();
		
	}

}
