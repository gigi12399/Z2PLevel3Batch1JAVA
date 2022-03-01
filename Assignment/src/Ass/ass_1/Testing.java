package Ass.ass_1;

import java.util.Scanner;

public class Testing {
	public static void main(String[] args) {
		Student[] data = new Student[4];
		
		// initialize data
		initializeData(data);
		
		// display
		displayData(data);
		
		// search
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id to search: ");
		int id = Integer.parseInt(sc.nextLine());
		searchStudent(id,data);
		
		// find max mark
		findMaximumMark(data);
		
		// find average mark
		findAverageMark(data);
		sc.close();
	}

	private static void findAverageMark(Student[] data) {
		// find average
		
	}

	private static void findMaximumMark(Student[] data) {
		// find max
		
	}

	private static void searchStudent(int id, Student[] data) {
		for(var std : data) {
			if(id == std.getStudentId()) {
				std.display();
			}else {
				System.out.println("Student id-" + id + " is not found!");
			}
		}
		
	}

	private static void displayData(Student[] data) {
		for(var std : data) {
			std.display();
			System.out.println("-------------------------------");
		}
		
	}

	private static void initializeData(Student[] data) {
		
		try(Scanner sc = new Scanner(System.in)) {
			for(var x = 0; x < data.length; x++) {
				System.out.print("Enter Id: ");
				data[x].setStudentId(Integer.parseInt(sc.nextLine()));
				System.out.print("Enter Name: ");
				data[x].setName(sc.nextLine());
				System.out.print("Enter mark: ");
				data[x].setMark(Integer.parseInt(sc.nextLine()));
			}
		}catch(Exception e) {
			System.err.print(e.getMessage());
		}
	}
}
