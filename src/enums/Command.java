package enums;

public enum Command {
	
	/* Commands */
	UNKNOWN("unknown command."),
	EXIT("exits the program.");
	
	/* Variables */
	private final String description;
	
	/**
	 * Constructor.
	 * @param description The commands' description.
	 */
	Command(String description) {
		this.description = description;
	}
	
	/**
	 * @return The commands' description.
	 */
	public String getDescription() {
		return description;
	}
	
}
