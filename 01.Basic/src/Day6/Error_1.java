package Day6;

public class Error_1 {
	static void display(int num) {
		System.out.println("Number is " + num);
		display(num);
	}
	public static void main(String[] args) {
		display(100);
	}
}
