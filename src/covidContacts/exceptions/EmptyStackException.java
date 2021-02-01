package covidContacts.exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class EmptyStackException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	public EmptyStackException(String s) {
		super(s);
	}
}
