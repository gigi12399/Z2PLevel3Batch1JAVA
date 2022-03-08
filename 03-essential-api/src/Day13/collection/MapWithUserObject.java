package Day13.collection;

import java.util.HashMap;
import java.util.Map;

public class MapWithUserObject {

	public static void main(String[] args) {
		Map<Integer, Employee> employees = new HashMap<>();
		
		employees.put(1001, new Employee(1001, "Nyi Nyi", "Yangon"));
		employees.put(1002, new Employee(1002, "Htet Htet", "Pyin Oo Lwin"));
		employees.put(1003, new Employee(1003, "Naung Naung", "Yangon"));
		employees.put(1004, new Employee(1004, "Aung Aung", "Mandalay"));
		
		employees.forEach((k,emp) -> {
			System.out.println(emp.getId() + ", " + emp.getName() + ", " + emp.getCity());
		});
		
		Employee emp = employees.get(1005);
		if(emp != null) {
			System.out.println("Id: " + emp.getId());
			System.out.println("Name: " + emp.getName());
			System.out.println("City: " + emp.getCity());
		}else {
			System.out.println("Employee with ID - 1005 does not exist.");
		}
		
		employees.forEach((k,v) -> {
			if(v.getCity().equalsIgnoreCase("yangon"))
				System.out.println(v.getName());
				
		});

	}

}
