package Day2;

public class Testing_4 {
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 200;
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		
		System.out.println(num1 + " == " + num2 + " is " + (num1 == num2));
		
		System.out.println((80 % 5 == 0 ) && (80 % 4 == 0));
		
		String result = (14 % 2 == 1 ? "Odd" : "Even");
		System.out.println(result);
		
		num1 += 400;
		System.out.println("num1 = " + num1);
		
		Testing_5.static_method();
		Testing_5 obj = new Testing_5();
		obj.instance_method();
	}
}
