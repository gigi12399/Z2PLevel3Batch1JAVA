package Day7;

class InvalidAgeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidAgeException() {
		
	}
	public InvalidAgeException(String msg) {
		super (msg);
	}

}

public class UserDefinedExceptionDemo{
	static void checkAge(int age) throws InvalidAgeException {
		if(age < 18)
			throw new InvalidAgeException("Age is not valid to smoke");
		else
			System.out.println("You can smoke");
	}
	public static void main(String[] args) {
		try {
			checkAge(10);
		} catch (InvalidAgeException e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}
}
