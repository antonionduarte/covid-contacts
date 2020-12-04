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
	private final Dictionary<String, Group> groups;
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
		/**
		 * We chose a Doubly Linked List since an indefinite amount of sent/received posts are stored by their order
		 * of insertion and is only really used for listing purposes (we could have used a Singly Linked List and just
		 * added each element in the beginning to have a LIFO order, but a Doubly Linked List is more versatile in case
		 * we want to also be able to list posts in a FIFO order).
		 */
		posts = new DoublyLinkedList<>();
		/**
		 * // TODO: I'm not going to be making this comment just yet because i'm not 100% settled on the HashTable.
		 * 
		 * Since groups have a pre-defined hard limit, having an Ordered Array List is the best option in terms of
		 * searching time complexity [O(log2(n))]. The only downside is inserting or removing a group, since it has
		 * to shift the whole list, but considering the max number of groups a user can have is generally quite small,
		 * this aspect will have a minimal performance downside.
		 *
		 * TODO: Remake the comment and make groups comparable.
		 */
		groups = new ChainedHashTable<>();
		/**
		 * TODO: Revê por favor Virgínia 👉👈
		 * 
		 * As for the users' contacts, an AVL Tre is the best option, since the contacts need to be ordered
		 * according to the lexicographic order of their login, and need to be individually accessed and removed.
		 * The main purpose of the contact list is to send posts to all the users' contacts and list them,
		 * which means they just have to be iterated through, which has a complexity of O(n) using the AVLTree.
		 * As for insertions or removals, using an AVLTree has a complexity of O(log(n)).
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
		if (groups.find(group.getName()) != null) {
			throw new UserAlreadyInGroupException();
		}
		groups.insert(group.getName(), group);
	}
	
	@Override
	public void removeGroup(Group group) throws UserNotInGroupException {
		if (groups.remove(group.getName()) == null) {
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
		Iterator<Group> groupIterator = new EntryValueIterator<>(groups.iterator());
		
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
