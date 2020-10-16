package exceptions;

public class EmptyStackException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	public EmptyStackException(String s) {
		super(s);
	}
}
