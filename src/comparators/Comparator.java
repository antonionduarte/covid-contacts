package comparators;

public interface Comparator<E> {
 
	/**
	 * Compares two elements of a generic type.
	 * @param element1 First element.
	 * @param element2 Second element.
	 * @return -1 in case element1 < element2
	 * 0 in case element1 == element2
	 * 1 in case element1 > element2
	 */
	int compare(E element1, E element2);
	
}
