package dataStructures;

import comparators.Comparator;
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
	public E get(int position) throws InvalidPositionException {
		if (position >= numElements || position < 0) {
			throw new InvalidPositionException();
		}
		return array[position];
	}
	
	
	@Override
	public void insert(E element) {
		int low = 0, high = numElements - 1;
		
		if (isEmpty()) {
			insert(0, element);
		}
		
		while (low < high) {
			int mid = (low + high) / 2, result = comparator.compare(array[mid], element);
			
			if (result > 0) {
				high = mid - 1;
			}
			else if (result < 0) {
				low = mid + 1;
			}
			else {
				low = mid;
				high = mid;
			}
		}
		
		if (comparator.compare(array[low], element) >= 0) {
			insert(low, element);
		}
		else {
			insert(low + 1, element);
		}
	}
	
	@Override
	public E removeFirst() throws NoElementException {
		return remove(0);
	}
	
	@Override
	public E removeLast() throws NoElementException {
		return remove(numElements - 1);
	}
	
	@Override
	public E remove(int index) throws InvalidPositionException {
		if (index < 0 || index >= numElements) {
			throw new InvalidPositionException();
		}
		
		E element = array[index];
		for (int i = index; i < numElements; i++) {
			array[i - 1] = array[i];
		}
		numElements--;
		return element;
	}
	
	@Override
	public boolean remove(E element) {
		int index = find(element);
		
		if (index > -1) {
			remove(index);
		}
		return index > -1;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<>(array, numElements);
	}
	
	/**
	 * Inserts an element into the specified position.
	 * @param index Position to insert the element on.
	 */
	private void insert(int index, E element) {
		if (numElements == array.length - 1) {
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
