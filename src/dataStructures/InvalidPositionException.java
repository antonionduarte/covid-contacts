package dataStructures;

public class InvalidPositionException extends RuntimeException {
	
	/* Constants */
	static final long serialVersionUID = 0L;
	private static final String DEFAULT_MSG = "Invalid position.";
	
	/* Constructor */
	public InvalidPositionException() {
		super(DEFAULT_MSG);
	}
	
	/**
	 * Constructor.
	 * @param msg Message to show in the exception.
	 */
	public InvalidPositionException(String msg) {
		super(msg);
	}
	
}

