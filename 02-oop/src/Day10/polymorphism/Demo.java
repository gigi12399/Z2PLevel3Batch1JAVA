package Day10.polymorphism;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Developer developer;
		
		developer = new FrontEndDeveloper();
		developer.work();
		
		developer = new BackendDeveloper();
		developer.work();
	}

}
