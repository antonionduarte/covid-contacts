package groups;

import dataStructures.*;
import posts.Post;
import users.User;

public class GroupClass implements Group {
	
	/* Variables */
	private String name, description;
	private OrderedList<User> participants;
	
	/**
	 * Constructor.
	 * @param name Groups' name.
	 * @param description Groups' description.
	 */
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
		participants = new DoublyLinkedList<>();
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void insertParticipant(User user) {
	
	}
	
	@Override
	public boolean hasParticipant(User user) {
		return false;
	}
	
	@Override
	public void removeParticipant(User user) {
	
	}
	
	@Override
	public Iterator<User> newParticipantsIterator() {
		return null;
	}
	
	@Override
	public Iterator<Post> newGroupPostsIterator(User user) {
		return null;
	}
	
}
