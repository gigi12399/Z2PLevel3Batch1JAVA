package Day9.pkg2;
import Day9.pkg1.A;

public class D {
	void test() {
		A obj = new A();
		//obj.number = 20; // different pkg
		// obj.price
	}
}

class F extends A{
	void test() {
		A obj = new A();
		// obj.number = 20;
		//obj.price = 100;
		F obj1 = new F();
		obj1.price = 100;
	}
}
