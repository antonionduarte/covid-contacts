package enums;

public enum Command {
	
	/* Commands */
	IU("inserts a new user."),
	DU("lists a specified users' information."),
	IC("inserts a new contact between 2 users."),
	RC("removes the contact between 2 users."),
	LC("lists a users' contacts."),
	IG("inserts a new group into the system."),
	DG("lists a specified groups' information."),
	RG("removes a specified group."),
	IP("inserts a new user into a specified group."),
	RP("removes a specified participant from a group."),
	LP("lists a groups' participants."),
	IM("inserts a users' new message."),
	LMC("lists the messages from a specified users' contact."),
	LMG("lists a specified groups' messages."),
	FIM("exits the program."),
	UNKNOWN("unknown command.");
	
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
