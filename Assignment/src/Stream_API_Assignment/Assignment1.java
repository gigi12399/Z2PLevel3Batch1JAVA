package Stream_API_Assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment1 {

	public static void main(String[] args) {
		List<Salespeople> salespeople = new ArrayList<>();
		
		salespeople.add(new Salespeople("Peel", "London", 0.12f));
		salespeople.add(new Salespeople("Serres", "San Jose", 0.13f));
		salespeople.add(new Salespeople("Motika", "London", 0.11f));
		salespeople.add(new Salespeople("Rifkin", "Barcelona", 0.15f));
		salespeople.add(new Salespeople("Axelrod", "New York", 0.10f));
		
		List<Salespeople> data = salespeople.stream()
											.filter(s -> s.getComm() > 0.10f && s.getCity().equalsIgnoreCase("London"))
											.collect(Collectors.toList());
											
		data.forEach(s -> System.out.println("Name: " + s.getName() + "\t" + "City: " + s.getCity()));
		System.out.println("-----------------------------------");
		
		List<Salespeople> data2 = salespeople.stream()
											.filter (s -> s.getComm() != 0.10f && s.getComm() != 0.13f && s.getComm() != 0.15f)
											.collect(Collectors.toList());
		
		data2.forEach(s -> System.out.println("Name: " + s.getName() + "City: " + s.getCity() + "Commission: " + s.getComm()));		
		System.out.println("------------------------------------");
		
		List<String> cities = salespeople.stream()
									.map(s -> s.getCity())
									.distinct()
									.collect(Collectors.toList());
		
		System.out.println("Cities name: " + cities);
		System.out.println("----------------------------------");
		
		List<Salespeople> top3 = salespeople.stream()
											.limit(3)
											.collect(Collectors.toList());
		
		top3.forEach(s -> System.out.println("Name: " + s.getName() + "\t" + "City: " + s.getCity()  + "\t" + "Commission: " + s.getComm()));
		System.out.println("-----------------------------------");
		
		
		List<Salespeople> rome = salespeople.stream()
											.filter(s-> s.getCity().equalsIgnoreCase("Rome"))
											.collect(Collectors.toList());
		
		rome.forEach(s -> System.out.println("Name: " + s.getName() + "\t" + "City: " + s.getCity()  + "\t" + "Commission: " + s.getComm()));
		System.out.println("-------------------------------------");
		
		long count = salespeople.stream()
								.filter(s -> s.getCity().equalsIgnoreCase("London")).count();
		System.out.println("Number of salespeople who live in London: " + count);
		System.out.println("--------------------------------------");
		
		List<Salespeople> data3 = salespeople.stream()
											.sorted(Comparator.comparing(Salespeople::getComm).reversed())
											.collect(Collectors.toList());
		
		data3.forEach(s -> System.out.println("Name: " + s.getName() + "\t" + "City: " + s.getCity()  + "\t" + "Commission: " + s.getComm()));
		System.out.println("-------------------------------------");
	}

}
