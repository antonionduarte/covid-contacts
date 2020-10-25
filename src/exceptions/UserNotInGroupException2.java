package exceptions;

public class UserNotInGroupException2 extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Inexistencia do participante referido.";
	
	/* Constructor */
	public UserNotInGroupException2() {
		super(MSG);
	}
	
}
