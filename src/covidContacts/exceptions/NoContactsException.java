package covidContacts.exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class NoContactsException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Inexistencia de contactos.";
	
	/* Constructor */
	public NoContactsException() {
		super(DEFAULT_MSG);
	}
	
}
