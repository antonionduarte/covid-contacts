package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class NoElementException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Empty data structure.";
	
	/* Constructor */
	public NoElementException() {
		super(DEFAULT_MSG);
	}
	
	/**
	 * Constructor.
	 * @param msg Message to show in the exception.
	 */
	public NoElementException(String msg) {
		super(msg);
	}
}
