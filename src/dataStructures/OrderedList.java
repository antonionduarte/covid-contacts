package dataStructures;

public interface OrderedList<E> extends List<E> {
	
	/**
	 * Inserts an element in a sorted manner, depending
	 * on the Comparator provided in the constructor.
	 * @param element Element to be inserted in the list.
	 */
	void insert(E element);
	
}
