package exceptions;

public class GroupAlreadyExistsException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_MSG = "Grupo ja existente.";
	
	/* Constructor */
	public GroupAlreadyExistsException() {
		super(DEFAULT_MSG);
	}
	
}
