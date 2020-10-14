package covidContactsManager;

import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserDoesNotExistException;
import users.User;

public class CovidContactsManagerClass implements CovidContactsManager {

  @Override
  public void registerUser(String login, String username, int age, String location, String profession)
      throws UserAlreadyExistsException {
    // TODO Auto-generated method stub

  }

  @Override
  public User getUser(String login) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addContact(String login1, String login2) throws UserDoesNotExistException, ContactAlreadyExistsException {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeContact(String login1, String login2)
      throws UserDoesNotExistException, ContactDoesNotExistException {
    // TODO Auto-generated method stub

  }
}
