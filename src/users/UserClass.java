package users;

import dataStructures.Iterator;
import groups.Group;

public class UserClass implements User {
	
	/* Constants */
	private static final int MAX_GROUPS = 10;
	
	/* Variables */
	private String login, username, location, profession;
	private int age, numJoinedGroups;
	private Group[] joinedGroups;
	private User[] contacts;
	
	public UserClass(String login, String username, String location, String profession, int age) {
		this.login = login;
		this.username = username;
		this.location = location;
		this.profession = profession;
		this.age = age;
		joinedGroups = new Group[MAX_GROUPS];
		numJoinedGroups = 0;
		contacts = new User[]
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
	public void addContact(User contact) {
		//TODO insert sort by name or something.
	}
	
	@Override
	public void removeContact(User contact) {
		//TODO
	}
	
	@Override
	public Iterator<User> listContacts() {
		return //TODO
	}
	
}
