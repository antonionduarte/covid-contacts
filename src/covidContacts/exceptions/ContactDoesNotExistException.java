package covidContacts.exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class ContactDoesNotExistException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Inexistencia do contacto referido.";
	
	/* Constructor */
	public ContactDoesNotExistException() {
		super(MSG);
	}
	
}
