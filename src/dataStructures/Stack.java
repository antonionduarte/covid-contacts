package dataStructures;

import covidContacts.exceptions.FullStackException;

import java.util.EmptyStackException;

/**
 * @param <E> Generic Element.
 * Stack (LIFO) interface.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public interface Stack<E> {
	
	/**
	 * @return True if the stack contains no elements.
	 */
	boolean isEmpty();
	
	/**
	 * @return Number of elements in the stack.
	 */
	int size();
	
	/**
	 * @return Element on top of the stack.
	 */
	E top() throws EmptyStackException;
	
	/**
	 * Inserts the specified element onto the top of the stack.
	 * @param element Element to be inserted on top of the stack.
	 */
	void push(E element) throws FullStackException;
	
	/**
	 * Removes and returns the element at the top of the stack.
	 * @return Element removed from top of stack.
	 */
	E pop() throws EmptyStackException;
	
}
