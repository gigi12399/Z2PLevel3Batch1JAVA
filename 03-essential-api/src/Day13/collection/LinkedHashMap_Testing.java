package Day13.collection;

import java.util.LinkedHashMap;

public class LinkedHashMap_Testing {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> students = new LinkedHashMap<>();
		
		students.put(11, "Aung Aung");
		students.put(5, "Kyaw Kyaw");
		students.put(8, "Honey");
		
		students.putIfAbsent(10, "Cherry");
		
		students.forEach((k,v) -> {
			System.out.println("Rno: " + k);
			System.out.println("Name: " + v);
		});
		
		students.replace(8, "Honey Tun");
		System.out.println(students);
		
		students.remove(8);
		System.out.println(students);
	}
}
