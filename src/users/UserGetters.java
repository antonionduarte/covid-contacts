package users;

import dataStructures.Iterator;
import exceptions.NoContactsException;
import posts.Post;

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
	 * @return New posts iterator.
	 */
	Iterator<Post> postsIterator();
	
	/**
	 * @param other User to list received posts from.
	 * @return New contact posts iterator.
	 */
	Iterator<Post> newContactPostsIterator(User other);
	
}
