package Day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name: ");
		String name = reader.readLine();
		System.out.println("Enter salary: ");
		double salary = Double.parseDouble(reader.readLine()); // String -> double
		System.out.println("Enter age: ");
		int age = Integer.parseInt(reader.readLine()); // String -> integer
		
		reader.close(); // Close The Stream
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		System.out.println("Age: " + age);
	}

}
