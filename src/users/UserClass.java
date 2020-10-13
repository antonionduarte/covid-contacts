package users;

import groups.Group;

public class UserClass implements User {
	
	/* Constants */
	private static final int MAX_GROUPS = 10;
	
	/* Variables */
	private String login, username, location, profession;
	private int age, numJoinedGroups;
	private Group[] joinedGroups;
	
	public UserClass(String login, String username, String location, String profession, int age) {
		this.login = login;
		this.username = username;
		this.location = location;
		this.profession = profession;
		this.age = age;
		joinedGroups = new Group[MAX_GROUPS];
		numJoinedGroups = 0;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public int getAge() {
		return age;
	}
	
}
