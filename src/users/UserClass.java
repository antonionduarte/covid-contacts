package users;

import dataStructures.*;
import exceptions.*;
import groups.Group;
import posts.Post;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * User implementation, handles the users' information and conexions.
 */

public class UserClass implements User, Comparable<User> {
	
	/* Constants */
	private static final int MAX_GROUPS = 10;
	
	/* Variables */
	private final String login, username, location, profession;
	private final int age;
	private final List<Post> posts;
	private final List<Group> groups;
	private final Dictionary<String, User> contacts;
	
	/**
	 * Constructor.
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
		/*
		 * We chose a Doubly Linked List since an indefinite amount of sent/received posts are stored by their order
		 * of insertion and are only really used for listing purposes (we could have used a Singly Linked List and just
		 * added each element in the beginning to have a LIFO order, but a Doubly Linked List is more versatile in case
		 * we want to also be able to list posts in a FIFO order).
		 */
		posts = new DoublyLinkedList<>();
		/*
		 * Since groups have a pre-defined hard limit, having an ArrayList is the best option, since adding
		 * posts is less frequent leaving and entering new groups.
		 * We know that it would have been a more simple implementation if we simply used an Array, but since we
		 * already had the ArrayList implemented we decided to use it for the groups.
		 *
		 */
		groups = new ArrayList<>(10);
		/*
		 * As for the users' contacts, an AVL Tree is the perfect balance (no pun intended), since the contacts need to
		 * be ordered lexicographically for listing purposes [O(log2(n))]. They also have to be searched, inserted,
		 * removed [all with O(log2(n)) time complexity] and iterated through to send messages quite often [O(log2(n))].
		 */
		contacts = new AVLTree<>();
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserClass userClass = (UserClass) o;
		return getLogin().equals(userClass.getLogin());
	}
	
	@Override
	public int compareTo(User o) {
		return this.getLogin().compareTo(o.getLogin());
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
		return new EntryValueIterator<>(contacts.iterator());
	}
	
	@Override
	public void addContact(User contact) throws ContactAlreadyExistsException {
		if (contacts.find(contact.getLogin()) != null) {
			throw new ContactAlreadyExistsException();
		}
		contacts.insert(contact.getLogin(), contact);
	}
	
	@Override
	public void removeContact(User contact) throws ContactDoesNotExistException {
		if (contacts.remove(contact.getLogin()) == null) {
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
		if (groups.remove(group) == null) {
			throw new UserNotInGroupException();
		}
	}
	
	@Override
	public void receivePost(Post post) {
		posts.addLast(post);
	}
	
	@Override
	public void insertPost(Post post) {
		posts.addLast(post);
		
		Iterator<User> userIterator = new EntryValueIterator<>(contacts.iterator());
		Iterator<Group> groupIterator = groups.iterator();
		
		while (userIterator.hasNext()) {
			userIterator.next().receivePost(post);
		}
		
		while (groupIterator.hasNext()) {
			groupIterator.next().insertPost(post);
		}
	}
	
	@Override
	public TwoWayIterator<Post> newPostsIterator(User other) throws ContactDoesNotExistException, ContactHasNoPostsException {
		if (!login.equals(other.getLogin()) && contacts.find(other.getLogin()) == null) {
			throw new ContactDoesNotExistException();
		}
		if (posts.isEmpty()) {
			throw new ContactHasNoPostsException();
		}
		return (TwoWayIterator<Post>) posts.iterator();
	}
	
}
