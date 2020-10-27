package users;

import dataStructures.Iterator;
import dataStructures.TwoWayIterator;
import exceptions.NoContactsException;
import posts.Post;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 *
 * User interface that has the getters.
 */

public interface UserGetters {
	
	/**
	 * @return Users' login.
	 */
	String getLogin();
	
	/**
	 * @return Users' username.
	 */
	String getUsername();
	
	/**
	 * @return Users' location.
	 */
	String getLocation();
	
	/**
	 * @return Users' profession.
	 */
	String getProfession();
	
	/**
	 * @return Users' age.
	 */
	int getAge();
	
	/**
	 * @return True if the users' group list is full.
	 */
	boolean groupListFull();
	
	/**
	 * @return New contacts iterator.
	 */
	Iterator<User> newContactsIterator() throws NoContactsException;
	
	/**
	 * @param other User to check if he's a contact.
	 * @return New contact posts iterator.
	 */
	TwoWayIterator<Post> newPostsIterator(User other);
	
}
