package Day12.collection;

import java.util.Stack;

public class Stack_Testing {
	public static void main(String[] args) {
		Stack<String> cities = new Stack<>();
		
		cities.push("Yangon");
		cities.push("Mandalay");
		cities.push("Pyin Oo Lwin");
		
		System.out.println(cities);
		
		cities.pop(); // remove object
		System.out.println("After pop: " + cities);
	}
}
