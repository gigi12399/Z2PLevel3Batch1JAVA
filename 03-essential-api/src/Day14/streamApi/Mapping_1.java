package Day14.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping_1 {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(
					new Employee("Kyaw Kyaw", 9800, "Yangon"),
					new Employee("Aung Aung", 6000, "Mandalay"),
					new Employee("Mg Mg", 10000, "Mandalay"),
					new Employee("Yuri", 6000, "Yangon"),
					new Employee("Jeon", 7800, "Monywa")
				);
		List<String> distinctCities = empList.stream()
											.map(emp -> emp.getCity())
											.distinct() // unique
											.collect(Collectors.toList());
		System.out.println(distinctCities);
		
		int[] salaries = empList.stream()
								.filter(e -> e.getSalary() > 6000)
								.mapToInt(e -> e.getSalary())// convert int
								.toArray();
		for(int sal : salaries)
			System.out.println(sal);
		
		System.out.println("**** salary < 10000 ****");
		List<Integer> salaryList = empList
										.stream()
										.map(e -> e.getSalary())// int
										.filter(s -> s < 10000)
										.limit(3)
										.collect(Collectors.toList());
		System.out.println(salaryList);
		
		System.out.println("*** Max Salary ***");
		int maxSalary = empList.stream()
								.mapToInt(Employee::getSalary)
								.max()
								.getAsInt();
		
		int minSalary = empList.stream()
								.mapToInt(Employee::getSalary)
								.min()
								.getAsInt();
		System.out.println("Maximum salary: " + maxSalary);
		System.out.println("Minimum salary: " + minSalary);
		}
}

class Employee{
	private String name;
	private int salary;
	private String city;
	public Employee(String name, int salary, String city) {
		super();
		this.name = name;
		this.salary = salary;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", city=" + city + "]";
	}
	
	
}
