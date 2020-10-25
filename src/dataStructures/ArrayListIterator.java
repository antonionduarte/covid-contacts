package dataStructures;

import exceptions.NoSuchElementException;

public class ArrayListIterator<E> implements Iterator<E> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	E[] array;
	int numElements, nextElement;
	
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