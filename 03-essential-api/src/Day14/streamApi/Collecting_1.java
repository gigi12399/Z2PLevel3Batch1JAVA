package Day14.streamApi;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Collecting_1 {
	public static void main(String[] args) {
		Student[] students = {
				new Student(10, "Cherry", "Yangon"),
				new Student(2, "Cherry" , "Mandalay"),
				new Student(5, "Khaing", "Monywa"),
				new Student(1, "Htet", "Mandalay"),
				new Student(11, "Htet Yandana", "Yangon")
		};
		
		Set<String> hashSet = Arrays.stream(students)
									.map(Student::getName)
									.collect(Collectors.toSet());
		
		System.out.println("hashSet: " + hashSet);
		
		TreeSet<String> treeSet = Arrays.stream(students)
										.map(Student::getName)
										.collect(Collectors.toCollection(TreeSet::new));
		
		System.out.println("TreeSet: " + treeSet);
		
		Map<Integer, String> hashMap = Arrays.stream(students)
											.collect(Collectors.toMap(Student::getRno, Student::getName));
		
		System.out.println("MapSet: " + hashMap);
		
		Map<Integer, Student> hashMap2 = Arrays.stream(students)
												.filter(s -> !s.getCity().equals("Yangon"))
												.collect(Collectors.toMap(s-> s.getRno(), s-> s));
		System.out.println("MapSet 2: " + hashMap2);
	}
}


class Student{
	private int rno;
	private String name;
	private String city;
	public Student(int rno, String name, String city) {
		super();
		this.rno = rno;
		this.name = name;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", city=" + city + "]";
	}
	
	
	
}