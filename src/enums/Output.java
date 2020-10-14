package enums;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * All outputs and formatting.
 */

public enum Output {
	
	/* Outputs */
	USER_REGISTERED("Registo de utilizador executado."),
  CONTACT_MADE("Registo de contacto executado."),
  CONTACT_REMOVED("Remocao de contacto executada."),
	EXIT("Obrigado. Ate a proxima.");
	
	/* Variables */
	private final String message;
	
	/**
	 * Constructor.
	 * @param message The outputs' message.
	 */
	Output(String message) {
		this.message = message;
	}
	
	/**
	 * @return The output message.
	 */
	public String getMessage() {
		return message;
	}
	
}
