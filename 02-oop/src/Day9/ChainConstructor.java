package Day9;

public class ChainConstructor {
	public ChainConstructor() {
		this(1,2);
		System.out.println("This is default constructor.");
	}
	
	public ChainConstructor(int x) {
		System.out.println("This is one argument constructor.");
	}
	
	public ChainConstructor(int x, int y) {
		System.out.println("This is two argument constructor.");
	}
}

class Employee{
	public String name;
	public Employee() {
		
	}
	public Employee(String name) {
		this.name = name;
	}
}

class Teacher extends Employee{
	private String position;
	
	public Teacher(String name,String pos) {
		super(name);
		this.position = pos;
		super.name = name;
	}
}
