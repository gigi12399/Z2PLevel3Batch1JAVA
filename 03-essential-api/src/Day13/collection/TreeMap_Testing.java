package Day13.collection;

import java.util.TreeMap;

public class TreeMap_Testing {
	public static void main(String[] args) {
		TreeMap<String, String> fileExtens = new TreeMap<>();
		
		fileExtens.put("java", ".java");
		fileExtens.put("php", ".php");
		fileExtens.put("c++", ".cpp");
		fileExtens.put("html", ".html");
		fileExtens.put("javascript", ".js");
		
		System.out.println(fileExtens);
		
		fileExtens.remove("c++");
		System.out.println("After remove: " + fileExtens);
	}
}
