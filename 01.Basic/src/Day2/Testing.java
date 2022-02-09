package Day2;

public class Testing {

	static String name;
	int price;
	
	void display() {
		int barCode = 1001;
		name = "Juice";
		price = 1500;
		System.out.println("Code: " + barCode);
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testing t1 = new Testing();
		t1.display();
	}

}
