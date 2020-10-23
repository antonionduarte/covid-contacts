package groups;

import dataStructures.*;

public class GroupClass implements Group {
	
	/* Variables */
	private String name, description;
	private List participants;
	
	/**
	 * Constructor.
	 * @param name Groups' name.
	 * @param description Groups' description.
	 */
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
		participants = new ArrayList<>();
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
