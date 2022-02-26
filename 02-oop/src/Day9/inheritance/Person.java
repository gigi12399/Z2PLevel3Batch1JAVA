package Day9.inheritance;

public class Person {
	private String name;
	protected String phone;
	public Person(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	void display() {
		System.out.println("Name - " + name);
		System.out.println("Phone - " + phone);
	}
}
