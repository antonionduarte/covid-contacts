package covidContacts;

import dataStructures.Iterator;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserDoesNotExistException;
import groups.Group;
import users.User;

public interface CovidContacts {
	
	/**
	 * Register a new user into the contacts manager.
	 * @param login      The users' login.
	 * @param username   The users' name.
	 * @param age        The users' age.
	 * @param location   The users' location.
	 * @param profession The users' profession.
	 */
	void registerUser(String login, String username, int age, String location, String profession) throws UserAlreadyExistsException;
	
	/**
	 * @param login Users' login.
	 * @return Specified user.
	 */
	User getUser(String login);
	
	/**
	 * Creates a new 2-way contact between 2 users.
	 * @param login1 First users' login.
	 * @param login2 Second users' login.
	 */
	void addContact(String login1, String login2) throws UserDoesNotExistException, ContactAlreadyExistsException;
	
	/**
	 * Removes the 2-way contact between 2 users.
	 * @param login1 First users' login.
	 * @param login2 Second users' login.
	 */
	void removeContact(String login1, String login2) throws UserDoesNotExistException, ContactDoesNotExistException;
	
	/**
	 * @param login The specified users' login.
	 * @return Iterator of the specified users' contacts.
	 */
	Iterator<User> listContacts(String login) throws UserDoesNotExistException;
	
	/**
	 * Inserts a new group into the system.
	 * @param name        The groups' name.
	 * @param description The groups' description.
	 */
	void insertGroup(String name, String description);
	
	/**
	 * Removes the specified group.
	 * @param name
	 */
	void removeGroup(String name);
	
	/**
	 * @param name The specified groups' name.
	 * @return Group with the specified name.
	 */
	Group getGroup(String name);
	
}
