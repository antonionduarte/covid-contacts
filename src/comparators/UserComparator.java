package comparators;

import users.User;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Compares two users based on the lexicographic order of their login.
 */

public class UserComparator implements Comparator<User> {
	
	@Override
	public int compare(User user1, User user2) {
		return user1.getLogin().compareTo(user2.getLogin());
	}
	
}
