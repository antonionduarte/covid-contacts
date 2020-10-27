package exceptions;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class FullStackException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	public FullStackException(String s) {
		super(s);
	}
}
