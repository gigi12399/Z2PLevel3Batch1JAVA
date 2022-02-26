package Day9.inheritance;

public class Student extends Person {
	private int rno;
	
	public Student(int rno, String name, String phone) {
		super(name,phone); // calling parameterized constructor form person
		this.rno = rno;
	}
	
	public int getRno() {
		return rno;
	}
}
