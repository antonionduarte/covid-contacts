package covidContactsManager;

import users.User;

public interface CovidContactsManager {
	
	/**
	 *
	 * @param login
	 * @param username
	 * @param age
	 * @param location
	 * @param profession
	 */
	void registerUser(String login, String username, int age, String location, String profession);
	
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
	void addContact(String login1, String login2);
}
