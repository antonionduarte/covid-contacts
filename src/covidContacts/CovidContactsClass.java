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
		/*
		 * We chose an Ordered Array List since finding/checking if a user exists and accessing the user is
		 * a much more common occurrence than adding or removing a user from the system or resizing the array
		 * in the case it's full (even when adding or removing a user, its existence has to be checked first),
		 * thus, by keeping the array ordered after every insertion, we can take advantage of the binary search
		 * and binary insertion we implemented, which have O(log2(n)) time complexity.
		 */
		users = new OrderedArrayList<>(new UserComparator());
		/*
		 * We chose a Doubly Linked List because there are far less groups than users in the system and
		 * it will only be used to add and remove groups, since other operations like adding a post
		 * will be done via the users (which have much smaller collections of groups).
		 */
		groups = new DoublyLinkedList<>();
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
	public void addContact(String login1, String login2) throws ContactAlreadyExistsException {
		User user1 = getUser(login1);
		
		if (login1.equals(login2)) {
			throw new ContactAlreadyExistsException();
		}
		
		User user2 = getUser(login2);
		user1.addContact(user2);
		user2.addContact(user1);
	}
	
	@Override
	public void removeContact(String login1, String login2) throws SameUserLoginException {
		User user1 = getUser(login1);
		
		if (login1.equals(login2)) {
			throw new SameUserLoginException();
		}
		
		User user2 = getUser(login2);
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
	public Group getGroup(String name) throws GroupDoesNotExistException {
		Iterator<Group> iterator = groups.iterator();
		
		while (iterator.hasNext()) {
			Group group = iterator.next();
			if (group.getName().equals(name)) {
				return group;
			}
		}
		throw new GroupDoesNotExistException();
	}
	
	@Override
	public void removeGroup(String name) throws GroupDoesNotExistException {
		if (!groups.remove(new GroupClass(name, null))) {
			throw new GroupDoesNotExistException();
		}
	}
	
	@Override
	public void insertGroupParticipant(String login, String groupName) {
		User user = getUser(login);
		Group group = getGroup(groupName);
		
		if (!user.groupListFull()) {
			group.insertParticipant(user);
			user.addGroup(group);
		}
	}
	
	@Override
	public void removeGroupParticipant(String login, String groupName) {
		User user = getUser(login);
		Group group = getGroup(groupName);
		
		group.removeParticipant(user);
		user.removeGroup(group);
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
	public TwoWayIterator<Post> newUserContactPostsIterator(String login1, String login2) {
		return getUser(login1).newPostsIterator(getUser(login2));
	}
	
	@Override
	public TwoWayIterator<Post> newGroupPostsIterator(String groupName, String login) {
		return getGroup(groupName).newPostsIterator(getUser(login));
	}
	
}
