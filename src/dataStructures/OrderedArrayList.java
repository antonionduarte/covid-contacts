package dataStructures;

import comparator.Comparator;
import exceptions.InvalidPositionException;
import exceptions.NoElementException;

public class OrderedArrayList<E> implements OrderedList<E> {

	/* Constants */
	private static final int DEFAULT_SIZE = 10, GROWTH_FACTOR = 2;

	/* Variables */
	private E[] array;
	private int numElements;
	private Comparator<E> comparator;

	@SuppressWarnings("unchecked")
	public OrderedArrayList(Comparator<E> comparator) {
		array = (E[]) new Object[DEFAULT_SIZE];
		numElements = 0;
		this.comparator = comparator;
	}

	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}

	@Override
	public int size() {
		return numElements;
	}

	@Override
	public E getFirst() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return array[0];
	}

	@Override
	public E getLast() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return array[numElements - 1];
	}

	@Override
	public int find(E element) {
		int start = 0;
		int end = numElements - 1;

		while (start <= end) {
			int position = start + ((end - start) / 2);
			int result = comparator.compare(array[position], element);

			if (result > 0) {
				end = position - 1;
			}
			else if (result < 0) {
				start = position + 1;
			}
			else {
				return position;
			}
		}
		return -1;
	}

	@Override
	public E get(int position) throws InvalidPositionException {
		if (position >= numElements || position < 0) {
			throw new InvalidPositionException();
		}
		return array[position];
	}


	@Override
	public void insert(E element) {
		boolean found = false;
		
		if (isEmpty()) {
			insert(0, element);
			found = true; 
		}
		
		int start = 0;
		int end = numElements - 1;

		if (start == end) {
			insert(numElements, element);	
			found = true;
		}

		while (!found) {
			int position = start + ((end - start) / 2);
			int result = comparator.compare(array[position], element);
			int result2 = comparator.compare(array[position + 1], element);

			if (result < 0 && result2 > 0) {
				found = true;
				insert(position + 1, element);
			}
			else if (result > 0) {
				end = position - 1;
			}
			else {
				start = position + 1;
			}
		}
	}

	/**
	 * Inserts an element into the specified position.
	 * @param position Position to inser the element on.
	 */
	private void insert(int position, E element) {
		if (position == array.length) {
			resize();
		}
		
		for (int i = numElements - 1; i >= position; i--) {
			array[i + 1] = array[i];
		}

		array[position] = element;
		numElements++;
	}

	/**
	 * Resizes the array by a specified growth factor
	 */
	@SuppressWarnings("unchecked")
	private void resize() {
		E[] tempArray = (E[]) new Object[array.length * GROWTH_FACTOR];
		for (int i = 0; i < numElements; i++) {
			tempArray[i] = array[i];
		}
		array = tempArray;
	}

}
