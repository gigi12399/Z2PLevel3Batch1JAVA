package Day12.collection;

import java.util.LinkedList;

public class LinkList_Testing {
	public static void main(String[] args) {
		LinkedList<String> lList = new LinkedList<>();
		
		lList.add("Nilar");
		lList.add(0,"Aung");
		lList.add("Kyaw");
		
		System.out.println(lList);
		
		lList.addFirst("Jeon");
		lList.addLast("Cherry");
		
		System.out.println(lList);
		System.out.println(lList.get(2));
		System.out.println(lList.getLast());
		System.out.println(lList.getFirst());
	}
}
