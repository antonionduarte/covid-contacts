package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class ContactHasNoPostsException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Contacto nao tem mensagens.";
	
	/* Constructor */
	public ContactHasNoPostsException() {
		super(MSG);
	}
	
}
