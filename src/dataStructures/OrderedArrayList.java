package dataStructures;

import comparators.Comparator;
import exceptions.InvalidPositionException;
import exceptions.NoElementException;

public class OrderedArrayList<E> extends ArrayList<E> implements OrderedList<E> {
	
	/* Constants */
	private static final int DEFAULT_SIZE = 10, GROWTH_FACTOR = 2;
	
	/* Variables */
	private E[] array;
	private int numElements;
	private Comparator<E> comparator;
	
	/**
	 * Constructor.
	 * @param comparator Comparator used to order the elements.
	 */
	@SuppressWarnings("unchecked")
	public OrderedArrayList(Comparator<E> comparator) {
		array = (E[]) new Object[DEFAULT_SIZE];
		numElements = 0;
		this.comparator = comparator;
	}
	
	@Override
	public int find(E element) {
		int low = 0, high = numElements - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2, result = comparator.compare(array[mid], element);
			
			if (result > 0) {
				high = mid - 1;
			}
			else if (result < 0) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}
	
	@Override
	public void insert(E element) {
		int low = 0, high = numElements - 1;
		boolean found = false;
		
		if (isEmpty() || low == high) {
			insert(numElements, element);
			found = true;
		}
		
		while (!found) {
			int mid = (low + high) / 2, result = comparator.compare(array[mid], element);
			
			if (result < 0 && comparator.compare(array[mid + 1], element) > 0) {
				insert(mid + 1, element);
				found = true;
			}
			else if (result > 0) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
	}
	
	/**
	 * Inserts an element into the specified position.
	 * @param index Position to inser the element on.
	 */
	private void insert(int index, E element) {
		if (index == array.length) {
			resize();
		}
		
		for (int i = numElements - 1; i >= index; i--) {
			array[i + 1] = array[i];
		}
		
		array[index] = element;
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
