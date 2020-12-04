package dataStructures;

import covidContacts.exceptions.NoSuchElementException;

/**
 * @param <E> Generic Element.
 * Iterator for an array list.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class ArrayListIterator<E> implements Iterator<E> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	private final E[] array;
	private final int numElements;
	private int nextElement;
	
	/**
	 * Constructor.
	 * @param array Array of elements to iterate.
	 * @param numElements Number of elements.
	 */
	public ArrayListIterator(E[] array, int numElements) {
		this.array = array;
		this.numElements = numElements;
		rewind();
	}
	
	@Override
	public boolean hasNext() {
		return nextElement < numElements;
	}
	
	@Override
	public E next() throws NoSuchElementException {
		return array[nextElement++];
	}
	
	@Override
	public void rewind() {
		nextElement = 0;
	}
	
}