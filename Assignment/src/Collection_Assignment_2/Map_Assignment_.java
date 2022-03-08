package Collection_Assignment_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Map_Assignment_ {

	public static void main(String[] args) {
		HashMap<Integer, Student> studentMap = new HashMap<>();
		
		// insert new students
		studentMap.put(1, new Student(1, "Thazin", 23));
		studentMap.put(13, new Student(13, "Yuki", 12));
		studentMap.put(51, new Student(51, "Aung Aung", 30));
		
		// sorting

		TreeMap<Integer, Student> studentTreeMap = new TreeMap<>();
		studentTreeMap.putAll(studentMap);
		
		// Display
		System.out.println("***** All Students *****");
		studentTreeMap.forEach((k,v) -> {
			System.out.println("Roll: " + v.getRno() + "\t" + "Name" + v.getName() + "\t" + "Age: " + v.getAge());
		});
		
		// update student data
		studentTreeMap.replace(51, new Student(51, "Rin", 25));
		System.out.println("\n" + "***** After update *****");
		System.out.println("Id: " + studentTreeMap.get(51).getRno());
		System.out.println("Name: " + studentTreeMap.get(51).getName());
		
		// search student with roll no
		int searchRoll = 13;
		Student  searchStudent= studentTreeMap.get(searchRoll);
		System.out.println("\n" + "After search: " + "\n" + "---------------------------");
		if(searchStudent != null)
			System.out.println("Roll: " + searchStudent.getRno() + "\t" + "Name: " + searchStudent.getName() + "\t" + "Age: " + searchStudent.getAge());
		else
			System.out.println("Invalid Roll no");
		
		
		// delete student with roll no
		int deleteRoll = 1;
		studentTreeMap.keySet().removeIf(stu -> stu == deleteRoll);
		
		System.out.println("\n" + "After delete: " + "\n" + "-------------------------");
		studentTreeMap.forEach((k,v) -> System.out.println("Roll: " + v.getRno() + "\t" + "Name: " + v.getName() + "\t" + "Age: " + v.getAge()));
	}

}
