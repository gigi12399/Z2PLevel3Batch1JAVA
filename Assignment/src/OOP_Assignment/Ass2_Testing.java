package OOP_Assignment;

import java.util.Scanner;

public class Ass2_Testing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Ass2_Teacher teacher1 = new Ass2_Teacher("Phyo Win Htut", "12/Thanlyin(N)67896", "234/A thanlyin", "097654322","Head of Department", "Machanical Engineering", 600000);
		teacher1.showTeacherInfo();
		System.out.println("--------------------------------" + "\n");
		System.out.print("Enter your new Position: ");
		String position = sc.nextLine();
		System.out.print("Enter your new department: ");
		String department = sc.nextLine();
		System.out.print("Enter your new Salary");
		int salary = sc.nextInt();
		teacher1.promote(position, salary);
		teacher1.transfer(department);
		teacher1.showTeacherInfo();
		sc.close();
	}

}
