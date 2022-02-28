package Day11.di;

public class Demo {
	public static void main(String[] args) {
		Circle circle = new Circle();
		Controller control = new Controller(circle);
		control.display(100);
		
		control = new Controller(new Square());
		control.display(100);
	}
}
