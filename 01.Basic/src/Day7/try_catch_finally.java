package Day7;

public class try_catch_finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String name = null;
			System.out.println("Length: " + name.length());
		} catch(Exception e){
			System.err.println("It does not allocate!");
		} finally {
			// TODO: handle finally clause
			System.out.println("Finally block");
		}
		System.out.println("Final Statement!");
		
	}

}
