package covidContacts;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.GroupAlreadyExistsException;
import exceptions.GroupDoesNotExistException;
import exceptions.UserAlreadyExistsException;
import exceptions.UserDoesNotExistException;
import exceptions.UserNotInGroupException;
import groups.Group;
import groups.GroupClass;
import posts.Post;
import posts.PostClass;
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

		User user1 = users.get(index1);
		User user2 = users.get(index2);

		user1.addContact(user2);
		user2.addContact(user1);
	}
	
	@Override
	public void removeContact(String login1, String login2)
			throws UserDoesNotExistException, ContactDoesNotExistException {
		
		int index1 = users.find(new UserClass(login1, null, 0, null, null)),
				index2 = users.find(new UserClass(login2, null, 0, null, null));

		if (index1 == -1 || index2 == -1) {
			throw new UserDoesNotExistException();
		}
		
		User user1 = users.get(index1);
		User user2 = users.get(index2);
				
		if (!user1.hasContact(user2)) {
			throw new ContactDoesNotExistException();
		}

		user1.removeContact(user2);
		user2.removeContact(user1);
	}
	
	@Override
	public Iterator<User> newUserContactsIterator(String login) {
		return null;
	}
	
	@Override
	public void insertGroup(String name, String description) throws GroupAlreadyExistsException {
		Group newGroup = new GroupClass(name, description);
		if (groups.find(newGroup) != -1) {
			throw new UserAlreadyExistsException();
		}
		groups.addLast(newGroup);
	}
	
	@Override
	public void removeGroup(String name) throws GroupDoesNotExistException {
		if (groups.isEmpty()) {
			throw new GroupDoesNotExistException();
		}

		Iterator<Group> iterator = (TwoWayIterator<Group>) groups.iterator();
		boolean found = false;

		while (iterator.hasNext() && !found) {
			Group toRemove = iterator.next();
			if (toRemove.getName().equals(name)) {
				found = true;
				groups.remove(toRemove);
			}
		}

		if (found == false) {
			throw new GroupDoesNotExistException();
		}
	}
	
	@Override
	public Group getGroup(String name) throws GroupDoesNotExistException {
		if (groups.isEmpty()) {
			throw new GroupDoesNotExistException();
		}

		Iterator<Group> iterator = (TwoWayIterator<Group>) groups.iterator();

		while (iterator.hasNext()) {
			Group toReturn = iterator.next();
			if (toReturn.getName().equals(name)) {
				return toReturn;
			}
		}

		throw new GroupDoesNotExistException();
	}
	
	@Override
	public void insertGroupParticipant(String login, String groupName) {
		User user = getUser(login);
		Group group = getGroup(groupName);

		group.insertParticipant(user);
	}
	
	@Override
	public void removeGroupParticipant(String login, String groupName) {
		User user = getUser(login);
		Group group = getGroup(groupName);

		if (!group.hasParticipant(user)) {
			throw new UserNotInGroupException();
		}

		group.removeParticipant(user);
	}
			
	
	@Override
	public Iterator<User> newGroupParticipantsIterator(String groupName) {
		return null;
	}
	
	@Override
	public void insertPost(String login, String title, String text, String url) {
		User user = getUser(login);
		Post newPost = new PostClass(user, title, text, url);

		

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
