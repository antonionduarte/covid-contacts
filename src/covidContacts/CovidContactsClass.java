package covidContacts;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserDoesNotExistException;
import groups.Group;
import users.User;
import users.UserClass;


public class CovidContactsClass implements CovidContacts {
	
	/* Variables */
	private List<User> users;
	private List<Group> groups;
	
	/* Constructor */
	public CovidContactsClass() {
		users = new DoublyLinkedList<>();
		groups = new DoublyLinkedList<>();
	}
	
	@Override
	public void registerUser(String login, String username, int age, String location, String profession) throws UserAlreadyExistsException {
		if (!users) {
			throw new UserAlreadyExistsException();
		}
		users.addLast(new UserClass(login, username, age, location, profession));
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
	
	@Override
	public Iterator<User> newUserContactsIterator(String login) {
		return null;
	}
	
	@Override
	public void insertGroup(String name, String description) {
	
	}
	
	@Override
	public void removeGroup(String name) {
	
	}
	
	@Override
	public Group getGroup(String name) {
		return null;
	}
	
}
