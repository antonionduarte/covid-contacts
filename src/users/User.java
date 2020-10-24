package users;

import dataStructures.Iterator;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import groups.Group;
import posts.Post;

public interface User extends UserGetters {
	
	/**
	 * Adds a new contact.
	 * @param contact New contact.
	 */
	void addContact(User contact) throws ContactAlreadyExistsException;
	
	/**
	 * Removes an existing contact.
	 * @param contact Contact to remove.
	 */
	void removeContact(User contact) throws ContactDoesNotExistException;
	
	/**
	 * @param contact Contact to check for.
	 * @return Return true if the specified contact exists, false if otherwise.
	 */
	boolean hasContact(User contact);
	
	/**
	 * Inserts a new post
	 * @param post Post to insert.
	 */
	void insertPost(Post post);
	
	/**
	 * Adds a new group to the user.
	 * @param group Group to add.
	 * @return
	 */
	int addGroup(Group group);
}
