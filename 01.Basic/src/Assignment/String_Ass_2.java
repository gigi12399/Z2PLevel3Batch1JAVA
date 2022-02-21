package Assignment;

import java.util.Scanner;

public class String_Ass_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] simple = {"am", "is", "are", "do"};
		
		System.out.print("Write any one sentences: ");
		String input = sc.nextLine().toLowerCase();
		if(input.contains("?")) {
			int count = 0;
			System.out.println("It is question sentence.");
			for(var st : simple) {
				if(input.contains(st)) {
					System.out.println("It is simple present tense question.");
					count = 1;
				}
			}
			if(count == 0)
				System.out.println("It isn't simple present tense question.");
		}else {
			System.out.println("It isn't question sentence.");
		}
		sc.close();
	}

}
