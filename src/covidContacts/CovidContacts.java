package covidContacts;

import dataStructures.Iterator;
import exceptions.*;
import groups.Group;
import posts.Post;
import users.User;

public interface CovidContacts {
	
	/**
	 * Register a new user into the contacts manager.
	 * @param login The users' login.
	 * @param username The users' name.
	 * @param age The users' age.
	 * @param location The users' location.
	 * @param profession The users' profession.
	 */
	void registerUser(String login, String username, int age, String location, String profession) throws UserAlreadyExistsException;
	
	/**
	 * @param login Users' login.
	 * @return Specified user.
	 */
	User getUser(String login) throws UserDoesNotExistException;
	
	/**
	 * Creates a new 2-way contact between 2 users.
	 * @param login1 First users' login.
	 * @param login2 Second users' login.
	 */
	void addContact(String login1, String login2) throws ContactAlreadyExistsException;
	
	/**
	 * Removes the 2-way contact between 2 users.
	 * @param login1 First users' login.
	 * @param login2 Second users' login.
	 */
	void removeContact(String login1, String login2) throws SameUserLoginException;
	
	/**
	 * @param login The specified users' login.
	 * @return Iterator of the specified users' contacts.
	 */
	Iterator<User> newUserContactsIterator(String login);
	
	/**
	 * Inserts a new group into the system.
	 * @param name The groups' name.
	 * @param description The groups' description.
	 */
	void insertGroup(String name, String description) throws GroupAlreadyExistsException;
	
	/**
	 * Removes the specified group.
	 * @param name The groups' name.
	 */
	void removeGroup(String name);
	
	/**
	 * @param name The specified groups' name.
	 * @return Group with the specified name.
	 */
	Group getGroup(String name) throws GroupDoesNotExistException;
	
	/**
	 * Inserts a user into a group.
	 * @param login The users' login.
	 * @param groupName The groups' name.
	 */
	void insertGroupParticipant(String login, String groupName);
	
	/**
	 * Removes a user from a group.
	 * @param login The users' login.
	 * @param groupName The groups' name.
	 */
	void removeGroupParticipant(String login, String groupName);
	
	/**
	 * @param groupName The specified groups' name.
	 * @return New group participants iterator.
	 */
	Iterator<User> newGroupParticipantsIterator(String groupName);
	
	/**
	 * Inserts a new post from a specified user.
	 * @param login Users' login.
	 * @param title Posts' title.
	 * @param text Posts' message.
	 * @param url Posts' URL.
	 */
	void insertPost(String login, String title, String text, String url);
	
	/**
	 * @param login1 Specified user.
	 * @param login2 Specified users' contact.
	 * @return New user contact posts iterator.
	 */
	Iterator<Post> newUserContactPostsIterator(String login1, String login2);
	
	/**
	 * @param groupName Groups' name.
	 * @param login Users' login.
	 * @return New group posts iterator.
	 */
	Iterator<Post> newGroupPostsIterator(String groupName, String login);
}
