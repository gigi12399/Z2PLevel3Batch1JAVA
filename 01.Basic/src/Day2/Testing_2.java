package Day2;

import java.util.Scanner;

public class Testing_2 {
	// constant var
	static final float RATE = 1.5f;
	static final int MIN_PRICE = 1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter price: ");
		int price = sc.nextInt();
		if(price < MIN_PRICE)
			price = MIN_PRICE;
		
		System.out.println("Expense: " + (price * RATE));
		//RATE = 2.5f;
	}

}
