package users;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.ContactAlreadyExistsException;
import exceptions.ContactDoesNotExistException;
import exceptions.UserAlreadyInGroupException;
import exceptions.UserNotInGroupException;
import groups.Group;
import posts.Post;

public class UserClass implements User {

	/* Constants */
	private static final int MAX_GROUPS = 10;

	/* Variables */
	private String login, username, location, profession;
	private int age, numGroups;
	private List<Group> joinedGroups;
	private List<Post> posts;
	private OrderedList<User> contacts;

	/**
	 * Constructor.
	 * 
	 * @param login Users' login.
	 * @param username Users' username.
	 * @param age Users' age.
	 * @param location Users' location.
	 * @param profession Users' profession.
	 */
	public UserClass(String login, String username, int age, String location, String profession) {
		this.login = login;
		this.username = username;
		this.age = age;
		this.location = location;
		this.profession = profession;
		posts = new DoublyLinkedList<>();
		joinedGroups = new DoublyLinkedList<>();
		contacts = new OrderedDoublyLinkedList<>(new UserComparator());
		numGroups = 0;
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public String getProfession() {
		return profession;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public int getNumGroups() {
		return numGroups;
	}
	
	@Override
	public Iterator<User> newContactsIterator() {
		return contacts.iterator();
	}

	@Override
	public void insertPost(Post post) {
	
	}
	
	@Override
	public int addGroup(Group group) {
		return 0;
	}
	
	@Override
	public void addContact(User contact) {
		if (contacts.find(contact) != -1) {
			throw new ContactAlreadyExistsException();
		}

		contacts.insert(contact);
	}

	@Override
	public void removeContact(User contact) throws ContactDoesNotExistException {
		if (!contacts.remove(contact)) {
			throw new ContactDoesNotExistException();
		}
	}
	
	@Override
	public void addGroup(Group group) throws UserAlreadyInGroupException {
		if (joinedGroups.find(group) > -1) {
			throw new UserAlreadyInGroupException();
		}

		joinedGroups.addLast(group);
	}
	
	@Override
	public void removeGroup(Group group) throws UserNotInGroupException {
		if (!joinedGroups.remove(group)) {
			throw new UserNotInGroupException();
		}
	}


	// TODO: Might have to think about this
	@Override
	public void insertPost(Post post) {
		posts.addLast(post);
	}

	@Override
	public Iterator<Post> newContactPostsIterator(User other) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
