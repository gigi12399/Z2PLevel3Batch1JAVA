package Collection_Assignment_2;

public class Student implements Comparable<Student> {
	private int rno;
	private String name;
	private int age;
	public Student(int rno, String name, int age) {
		super();
		this.rno = rno;
		this.name = name;
		this.age = age;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Student p) {
		return name.compareTo(p.name);
	}
	
	
}
