package Day11.interface_test;

public interface Myinterface {
	void method1();
	default void method2() {
		System.out.println("This is default method");
	}
	
	static void method3() {
		System.out.println("This is static method");
	}
}

class Myclass implements Myinterface{

	@Override
	public void method1() {
		System.out.println("This is abstract method");
		
	}

	@Override
	public void method2() {
		
	}
	
	
	
}
