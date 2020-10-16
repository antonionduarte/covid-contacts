package users;

public interface User extends UserGetters {
	
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

}
