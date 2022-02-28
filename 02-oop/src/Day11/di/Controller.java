package Day11.di;

public class Controller {
	private Area area;
	
	public Controller(Area area) {
		this.area = area;
	}
	void display(int input) {
		System.out.println(area.callArea(input));
	}
}
