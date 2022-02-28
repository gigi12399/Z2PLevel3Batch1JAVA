package class_object_assignment;

import java.util.Scanner;

public class BankAccount {
	public int accountNo;
	public String holderName;
	private String pinNo;
	private String password;
	public int balance;
	
	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getPinNo() {
		return pinNo;
	}

	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public BankAccount(int accountNo, String holderName, String pinNo, String password, int balance) {
		setAccountNo(accountNo);
		setHolderName(holderName);
		setPinNo(pinNo);
		setPassword(password);
		setBalance(balance);
	}

	public int deposit(int add_amount) {
		return balance = balance + add_amount;
	}
	
	public int withdaw(int withdaw_amount) throws InsufficientAmountException {
		if(withdaw_amount > balance)
			throw new InsufficientAmountException("Your balance is not enough for your withdaw amount!");
		else 
			balance = balance - withdaw_amount;
		return balance;
	}
	
	public void changePassword() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your pin No: ");
		String pin_no = sc.nextLine();
		if(pin_no.equals(pinNo)) {
			System.out.print("Enter New Password: ");
			password = sc.nextLine();
			String newpassword;
			do {
				System.out.print("Enter again your new Password: ");
				newpassword = sc.nextLine();
			}while(!newpassword.equals(password));
			System.out.println("Your password is successfully changed.");
			showInfo();
				
		}else{
			System.out.println("Invalid pin number");
			changePassword();
		}
		sc.close();
	}
	
	public void showInfo() {
		System.out.println("***** Your Bank Account Details *****");
		System.out.println("Account No: " + getAccountNo());
		System.out.println("Name: " + getHolderName());
		System.out.println("Pin No: " + getPinNo());
		System.out.println("Password: " + getPassword());
		System.out.println("Balance: " + getBalance());
		System.out.println("************* ----------- ************");
	}
	
	
	
}
