package covidContacts.exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class UserDoesNotExistException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Inexistencia do utilizador referido.";
	
	/* Constructor */
	public UserDoesNotExistException() {
		super(MSG);
	}
	
}
