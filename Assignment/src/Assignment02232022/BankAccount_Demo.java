package Assignment02232022;

import java.util.Scanner;

public class BankAccount_Demo {

	public static void main(String[] args) {
		try {
			BankAccount acc = new BankAccount();
			acc.setAccountNo(1022);
			acc.setHolderName("Tsu Tsu");
			acc.setPinNo("123");
			acc.setPassword("tsu123");
			acc.setBalance(200000);
			acc.showInfo();
			System.out.println("Balance after withdaw: " + acc.withdaw(10000));
			System.out.println("Balance after add amount: " + acc.deposit(10000));
			acc.changePassword();
			
		} catch (InsufficientAmountException e) {
			System.err.println(e.getMessage());
		}
	}

}
