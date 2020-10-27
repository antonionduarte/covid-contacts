package groups;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.*;
import posts.Post;
import users.User;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Contains all the information regarding a groups, which is a collection of users that contain their posts.
 */

public class GroupClass implements Group {
	
	/* Variables */
	private String name, description;
	private OrderedList<User> participants;
	private List<Post> posts;
	
	/**
	 * Constructor.
	 * @param name Groups' name.
	 * @param description Groups' description.
	 */
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
		participants = new OrderedDoublyLinkedList<>(new UserComparator());
		posts = new DoublyLinkedList<>();
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		return name.equals(((GroupClass) other).getName());
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
	public void insertParticipant(User user) throws UserAlreadyInGroupException {
		if (participants.find(user) != -1) {
			throw new UserAlreadyInGroupException();
		}
		participants.insert(user);
	}
	
	@Override
	public void insertPost(Post post) {
		posts.addLast(post);
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
	public void clearParticipants() {
		Iterator<User> participantsIterator = participants.iterator();
		
		while (participantsIterator.hasNext()) {
			participantsIterator.next().removeGroup(this);
		}
	}
	
	@Override
	public Iterator<User> newParticipantsIterator() throws NoParticipantsException {
		if (participants.isEmpty()) {
			throw new NoParticipantsException();
		}
		return participants.iterator();
	}
	
	@Override
	public TwoWayIterator<Post> newPostsIterator(User user) throws UserNotInGroupException, GroupDoesNotExistException {
		if (participants.find(user) == -1) {
			throw new UserNotInGroupException2();
		}
		if (posts.isEmpty()) {
			throw new GroupHasNoPostsException();
		}
		return (TwoWayIterator<Post>) posts.iterator();
	}
	
}
