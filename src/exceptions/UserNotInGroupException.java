package exceptions;

public class UserNotInGroupException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Inexistencia de aderencia referida.";
	
	/* Constructor */
	public UserNotInGroupException() {
		super(MSG);
	}
	
}
