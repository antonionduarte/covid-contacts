package covidContacts.exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class NoSuchElementException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "No such element.";
	
	/* Constructor */
	public NoSuchElementException() {
		super(DEFAULT_MSG);
	}
	
	/**
	 * Constructor.
	 * @param msg Message to show in the exception.
	 */
	public NoSuchElementException(String msg) {
		super(msg);
	}
	
}
