package Day1;

public class StaticData {
	public static void main(String[] args) {
		try {
			Employee emp1 = new Employee();
			emp1.initData("Jeon", 900000);
			
			Employee emp2 = new Employee();
			emp2.initData("Cherry", 1000000);
			
			Employee emp3 = new Employee();
			emp3.initData("Aung Aung", 800000);
			
			
			System.out.println("***** emp1 Data *****");
			emp1.showData();
			
			System.out.println("***** emp2 Data *****");
			emp2.showData();
			
			System.out.println("***** emp3 Data *****");
			emp3.showData();
			
			Employee.changeNoOfEmployee(10);
			System.out.println("Current Total Employee: " + Employee.noOfEmployee);
			
			Employee emp4 = new Employee();
			emp4.initData("Honey", 400000);
			emp4.viewInformation();
			
		} catch (AppException e) {
			System.err.print(e.getMessage());
		}
//		Employee.noOfEmployee = 50;
//		System.out.println("No of Employee: " + Employee.noOfEmployee);
//		
//		Employee emp1 = new Employee();
//		System.out.println("emp1's no of employee: " + emp1.noOfEmployee);
//		
//		Employee emp2 = new Employee();
//		System.out.println("emp2's no of employee: " + emp2.noOfEmployee);
//		
//		emp1.noOfEmployee = 100;
//		
//		System.out.println("emp2's no of employee: " + emp2.noOfEmployee);
	}
}

class Employee{
	static int noOfEmployee = 3;
	static int nextId = 1;
	final int empId;
	String name;
	int salary;
	
	{
		
	}
	
	public Employee() throws AppException {
		if(nextId > noOfEmployee) { 
			throw new AppException("Sorry, Limited number has been reached");
		}
		empId = nextId;
		nextId++;
	}
	
	public void initData(String name, int sal) {
		this.name = name;
		this.salary = sal;
	}
	
	public void changeData(String editName, int editSal) {
		if(editName.equalsIgnoreCase(this.name))
			this.name = editName;
		if(editSal != this.salary)
			this.salary = editSal;
	}
	
	public void showData() {
		System.out.println(this.empId + "\t" + this.name + "\t" + this.salary);
	}
	
	public static void changeNoOfEmployee(int count) {
		noOfEmployee = count;
		// can't access instance variables
	}
	
	public void viewInformation() {
		// access instance & static data
		System.out.println("Total: " + noOfEmployee);
		System.out.println("Current Employee Information: ");
		showData();
		System.out.println("Next Employee id: " + nextId);
	}
	
}

class AppException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AppException(String msg) {
		super(msg);
	}
}
