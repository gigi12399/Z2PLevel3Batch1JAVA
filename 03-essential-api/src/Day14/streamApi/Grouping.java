package Day14.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
			);
		
		// count
		Map<String, Long> counting = empList.stream()
											.collect(
													Collectors.groupingBy(e -> e.getCity(), Collectors.counting())
													);
		// sum 
		Map<String, Integer> sum = empList.stream()
											.collect(Collectors.groupingBy(e -> e.getCity(), Collectors.summingInt(e-> e.getSalary())));
		
		// avg
		Map<String, Double> avg = empList.stream()
											.collect(Collectors.groupingBy(e -> e.getCity(), Collectors.averagingDouble(e -> e.getSalary())));
		
		
		System.out.println("counting: " + counting);
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + avg);
		
		System.out.println("-------------------------------------");
		
		Map<Integer, List<Employee>> groupBySalary = empList.stream()
															.collect(
																	Collectors.groupingBy(e -> e.getSalary())
																	);
		
		groupBySalary.forEach((k,v)->{
			System.out.println(k + " ks. ");
			v.forEach(emp -> System.out.println("\t" + emp.getName() + ", " + emp.getCity()));
		});
		
//		System.out.println("------------------------------------");
//		Map<String, List<String>> groupByCity = empList.stream()
//														.collect(
//																Collectors.groupingBy(Employee::getCity),
//																Collectors.mapping(Employee::getName, Collectors.toList())
//																);
//		
//		System.out.println("Group By City: " + groupByCity);
		
		System.out.println("-----------------------------");
		// having clause in sql
		Map<String, List<Employee>> data = 
				empList.stream()
				.collect(
						Collectors.collectingAndThen(Collectors.groupingBy(Employee::getCity),
							tmp -> tmp.entrySet()/// city => List<emp>
										.stream()
										.filter(v -> v.getValue().size() > 1)
										.collect(Collectors.toMap(v -> v.getKey(), v -> v.getValue()))
						 )
						);
		System.out.println("Data: " + data);
									 						
	}
}
