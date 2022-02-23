package Day2;

public class AccessModifier {

}

class A{
	private int a;
	void test() {
		// private int b;
		a = 100;
	}
}

class B{
	void test() {
		A obj = new A();
		//obj.a = 1;
	}
}
