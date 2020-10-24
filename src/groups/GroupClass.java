package groups;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.GroupDoesNotExistException;
import exceptions.GroupHasNoPostsException;
import exceptions.NoParticipantsException;
import exceptions.UserNotInGroupException;
import posts.Post;
import users.User;

import java.util.Objects;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GroupClass that = (GroupClass) o;
		return getName().equals(that.getName());
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
	public Iterator<User> newParticipantsIterator() throws NoParticipantsException {
		if (participants.isEmpty()) {
			throw new NoParticipantsException();
		}
		return participants.iterator();
	}
	
	@Override
	public Iterator<Post> newGroupPostsIterator(User user) throws GroupDoesNotExistException {
		if (posts.isEmpty()) {
			throw new GroupHasNoPostsException();
		}
		return posts.iterator();
	}
	
}
