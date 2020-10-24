package groups;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.UserNotInGroupException;
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
		participants = new OrderedDoublyLinkedList<>(new UserComparator());
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
		participants.insert(user);
	}
	
	@Override
	public boolean hasParticipant(User user) {
		return participants.find(user) != -1;
	}
	
	@Override
	public void removeParticipant(User user) throws UserNotInGroupException {
		if (participants.find(user) == -1) {
			throw new UserNotInGroupException();
		}
		participants.remove(user);
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
