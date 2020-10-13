package dataStructures;

import exceptions.NoSuchElementException;

import java.io.Serializable;

/**
 * Iterator Abstract Data Type
 * Includes description of general methods for one way iterator.
 * @param <E> Generic Element
 * @author AED  Team
 * @version 1.0
 */
public interface Iterator<E> extends Serializable {
	
	/**
	 * @return True if there is another element to iterate through.
	 */
	boolean hasNext();
	
	/**
	 * @return The next element in the iteration.
	 * @throws NoSuchElementException if it's called without verifying the pre-condition.
	 */
	E next() throws NoSuchElementException;
	
	/**
	 * Restarts the iteration.
	 */
	void rewind();
	
}
