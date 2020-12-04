package covidContacts.exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class GroupAlreadyExistsException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Grupo ja existente.";
	
	/* Constructor */
	public GroupAlreadyExistsException() {
		super(DEFAULT_MSG);
	}
	
}
