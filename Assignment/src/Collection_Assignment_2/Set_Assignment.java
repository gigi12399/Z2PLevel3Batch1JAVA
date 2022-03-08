package Collection_Assignment_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Set_Assignment {

	private static int rollCount = 0;
	public static void main(String[] args) {
		HashSet<Student> studentSet = new HashSet<>();
		
		// insert new students
		studentSet.add(new Student(1, "Thazin", 23));
		studentSet.add(new Student(12, "Yuki", 12));
		studentSet.add(new Student(3, "Aung Aung", 30));
		
		// sorting
		List<Student> studentList = new ArrayList<>(studentSet);
		Collections.sort(studentList);
		
		// Display
		studentList.forEach(stu -> {
			System.out.println("Roll No: " + stu.getRno());
			System.out.println("Name: " + stu.getName());
			System.out.println("Age: " + stu.getAge());
		});
		
		// update student data
		int update_rno = 1;
		String update_name = "Theingi";
		studentSet.forEach(s -> {
			if(s.getRno() == update_rno) {
				s.setName(update_name);
				System.out.println("\n" + "After update: " + "\n" + "----------------------------");
				System.out.println("Roll: " + s.getRno() + "\t" + "Name: " + s.getName()+ "\t" + "Age: " + s.getAge());
			}
		});
		
		
		
		
		// search student with roll no
		int search_rno = 16;
		studentSet.forEach(s -> {
			if(search_rno == s.getRno())
				System.out.println("\n" + "Search Roll No: " + search_rno + "\t" + "Student Name: " + s.getName());
			else
				rollCount++;
		});
		
		if(rollCount == studentSet.size())
			System.out.println("\n" + "Invalid Roll no.");
		
		// delete student with roll no
		int delete_rno = 12;
		studentSet.removeIf(s -> s.getRno() == delete_rno);
		
		System.out.println("\n" + "After Delete: " + "\n" + "-----------------------------------");

		studentSet.forEach(s -> System.out.println("Roll No: " + s.getRno() + "\t" + "Name: " + s.getName() + "\t" + "Age: " + s.getAge()));
		
	}
}
