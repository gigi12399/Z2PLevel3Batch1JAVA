package class_object_assignment;

public class InsufficientAmountException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsufficientAmountException(String msg) {
		super(msg);
	}
}
