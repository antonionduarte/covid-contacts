package exceptions;

public class ContactDoesNotExistException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Inexistencia do contacto referido.";
	
	/* Constructor */
	public ContactDoesNotExistException() {
		super(MSG);
	}
	
}
