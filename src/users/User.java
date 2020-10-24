package users;

import posts.*;
import groups.*;
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
	 * Adds a new group to the Users' group list.
	 * @param group The group to add.
	 */
	void addGroup(Group group);

	/**
	 * Adds a new post to the Users' post list.
	 * @param post The post to add.
	 */
	void insertPost(Post post);

	/**
	 * Removes a group from the Users' group list.
	 * @param group The group to remove.
	 */
	void removeGroup(Group group);

}
