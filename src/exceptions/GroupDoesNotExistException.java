package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class GroupDoesNotExistException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Inexistencia do grupo referido.";
	
	/* Constructor */
	public GroupDoesNotExistException() {
		super(DEFAULT_MSG);
	}
	
}
