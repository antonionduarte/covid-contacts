package comparators;

import groups.Group;

public class GroupComparator implements Comparator<Group> {
	
	@Override
	public int compare(Group group1, Group group2) {
		return group1.getName().compareTo(group2.getName());
	}
}
