package dataStructures;

import covidContacts.exceptions.NoElementException;

import java.io.Serializable;

/**
 * @param <E> Generic Element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Queue (FIFO) interface.
 */

public interface Queue<E> extends Serializable {
	
	/**
	 * @return True if the queue contains no elements.
	 */
	boolean isEmpty();
	
	/**
	 * Returns the number of elements in the queue.
	 * @return number of elements in the queue
	 */
	int size();
	
	/**
	 * Inserts the specified element at the rear of the queue.
	 * @param element Element to be added to the end of the queue.
	 */
	void enqueue(E element);
	
	/**
	 * Removes and returns the element at the front of the queue.
	 * @return Element removed from the end of the queue.
	 */
	E dequeue() throws NoElementException;
	
}                                                                       
