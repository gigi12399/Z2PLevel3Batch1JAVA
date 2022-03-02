package OOP_Assignment;

public class Ass3_Rectangle extends Ass3_Shape {
	private int length;
	private int width;
	@Override
	public double Area() {
		return length * width;
	}
	public Ass3_Rectangle(int length, int weigth, String color) {
		super();
		setColor(color);
		this.length = length;
		this.width = weigth;
	}
	public void displayArea(double area) {
		System.out.println("Area of the rectangle: " + area);
	}
	
}
