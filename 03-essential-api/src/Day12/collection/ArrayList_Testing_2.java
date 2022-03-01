package Day12.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class ArrayList_Testing_2 {
	public static void main(String[] args) {
		String[] data = {"Aung Aung", "Jeon", "Yuki", "Maung Maung"};
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(data));
		
		list.add("Jeon");
		
		System.out.println(list);
		Collections.sort(list);// sorting asc
		System.out.println("*** After sort ***");
		System.out.println(list);
		Collections.reverse(list);
		System.out.println("After reverse order: " + list);
		
		int result = Collections.binarySearch(list, "Jeon");
		System.out.println((result < 0) ? "Jeon is not found" : "Jeon is found");
		
		result = Collections.binarySearch(list, "May");
		System.out.println((result < 0 ) ? "May is not found" : "May is found");
		
		if(list.contains("Yuki"))
			System.out.println("Yuki is found");
		
		// remove
		list.remove("Jeon");
		System.out.println("After remove: " + list);
		
		list.removeIf(s -> (s.endsWith("ung") && s.length() > 9));
		System.out.println("After remove: " + list);
	}
}
