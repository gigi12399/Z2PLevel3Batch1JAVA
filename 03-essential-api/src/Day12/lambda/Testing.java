package Day12.lambda;

public class Testing {
	public static void main(String[] args) {
		// MyClass obj = new MyClass();
		// obj.display("Aung Aung");
//		MyInterface1 obj = new MyInterface1() {
//			
//			@Override
//			public void display(String input) {
//				System.out.println(input);
//				
//			}
//		};
//		obj.display("Aung Aung");
		
		MyInterface1 obj = (str) -> System.out.println(str);
		obj.display("Aung Aung");
		
		MyInterface3 obj2 = (email,password) -> {
			if(email.equals("jk@gmail.com") && password.equals("123"))
				return true;
			else
				return false;
		};
		System.out.println(obj2.checkLogin("admin@gmail.com","123") ? "Login Success" : "Invalid Login");
		System.out.println(obj2.checkLogin("jk@gmail.com", "123") ? "Login Success" : "Invalid Login");
		
		MyInterface2 sum = (n1,n2) -> n1 + n2;
		MyInterface2 sub = (n1,n2) -> n1 - n2;
		MyInterface2 mul = (n1,n2) -> n1 * n2;
		
		System.out.println(sum.operate(100, 300));
		System.out.println(sub.operate(20, 5));
		System.out.println(mul.operate(2, 5));
		
	}
}

//class MyClass implements MyInterface1{
//
//	@Override
//	public void display(String input) {
//		System.out.println(input);
//		
//	}
//	
//}