package Collection_Assignment_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Assignment_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] students = {"aung aung", "kyaw kyaw", "cherry", "yuki", "tsu tsu", "naung naung", "jeon", "rin", "khin khin"};
		// Show all students name
		System.out.println("All Students: " + "\n" + Arrays.toString(students));
		
		ArrayList<String> student = new ArrayList<>(Arrays.asList(students));
		
		// Sorting
		Collections.sort(student);
		
		// Show sorted list
		System.out.println("After sorting: " + "\n" + "-----------------------------");
		student.forEach(s -> System.out.println(s));
		
		// search student
		System.out.print("\n" + "Enter student's name that you want to search: ");
		String searchStudent = sc.nextLine().toLowerCase();
		
		int index = Collections.binarySearch(student, searchStudent);
		System.out.println((index >= 0) ? (searchStudent + "'s position in the list: " + index) : "Invalid Student");
		
		// insert student
		System.out.print("Enter new student name: ");
		String stuName = sc.nextLine().toLowerCase();
		if(student.contains(stuName))
			System.out.println(stuName + " is already included in the list.");
		else {
			student.add(stuName);
			Collections.sort(student);
			System.out.println("\n" + "Afer inserting new student: " + "\n" + "------------------------------");
			student.forEach(s -> System.out.println(s));
		}
		
		System.out.println("-------------------------------");
		
		// Show start with "K" or "k"
		System.out.println("Students who start with \"K\" or \"k\": ");
		student.forEach(s -> {
			if(s.startsWith("K") || s.startsWith("k"))
				System.out.println(s);
		});
		
		System.out.println("------------------------------------");
		
		// Remove end with "G" or "g"
		student.removeIf(stu -> stu.endsWith("G") || stu.endsWith("g"));
		System.out.println("After remove: ");
		student.forEach(stu -> System.out.println(stu));
		
		// clear
		student.clear();
		System.out.println("\n" + "After clear: " + "\n" + "-----------------------");
		System.out.println(student);
		
		sc.close();
	}
	
}
