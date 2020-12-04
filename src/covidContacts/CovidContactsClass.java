package covidContacts;

import dataStructures.*;
import covidContacts.exceptions.*;
import groups.Group;
import groups.GroupClass;
import groups.GroupGetters;
import posts.Post;
import posts.PostClass;
import users.User;
import users.UserClass;
import users.UserGetters;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Manages all the operations between users, their contacts and their groups.
 */

public class CovidContactsClass implements CovidContacts {
	
	/* Variables */
	private final Dictionary<String, User> users;
	private final Dictionary<String, Group> groups;
	
	/* Constructor */
	public CovidContactsClass() {
		/*
		 * We chose Chained Hash Tables since finding/checking if a user/group exists and accessing them
		 * is a very common occurrence. Searching, insertion and removal operations all have O(1+lambda) time complexity.
		 */
		users = new ChainedHashTable<>();
		groups = new ChainedHashTable<>();
	}
	
	@Override
	public void registerUser(String login, String username, int age, String location, String profession) throws UserAlreadyExistsException {
		User newUser = new UserClass(login, username, age, location, profession);
		
		if (users.find(login) != null) {
			throw new UserAlreadyExistsException();
		}
		users.insert(login, newUser);
	}
	
	@Override
	public UserGetters getUserGetters(String login) {
		return getUser(login);
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
	public Iterator<UserGetters> newUserContactsIterator(String login) {
		Iterator<User> userIterator = getUser(login).newContactsIterator();
		return new MainIterator<User, UserGetters>(userIterator);
	}
	
	@Override
	public void insertGroup(String name, String description) throws GroupAlreadyExistsException {
		Group newGroup = new GroupClass(name, description);
		if (groups.find(name) != null) {
			throw new GroupAlreadyExistsException();
		}
		groups.insert(name, newGroup);
	}
	
	public GroupGetters getGroupGetters(String name) {
		return getGroup(name);
	}
	
	@Override
	public void removeGroup(String name) throws GroupDoesNotExistException {
		Group group = groups.remove(name);
		
		if (group == null) {
			throw new GroupDoesNotExistException();
		}
		group.clearParticipants();
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
	public Iterator<UserGetters> newGroupParticipantsIterator(String groupName) {
		Iterator<User> userIterator = getGroup(groupName).newParticipantsIterator();
		return new MainIterator<User, UserGetters>(userIterator);
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
	
	/* Private Methods */
	
	/**
	 * @param login Login of the desired user.
	 * @return User with the specified login.
	 */
	private User getUser(String login) throws UserDoesNotExistException {
		User user = users.find(login);
		
		if (user == null) {
			throw new UserDoesNotExistException();
		}
		return user;
	}
	
	/**
	 * @param name The specified groups' name.
	 * @return Group with the specified name.
	 */
	private Group getGroup(String name) throws GroupDoesNotExistException {
		Group group = groups.find(name);
		
		if (group == null) {
			throw new GroupDoesNotExistException();
		}
		
		return group;
	}
	
}
