package Day14.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Reducting_1 {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
			);
		
		int total = empList.stream().mapToInt(e -> e.getSalary()).sum();
		double avgSal = empList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
		int maxSalary = empList.stream().mapToInt(Employee::getSalary).max().getAsInt();
		long count = empList.stream().filter(e -> e.getSalary() > 6000).count();
		Employee maxEmp = empList.stream().max(Comparator.comparingInt(e -> e.getSalary())).get();
		Employee minEmp = empList.stream().min((e1,e2) -> e1.getSalary() - e2.getSalary()).get();
		
		System.out.println("Total Salary: " + total);
		System.out.println("Averge Salary: " + avgSal);
		System.out.println("Max Salary: " + maxSalary);
		System.out.println("Count: " + count);
		System.out.println("Employee with Highest Salary: " + maxEmp);
		System.out.println("Employee with lowest Salary: " + minEmp);
		
		System.out.println("***** Custom Reduction *****");
		int totalSalary = empList.stream()
				.map(Employee::getSalary)
				.reduce(0, (s1,s2) -> s1 + s2);
		
		int minSalary = empList.stream()
				.mapToInt(e -> e.getSalary())
				.reduce(Integer::min)
				.getAsInt();
		
		Employee empMax = empList.stream()
				.reduce((e1, e2) -> e1.getSalary() < e2.getSalary() ? e2 : e1)
				.get();
		
		System.out.println("Total Salary: " + totalSalary);
		System.out.println("Min Salary: " + minSalary);
		System.out.println("Max Salary: " + maxSalary);
		
		
	} 
}
