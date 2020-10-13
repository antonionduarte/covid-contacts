package exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	
	/* Constants */
	private static final String MSG = "Utilizador ja existente.";
	
	/* Constructor */
	public UserAlreadyExistsException() {
		super(MSG);
	}
	
}
