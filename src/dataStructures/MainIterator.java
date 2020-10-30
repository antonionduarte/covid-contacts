package dataStructures;

import exceptions.NoSuchElementException;

public class MainIterator<T, E> implements Iterator<T> {

	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	private Iterator<E> iterator;

	/* Constructor */
	public MainIterator(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T next() throws NoSuchElementException {
		return (T) iterator.next();
	}

	@Override
	public void rewind() {
		iterator.rewind();
	}

}
