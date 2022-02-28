package Day11.di;

public class Circle implements Area {

	@Override
	public int callArea(int n) {
		// TODO Auto-generated method stub
		return (int)(3.14 * n * n);
	}

}
