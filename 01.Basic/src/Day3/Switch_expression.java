package Day3;

import java.util.Scanner;

public class Switch_expression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Food Name: ");
		String name = sc.nextLine();
		
//		var category = 	switch(name) {
//						case "buger","pizza", "sandwich" -> "Fast Food";
//						case "yogurt", "milk tea" -> "Dessert";
//						case "monhinga" -> "Burmese Food";
//						case "sushi" -> "Japanese Food";
//						default -> "unknown";
//						};
		
		var category = 	switch(name) {
							case "buger","pizza", "sandwich" -> {
								if(name.equals("pizza"))
									System.out.println(name + " is an Italian Food");
								yield "Fast Food";
							}
							case "yogurt", "milk tea" -> {yield "Dessert";}
							case "monhinga" -> "Burmese Food";
							case "sushi" -> "Japanese Food";
							default -> "unknown";
							};
		System.out.println(name + " is " + category);
		sc.close();
	}
}
