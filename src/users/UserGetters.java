package users;

import dataStructures.Iterator;

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
	 * @return Contacts iterator.
	 */
	Iterator<User> listContacts();
	
}
