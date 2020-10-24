package users;

import comparators.UserComparator;
import dataStructures.*;
import exceptions.*;
import groups.Group;
import posts.Post;

public class UserClass implements User {
	
	/* Constants */
	private static final int MAX_GROUPS = 10;

	/* Variables */
	private String login, username, location, profession;
	private int age;
	private List<Group> groups;
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
		groups = new ArrayList<>(10);
		contacts = new OrderedDoublyLinkedList<>(new UserComparator());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserClass userClass = (UserClass) o;
		return getLogin().equals(userClass.getLogin());
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
	public boolean groupListFull() {
		return groups.size() == MAX_GROUPS;
	}
	
	@Override
	public Iterator<User> newContactsIterator() throws NoContactsException {
		if (contacts.isEmpty()) {
			throw new NoContactsException();
		}
		return contacts.iterator();
	}
	
	@Override
	public void addContact(User contact) throws ContactAlreadyExistsException {
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
		if (groups.find(group) != -1) {
			throw new UserAlreadyInGroupException();
		}
		groups.addLast(group);
	}
	
	@Override
	public void removeGroup(Group group) throws UserNotInGroupException {
		if (!groups.remove(group)) {
			throw new UserNotInGroupException();
		}
	}

	@Override
	public void receivePost(Post post) {
		posts.addLast(post);
	}

	@Override
	public void insertPost(Post post) {
		Iterator<User> userIterator = (TwoWayIterator<User>) contacts.iterator();
		Iterator<Group> groupIterator = (TwoWayIterator<Group>) groups.iterator();

		while (userIterator.hasNext()) {
			userIterator.next().receivePost(post);
		}

		while (groupIterator.hasNext()) {
			groupIterator.next().insertPost(post);
		}
	}

	@Override
	public Iterator<Post> postsIterator() {
		return posts.iterator();
	}

	@Override
	public Iterator<Post> newContactPostsIterator(User other) throws ContactDoesNotExistException {
		Iterator<User> userIterator = contacts.iterator(); 

		while (userIterator.hasNext()) {
			User contact = userIterator.next();
			if (contact.equals(other)) {
				return contact.postsIterator();
			}
		}

		throw new ContactDoesNotExistException();
	}
	
}
