package dataStructures;

import exceptions.NoSuchElementException;

/**
 * Generic iterator that casts an iterators' elements into another type.
 * @param <E> Generic element.
 * @param <T> Generic element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class MainIterator<E, T> implements Iterator<T> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	private final Iterator<E> iterator;
	
	/**
	 * Constructor.
	 * @param iterator Iterator to be cast during iteration.
	 */
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
