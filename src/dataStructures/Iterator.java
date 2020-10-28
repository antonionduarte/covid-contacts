package dataStructures;

import exceptions.NoSuchElementException;

import java.io.Serializable;

/**
 * @param <E> Generic Element.
 * Iterator interface.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public interface Iterator<E> extends Serializable {
	
	/**
	 * @return True if there is another element to iterate through.
	 */
	boolean hasNext();
	
	/**
	 * @return The next element in the iteration.
	 */
	E next() throws NoSuchElementException;
	
	/**
	 * Restarts the iteration.
	 */
	void rewind();
	
}
