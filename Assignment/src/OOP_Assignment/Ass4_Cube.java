package OOP_Assignment;

public class Ass4_Cube implements Ass4_Shape {
	
	@Override
	public double Area(int x) {
		return 6*x*x;
	}

	@Override
	public double Volume(int x) {
		return x*x*x;
	}

}
