package exceptions;

public class GroupHasNoPostsException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Grupo nao tem mensagens.";
	
	/* Constructor */
	public GroupHasNoPostsException() {
		super(MSG);
	}
	
}
