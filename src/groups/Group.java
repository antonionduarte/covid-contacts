package groups;

import dataStructures.Iterator;
import dataStructures.TwoWayIterator;
import covidContacts.exceptions.NoParticipantsException;
import covidContacts.exceptions.UserAlreadyInGroupException;
import covidContacts.exceptions.UserNotInGroupException;
import posts.Post;
import users.User;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Contains all the information regarding a groups, which is a collection of users and their posts.
 */

public interface Group extends GroupGetters {
	
	/**
	 * Inserts a new user into the group.
	 * @param user User to insert.
	 */
	void insertParticipant(User user) throws UserAlreadyInGroupException;
	
	/**
	 * Inserts a new post intro the group.
	 * @param post New post.
	 */
	void insertPost(Post post);
	
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
	 * Clears all connections between the group and the participants.
	 */
	void clearParticipants();
	
	/**
	 * @return New participants iterator.
	 */
	Iterator<User> newParticipantsIterator() throws NoParticipantsException;
	
	/**
	 * @param user User to check if he is a participant.
	 * @return New group posts iterator.
	 */
	TwoWayIterator<Post> newPostsIterator(User user);
	
}
