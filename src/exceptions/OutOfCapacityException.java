package exceptions;

public class OutOfCapacityException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Full data structure.";
	
	public OutOfCapacityException() {
		super(DEFAULT_MSG);
	}
}
