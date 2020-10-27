package comparators;

import groups.Group;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Compares two groups based on the lexicographic order of their name.
 */

public class GroupComparator implements Comparator<Group> {
	
	@Override
	public int compare(Group group1, Group group2) {
		return group1.getName().compareTo(group2.getName());
	}
}
