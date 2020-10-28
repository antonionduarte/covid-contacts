package dataStructures;

import exceptions.NoSuchElementException;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * @param <E> Generic Element.
 * Iterator for an array list.
 */

public class ArrayListIterator<E> implements Iterator<E> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	E[] array;
	int numElements, nextElement;
	
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