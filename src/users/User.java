package users;

import dataStructures.Iterator;

public interface User {
	
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
	 * Adds a new contact.
	 * @param contact New contact.
	 */
	void addContact(User contact);
	
	/**
	 * Removes an existing contact.
	 * @param contact Contact to remove.
	 */
	void removeContact(User contact);
	
	/**
	 * @return Contacts iterator.
	 */
	Iterator<User> listContacts();
	
}
