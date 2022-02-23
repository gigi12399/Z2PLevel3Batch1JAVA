package Date_Time_Assignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Date_Time_ass_2 {

	String[] menu =  {"Pizza", "Burger", "Milk Tea", "Spicy Noodle"};
	String[] townships = {"AA","BB","CC","DD"};
	int[] times = {15,30,10,45};
	int menu_no;
	int township_no;
	int order_no;
	
	void menuDisplay(Scanner sc) {
		System.out.println("***** Available Menu *****");
		for(int i = 0; i<menu.length; i++) {
			int no = i+1;
			System.out.println(no + "." + menu[i]);
		}
		System.out.print("Please choose item's number: ");
		this.menu_no = sc.nextInt();
		if(menu_no > menu.length) {
			System.out.println("\n" + "Your menu's number does not exit." + "\n" + "Choose again from given number: ");
			
		}
	}
	
	void townshipDisplay(Scanner sc) {
		System.out.println("\n" + "***** Deliverable Township *****");
		for(int i = 0; i<townships.length; i++) {
			int no = i+1;
			System.out.println(no + "." + townships[i] + " (" + times[i] + " mins)");
		}
		System.out.print("Please choose Township: ");
		this.township_no = sc.nextInt();
	}
	
	void orderType(Scanner sc) {
		System.out.println("\n" + "***** Order Type *****");
		System.out.println("1.Order Now?");
		System.out.println("2.Preorder?");
		System.out.print("Please choose 1 or 2: ");
		this.order_no = sc.nextInt();
	}
	
	void orderDisplay(Scanner sc,LocalTime current_time,LocalDate current_date) {
		if(order_no == 1) {
			LocalTime arrival_time = current_time.plusMinutes(times[--township_no]);
			System.out.println("\n" + "***** Your Order Information *****");
			System.out.println("Item Name: " + menu[--menu_no]);
			System.out.println("Your Address: " + townships[township_no]);
			System.out.println("Duration: " + times[township_no] + " mins");
			System.out.println("Arrival Time: " + arrival_time.format(DateTimeFormatter.ofPattern("hh:mm:ss a")));
			System.out.println("******** Thank you for your ordering *******");
		}else if(order_no == 2){
			System.out.print("\n" + "Enter delivery date(dd): ");
			int date = sc.nextInt();
			int current = current_date.getDayOfMonth();
			int increase_day = date - current;
			System.out.println("\n" + "***** Your Order Information *****");
			System.out.println("Item Name: " + menu[--menu_no]);
			System.out.println("Your Address: " + townships[--township_no]);
			System.out.println("Arrival Date: " + current_date.plusDays(increase_day));
			System.out.println("******** Thank you for your ordering *******");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LocalTime current_time = LocalTime.now();
		LocalDate current_date = LocalDate.now();

		Date_Time_ass_2 obj = new Date_Time_ass_2();
		obj.menuDisplay(sc);
		
		obj.townshipDisplay(sc);
		
		obj.orderType(sc);
		
		obj.orderDisplay(sc,current_time,current_date);
		
		
	}

}
