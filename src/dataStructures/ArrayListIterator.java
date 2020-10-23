package dataStructures;

import exceptions.NoSuchElementException;

public class ArrayListIterator<E> implements Iterator<E> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	E[] array;
	int nextElement;
	
	public ArrayListIterator(E[] array) {
		this.array = array;
		rewind();
	}
	
	@Override
	public boolean hasNext() {
		return nextElement < array.length;
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