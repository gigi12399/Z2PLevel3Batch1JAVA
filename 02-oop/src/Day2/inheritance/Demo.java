package Day2.inheritance;

public class Demo {
	public static void main(String[] args) {
		Student obj = new Student(1, "Jeon", "098765433");
		obj.display();
		System.out.println("Rno - " + obj.getRno());
	}
}
