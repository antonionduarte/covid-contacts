package groups;

public class GroupClass implements Group {
	
	/* Variables */
	private String name, description;
	
	/**
	 * Constructor.
	 * @param name        Groups' name.
	 * @param description Groups' description.
	 */
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
}
