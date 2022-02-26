package Day10.inheritance;

public class Demo {
	public static void main(String[] args) {
		Person person = new Person("James");
		person.showInfo();
		
		Teacher teacher = new Teacher("Aung Aung", "Instructor");
		teacher.showInfo();
		
		Person p1 = new Teacher("Naung Naung", "Tutor");
		p1.showInfo();
		// p1.display();
	}
}
