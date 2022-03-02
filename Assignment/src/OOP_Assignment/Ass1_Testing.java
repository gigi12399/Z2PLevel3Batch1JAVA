package OOP_Assignment;

import java.util.Scanner;

public class Ass1_Testing {
	public static void main(String[] args) {
		Ass1_Student[] data = new Ass1_Student[4];
		Scanner sc = new Scanner(System.in);
		
		// initialize data
		initializeData(sc,data);
		
		// display
		displayData(data);
		
		// search
		searchStudent(sc,data);
		
		// find max mark
		findMaximumMark(data);
		
		// find average mark
		findAverageMark(data);
		
		sc.close();
	}

	private static void findAverageMark(Ass1_Student[] data) {
		int total = 0;
		for(var std : data)
			total += std.getMark();
		System.out.println("Average marks over all students: " + (float)total/data.length);
	}

	private static void findMaximumMark(Ass1_Student[] data) {
		int max = data[0].getMark();
		String[] name = new String[4];
		int j = 0;
		for(int i = 0; i < data.length; i++) {
			if(max < data[i].getMark()) {
				max = data[i].getMark();
				name[j] = data[i].getName();
			}
			if(max == data[i].getMark())
				name[j++] = data[i].getName();
		}
		for(int i = 0; i < name.length; i++) {
			if(name[i] != null)
				System.out.print("Student: " + name[i] + " ");
		}
		if(name.length > 1)
			System.out.println(" get maximum mark: " + max);
		else
			System.out.println(" gets maximum mark: " + max);
		
	}

	private static void searchStudent(Scanner sc, Ass1_Student[] data) {
		try{
			System.out.print("Enter student id to search: ");
			int id = Integer.parseInt(sc.nextLine());
			int num = 1;
			for(var std : data) {
				if(id == std.getStudentId()) {
					std.display();
					System.out.println("--------------------------------");
					num = -1;
				}
			}
			if(num == 1) {
				System.out.println("Student id-" + id + " is not found!");
				System.out.println("------------------------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void displayData(Ass1_Student[] data) {
		for(var std : data) {
			std.display();
			System.out.println("-------------------------------");
		}
		
	}

	private static void initializeData(Scanner sc, Ass1_Student[] data) {
		try {
			for(var x = 0; x < data.length; x++) {
				System.out.print("Enter Id: ");
				int id = Integer.parseInt(sc.nextLine());
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				System.out.print("Enter mark: ");
				int mark = Integer.parseInt(sc.nextLine());
				data[x] = new Ass1_Student(id, name, mark);
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}
}
