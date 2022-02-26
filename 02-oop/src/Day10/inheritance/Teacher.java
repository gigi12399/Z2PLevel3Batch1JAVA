package Day10.inheritance;

public class Teacher extends Person {
	private String position;
	public Teacher(String name, String pos) {
		super(name);
		this.position = pos;
	}
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Position: " + this.position);
		System.out.println("______________________________");
	}
	
	public void display() {
		
	}
	
}
