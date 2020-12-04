package dataStructures;

import covidContacts.exceptions.NoSuchElementException;

/**
 * @param <E> Generic Element.
 * Two Way Iterator interface that extends the normal Iterator with backwards iteration capabilities.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public interface TwoWayIterator<E> extends Iterator<E> {
	
	/**
	 * @return True if a previous element to iterate exists.
	 */
	boolean hasPrevious();
	
	/**
	 * @return Previous element to be iterated.
	 */
	E previous() throws NoSuchElementException;
	
	/**
	 * Restarts the iteration in the reverse direction. After fullForward, if the iteration is not empty, previous will
	 * return the last element in the iteration.
	 */
	void fullForward();
	
}
