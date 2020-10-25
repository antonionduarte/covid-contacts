package exceptions;

public class ContactAlreadyExistsException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Existencia do contacto referido.";
	
	/* Constructor */
	public ContactAlreadyExistsException() {
		super(MSG);
	}

}
