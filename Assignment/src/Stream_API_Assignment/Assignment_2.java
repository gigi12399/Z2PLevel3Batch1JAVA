package Stream_API_Assignment;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
public class Assignment_2 {

	public static void main(String[] args) {
		List<Employee> employee = new ArrayList<>();
		
		employee.add(new Employee("Htet Htet", "Yangon", "Electronics", 900000, "1991-10-16"));
		employee.add(new Employee("Cherry", "Yangon", "Electronics", 820000, "1994-08-14"));
		employee.add(new Employee("Kyaw Kyaw", "Yangon", "Electronics", 780000, "1988-09-02"));
		employee.add(new Employee("Aung Aung", "Mandalay", "IT", 600000, "1995-01-11"));
		employee.add(new Employee("Jeon", "Mandalay", "IT", 600000, "1997-09-01"));
		employee.add(new Employee("Hsu Hsu", "Pyin Oo Lwin", "IT", 920000, "1994-12-10"));
		employee.add(new Employee("Aye Aye", "Yangon", "HR", 500000, "1992-10-10"));
		employee.add(new Employee("Gay Gay", "Taung Gyi", "HR", 400000, "1996-05-12"));
		employee.add(new Employee("Phway Phway", "Monywa", "HR", 300000, "1995-09-03"));
		employee.add(new Employee("Ko Ko", "Monywa", "IT", 500000, "1992-11-11"));
	
		int minSalary = employee.stream()
								.mapToInt(e -> e.getSalary())
								.min()
								.getAsInt();
		System.out.println("Minimum salary: " + minSalary);
		System.out.println("-----------------------------------");
		
		Employee youngest = employee.stream()
									.max(Comparator.comparing(e -> e.getBirthday()))
									.get();
		System.out.println("Youngest employee information: ");
		System.out.println("Name: " + youngest.getName() + "\t" + "City: " + youngest.getCity() + "\t" + "Department: " + youngest.getDepartment() + "\t" + "Salary: " + youngest.getSalary() + "\t" + "Birthday: " + youngest.getBirthday());
		System.out.println("-----------------------------------");
		
		Long count = employee.stream()
							.filter(e -> e.getBirthday().isEqual(LocalDate.of(1995, 02, 12)) || e.getBirthday().isAfter(LocalDate.of(1995, 02, 12)))
							.count();
		System.out.println("Number of employee whose birthday is greater than or equal 1995-02-12: " + count);
		System.out.println("------------------------------------");
		
		int total = employee.stream()
							.mapToInt(Employee::getSalary)
							.sum();
		System.out.println("Total salary of all employees: " + total);
		System.out.println("-----------------------------------");
		
		List<Employee> max3 = employee.stream()
							.sorted(Comparator.comparing(Employee::getSalary).reversed())
							.limit(3)
							.collect(Collectors.toList());
		
		System.out.println("Three max salaries: ");
		max3.forEach(e -> System.out.println("Name: " + e.getName() + "\t" + "City: " + e.getCity() + "\t" + "Department: " + e.getDepartment() + "\t" + "Salary: " + e.getSalary() + "\t" + "Birthday: " + e.getBirthday()));
		System.out.println("--------------------------------------");
		
		double avgSalary = employee.stream()
								.filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
								.mapToInt(e -> e.getSalary())
								.average()
								.getAsDouble();
		
		System.out.println("Average salary of department HR: " + avgSalary);
		System.out.println("---------------------------------------");
		
		Employee lowestEmployee = employee.stream()
				.min(Comparator.comparing(Employee::getSalary))
				.get();
								
		System.out.println("Employee who gets lowest salary: ");
		System.out.println("Name: " + lowestEmployee.getName() + "\t" + "City: " + lowestEmployee.getCity() + "\t" + "Department: " + lowestEmployee.getDepartment() + "\t" + "Salary: " + lowestEmployee.getSalary() + "\t" + "Birthday: " + lowestEmployee.getBirthday());
		System.out.println("----------------------------------------");
		
		Map<Object, Optional<Employee>> eachCitySalary = employee.stream()
				.collect(Collectors.groupingBy(e -> e.getCity(),
						Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))
						));
		
		System.out.println("Highest salary of employee in each city:");
		eachCitySalary.forEach((c,s) ->{
			System.out.println("City: " + c);
			System.out.println("Salary: " + s); 
		});
		System.out.println("---------------------------------------------");
									
		
		Map<Integer, List<Employee>> sameSalary = employee.stream()
				.collect(
						Collectors.collectingAndThen(Collectors.groupingBy(Employee::getSalary),
							tmp -> tmp.entrySet()
										.stream()
										.filter(v -> v.getValue().size() > 1)
										.collect(Collectors.toMap(v -> v.getKey(), v -> v.getValue()))
						 )
						);
		
		System.out.println("List of employee who got the same salary:");
		sameSalary.forEach((k,v) -> {
			System.out.println("Salary: " + k);
			System.out.println("Employee: " + v);
		});
		System.out.println("-----------------------------------------");
		
		
		Map<String, List<Employee>> sameDepartment = employee.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		System.out.println("List of employee who got the same salary:");
		sameDepartment.forEach((k,v) -> {
			System.out.println("Department: " + k);
			v.forEach(emp -> System.out.println(emp.getName() + "\t"));
			System.out.println();
		});
		System.out.println("-----------------------------------------");
		
		
		
	}
}
