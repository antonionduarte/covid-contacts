package dataStructures;

import exceptions.InvalidPositionException;
import exceptions.NoElementException;
import comparator.*;

public class OrderedArrayList<E> implements OrderedList<E> {

	/* Constants */
	private static final long serialVersionUID = 1L;
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
				
			if (comparator.compare(element, array[numElements / 2]) == 0) {
				return numElements / 2;
			}
		
		return -1;
	}

	@Override
	public E get(int position) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(E element) {
		// TODO Auto-generated method stub

	}
	
}
