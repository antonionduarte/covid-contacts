package dataStructures;

import exceptions.NoSuchElementException;

public class TableIterator<K, V> implements Iterator<Entry<K, V>> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	private final Dictionary<K, V>[] table;
	private final int numElements;
	private Iterator<Entry<K, V>> currentCollision;
	private int currentIndex, numElementsIterated, firstIndex;
	
	/**
	 * Constructor.
	 * @param table Table that we will iterate the elements of.
	 */
	public TableIterator(Dictionary<K, V>[] table, int numElements) {
		this.table = table;
		this.numElements = numElements;
		firstIndex = 0;
		
		if (numElements > 0) {
			while (table[firstIndex].isEmpty()) {
				firstIndex++;
			}
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

		if (!currentCollision.hasNext()) {
			while (table[++currentIndex].isEmpty());
			currentCollision = table[currentIndex].iterator();
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
