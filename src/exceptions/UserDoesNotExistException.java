package exceptions;

public class UserDoesNotExistException extends RuntimeException {
	
	/* Constants */
	private static final String MSG = "Inexistencia do utilizador referido.";
	
	/* Constructor */
	public UserDoesNotExistException() {
		super(MSG);
	}
	
}
