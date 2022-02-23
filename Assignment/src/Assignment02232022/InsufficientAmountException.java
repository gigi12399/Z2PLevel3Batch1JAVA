package Assignment02232022;

public class InsufficientAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsufficientAmountException(String msg) {
		super(msg);
	}
}
