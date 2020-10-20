package comparators;

import users.User;

public class UserComparator implements Comparator<User> {
	
	@Override
	public int compare(User user1, User user2) {
		return user1.getLogin().compareTo(user2.getLogin());
	}
	
}
