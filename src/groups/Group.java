package groups;

import dataStructures.Iterator;
import exceptions.UserNotInGroupException;
import posts.Post;
import users.User;

public interface Group {
	
	/**
	 * @return The groups' name.
	 */
	String getName();
	
	/**
	 * @return The groups' description.
	 */
	String getDescription();
	
	/**
	 * Inserts a new user into the group.
	 * @param user User to insert.
	 */
	void insertParticipant(User user);
	
	/**
	 * @param user User to check if he is a participant.
	 * @return True if the user is a participant in the group.
	 */
	boolean hasParticipant(User user);
	
	/**
	 * Removes a user from the group.
	 * @param user User to remove.
	 */
	void removeParticipant(User user) throws UserNotInGroupException;
	
	/**
	 * @return New participants iterator.
	 */
	Iterator<User> newParticipantsIterator();
	
	/**
	 * @param user User to check if he is a participant.
	 * @return New group posts iterator.
	 */
	Iterator<Post> newGroupPostsIterator(User user);
	
}
