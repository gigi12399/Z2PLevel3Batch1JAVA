package OOP_Assignment;

public class Ass4_PolymorphismTest {

	public static void main(String[] args) {
		Ass4_Shape[] shape = new Ass4_Shape[2];
		
		shape[0] = new Ass4_Cube();
		shape[1] = new Ass4_Circle();
		
		System.out.println("Area of Cube: " + shape[0].Area(33));
		System.out.println("Area of Circle: " + shape[1].Area(4));
		
		System.out.println("Volume of Cube: " + shape[0].Volume(50));
		System.out.println("Volume of Circle: " + shape[1].Volume(3));

	}

}
