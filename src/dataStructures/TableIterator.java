package dataStructures;

import exceptions.NoSuchElementException;

public class TableIterator<K, V> implements Iterator<Entry<K,V>> {

	/* Constants */
	private static final long serialVersionUID = 1L;

	/* Variables */
	private Dictionary<K, V>[] table;
	private Iterator<Entry<K, V>> currentCollision;
	private int currentIndex, numElementsIterated, numElements;

	/**
	 * Constructor.
	 * I am doing the iteration to find the first available CollisionList
	 * in the constructor, so that I can store the first position
	 * where we have a collision list. That will allow me to do the
	 * rewind() method without reiterating to find the first
	 * correct position.
	 * @param table Table that we will iterate the elements of.
	 */
	public TableIterator(Dictionary<K, V>[] table, int numElements, int maxSize) {
		this.table = table;
		this.numElements = numElements;
		rewind();
	}

	/* Methods */

	@Override
	public boolean hasNext() {
		return numElementsIterated < numElements;
	}

	@Override
	public Entry<K, V> next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		while (!currentCollision.hasNext()) {
			currentCollision = table[++currentIndex].iterator();
		}
		
		numElementsIterated++;
		return currentCollision.next();
	}

	@Override
	public void rewind() {
		currentIndex = 0;
		numElementsIterated = 0;
		currentCollision = table[currentIndex].iterator();
	}

}
