package Day13.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.print.DocFlavor.STRING;

public class Set_Testing {
	public static void main(String[] args) {
		HashSet<String> set1 = new HashSet<>();
		
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Strawberry");
		set1.add("Mango");
		
		System.out.println(set1);
		
		set1.remove("Apple");
		
		System.out.println("After remove: " + set1);
		
		Set<String> set2 = Set.of("Potato", "PineApple");
		
		set1.addAll(set2);
		
		System.out.println("After add: " + set1);
		
		// linkedHashSet
		System.out.println("-----------------------------------");
		LinkedHashSet<String> set3 = new LinkedHashSet<>();
		
		set3.add("Orange");
		set3.add("Apple");
		set3.add(null);
		set3.add("Strawberry");
		set3.add("Mango");
		set3.add("Potatos");
		
		set3.forEach(System.out::println);
		
		set3.remove(null);
		set3.removeIf(d -> d.contains("o"));
		
		System.out.println("After remove: " + set3);
		
		// treeset
		System.out.println("-----------------------------");
		TreeSet<String> set4 = new TreeSet<>();
		set4.add("Orange");
		set4.add("Apple");
		// set4.add(null);
		set4.add("Mango");
		set4.add("Strawberry");
		
		Iterator<String> itr = set4.iterator();
		itr.forEachRemaining(s -> System.out.println(s));
		
		Set<String> set5 = set4.descendingSet();
		
		System.out.println("After desc: " + set5);
		
	}
}
