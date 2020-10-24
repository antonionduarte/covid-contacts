package covidContacts;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.*;
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
		return getUser(login).newContactsIterator();
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
		if (!groups.remove(new GroupClass(name, null))) {
			throw new GroupDoesNotExistException();
		}
	}
	
	@Override
	public Group getGroup(String name) throws GroupDoesNotExistException {
		int index = groups.find(new GroupClass(name, null));
		if (index == -1) {
			throw new GroupDoesNotExistException();
		}
		
		return groups.get(index);
	}
	
	@Override
	public void insertGroupParticipant(String login, String groupName) {
		User user = getUser(login);
		Group group = getGroup(groupName);
		
		if (user.getNumGroups() < 10) {
			group.insertParticipant(user);
			user.addGroup(group);
		}
	}
	
	@Override
	public void removeGroupParticipant(String login, String groupName) {
		User user = getUser(login);
		getGroup(groupName).removeParticipant(user);
	}
	
	
	@Override
	public Iterator<User> newGroupParticipantsIterator(String groupName) {
		return getGroup(groupName).newParticipantsIterator();
	}
	
	@Override
	public void insertPost(String login, String title, String text, String url) {
		User user = getUser(login);
		user.insertPost(new PostClass(user, title, text, url));
	}
	
	@Override
	public Iterator<Post> newUserContactPostsIterator(String login1, String login2) {
		return getUser(login1).newContactPostsIterator(getUser(login2));
	}
	
	@Override
	public Iterator<Post> newGroupPostsIterator(String groupName, String login) {
		return getGroup(groupName).newGroupPostsIterator(getUser(login));
	}
	
}
