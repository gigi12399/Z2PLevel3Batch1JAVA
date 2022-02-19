package Day7;

public class Throwing_Exception_2 {
	
	static void checkMark(int mark) throws ArithmeticException {
		if(mark < 0 || mark > 100) {
			ArithmeticException ex = new ArithmeticException("Invalid mark!");
			
			throw ex;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			checkMark(-1);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
