package dataStructures;

import exceptions.NoSuchElementException;

public class TableIterator<K, V> implements Iterator<Entry<K, V>> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	private final Dictionary<K, V>[] table;
	private Iterator<Entry<K, V>> currentCollision;
	private int currentIndex;
	private int numElementsIterated;
	private final int numElements;
	private int firstIndex;
	
	/**
	 * Constructor.
	 * I am doing the iteration to find the first available CollisionList
	 * in the constructor, so that I can store the first position
	 * where we have a collision list. That will allow me to do the
	 * rewind() method without reiterating to find the first
	 * correct position.
	 * @param table Table that we will iterate the elements of.
	 */
	public TableIterator(Dictionary<K, V>[] table, int numElements) {
		this.table = table;
		this.numElements = numElements;
		firstIndex = 0;
		
		while (!table[firstIndex++].iterator().hasNext()) {
			currentCollision = table[++currentIndex].iterator();
		}
		
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
		currentIndex = firstIndex;
		numElementsIterated = 0;
		currentCollision = table[firstIndex].iterator();
	}
	
}
