package covidContactsManager;

import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserDoesNotExistException;
import users.User;

public interface CovidContactsManager {
	

  /**
   * Register a new user into the contacts manager.
   * @param login The users' login.
   * @param username The users' name.
   * @param age The users' age.
   * @param location The users' location.
   * @param profession The users' profession.
   * @throws UserAlreadyExistsException
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
   * @throws UserDoesNotExistException
   * @throws ContactAlreadyExistsException
   */
  void addContact(String login1, String login2) throws UserDoesNotExistException, ContactAlreadyExistsException;

  /**
   * Removes the 2-way contact between 2 users.
   * @param login1 First users' login.
   * @param login2 Second users' login.
   * @throws UserDoesNotExistException
   * @throws ContactDoesNotExistException
   */
  void removeContact(String login1, String login2) throws UserDoesNotExistException, ContactDoesNotExistException;
}
