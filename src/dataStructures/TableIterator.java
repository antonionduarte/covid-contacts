package dataStructures;

import exceptions.NoSuchElementException;

public class TableIterator<K, V> implements Iterator<Entry<K,V>> {

	/* Constants */
	private static final long serialVersionUID = 1L;

	/* Variables */
	private Dictionary<K, V>[] table;
	private Iterator<Entry<K, V>> currentColision;
	private int tableCounter, counter, size, firstCorrect;

	/**
	 * Constructor.
	 * I am doing the iteration to find the first available ColisionList
	 * in the constructor, so that I can store the first position
	 * where we have a colision list. That will allow me to do the 
	 * rewind() method without reiterating to find the first
	 * correct position.
	 * @param table Table that we will iterate the elements of.
	 */
	public TableIterator(Dictionary<K, V>[] table, int size) {
		this.table = table;
		this.size = size;
		counter = 0;

		for (int i = 0; (i <= table.length) && table[i].isEmpty(); i++) {
			tableCounter++;
		}

		firstCorrect = tableCounter;
		currentColision = table[tableCounter].iterator();
	}

	/* Methods */

	@Override
	public boolean hasNext() {
		return counter < size;
	}

	@Override
	public Entry<K, V> next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		if (!currentColision.hasNext()) {
			tableCounter++;
			
			for (int i = tableCounter; (i < (table.length - 1)) && table[i].isEmpty(); i++) {
				tableCounter++;
			}

			currentColision = table[tableCounter].iterator();
			counter++;
			return currentColision.next();
		} else {
			counter++;
			return currentColision.next();
		}
	}

	@Override
	public void rewind() {
		tableCounter = firstCorrect;
		counter = 0;
	}

}
