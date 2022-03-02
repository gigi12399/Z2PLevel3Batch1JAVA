package OOP_Assignment;

public class Ass4_Circle implements Ass4_Shape {
	float PI = 3.142f;

	@Override
	public double Area(int r) {
		return PI * r * r;
	}

	@Override
	public double Volume(int r) {
		return 0;
	}

}
