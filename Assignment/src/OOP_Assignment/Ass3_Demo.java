package OOP_Assignment;


public class Ass3_Demo {


	public static void main(String[] args) {
		Ass3_Rectangle rectangle = new Ass3_Rectangle(134, 300, "Pink");
		double area = rectangle.Area();
		rectangle.displayArea(area);
		System.out.println(rectangle.getColor());

	}

}
