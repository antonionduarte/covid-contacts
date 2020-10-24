package users;

import dataStructures.Iterator;
import dataStructures.TwoWayIterator;
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
   * @return Amount of groups that the user has joined.
   */
  int getNumGroups();
	
	/**
	 * @return New contacts iterator.
	 */
	Iterator<User> newContactsIterator();
	
	/**
	 * @param other User to list received posts from.
	 * @return New contact posts iterator.
	 */
	Iterator<Post> newContactPostsIterator(User other);
	
	/**
	 * @return Number of groups the user is a part of.
	 */
	int getNumGroups();
}
