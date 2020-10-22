package covidContacts;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserDoesNotExistException;
import groups.Group;
import posts.Post;
import users.User;
import users.UserClass;


public class CovidContactsClass implements CovidContacts {
	
	/* Variables */
	private OrderedList<User> users;
	private List<Group> groups;
	
	/* Constructor */
	public CovidContactsClass() {
		users = new OrderedArrayList<>(new UserComparator()); // descriptive comment of why we chose to use an Ordered Array List
		groups = new DoublyLinkedList<>(); // descriptive comment of why we chose to use a Doubly Linked List
	}
	
	@Override
	public void registerUser(String login, String username, int age, String location, String profession) throws UserAlreadyExistsException {
		User newUser = new UserClass(login, username, age, location, profession);
		if (users.find(newUser) != -1) {
			throw new UserAlreadyExistsException();
		}
		users.insert(newUser);
	}
	
	@Override
	public User getUser(String login) throws UserDoesNotExistException {
		int index = users.find(new UserClass(login, null, 0, null, null));
		
		if (index == -1) {
			throw new UserDoesNotExistException();
		}

		return users.get(index);
	}
	
	@Override
	public void addContact(String login1, String login2) throws UserDoesNotExistException, ContactAlreadyExistsException {
		int index1 = users.find(new UserClass(login1, null, 0, null, null)),
				index2 = users.find(new UserClass(login2, null, 0, null, null));

		if (index1 == -1 || index2 == -1) {
			throw new UserDoesNotExistException();
		}
		
		users.get(index1).addContact(users.get(index2));
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
	
	@Override
	public void insertGroupParticipant(String login, String groupName) {
	
	}
	
	@Override
	public void removeGroupParticipant(String login, String groupName) {
	
	}
	
	@Override
	public Iterator<User> newGroupParticipantsIterator(String groupName) {
		return null;
	}
	
	@Override
	public void insertPost(String login, String title, String text, String url) {
	
	}
	
	@Override
	public Iterator<Post> newUserContactPostsIterator(String login1, String login2) {
		return null;
	}
	
	@Override
	public Iterator<Post> newGroupPostsIterator(String groupName, String login) {
		return null;
	}
	
}
