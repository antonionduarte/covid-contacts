package exceptions;

public class NoParticipantsException extends RuntimeException {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Inexistencia de participantes.";
	
	/* Constructor */
	public NoParticipantsException() {
		super(MSG);
	}
	
}
