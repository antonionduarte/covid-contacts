package covidContacts.exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class UserAlreadyInGroupException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Existencia de aderencia referida.";
	
	/* Constructor */
	public UserAlreadyInGroupException() {
		super(MSG);
	}
	
}
