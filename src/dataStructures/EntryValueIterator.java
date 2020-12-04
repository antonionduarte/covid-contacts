package dataStructures;

import exceptions.NoSuchElementException;

/**
 * Generic iterator that iterates using an Entry iterator, and returns the value
 * instead of the entry.
 * @param <K> Generic element.
 * @param <V> Generic element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class EntryValueIterator<K, V> implements Iterator<V> {

	/* Constants */
	private static final long serialVersionUID = 1L;

	/* Variables */
	Iterator<Entry<K, V>> iterator;

	/**
	 * Constructor.
	 * @param iterator The Iterator that returns an Entry.
	 */
	public EntryValueIterator(Iterator<Entry<K, V>> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public V next() throws NoSuchElementException {
		if (!iterator.hasNext()) {
			throw new NoSuchElementException();
		}

		return iterator.next().getValue();
	}

	@Override
	public void rewind() {
		iterator.rewind();
	}
	
}
