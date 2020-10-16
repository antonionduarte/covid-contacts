package exceptions;

public class SameUserLoginException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Contacto nao pode ser removido.";
	
	/* Constructor */
	public SameUserLoginException() {
		super(DEFAULT_MSG);
	}
	
}
