package dataStructures;

import exceptions.InvalidPositionException;
import exceptions.NoElementException;

/**
 * List abstract data type, implemented with an array.
 * @param <E> Generic Element.
 * @author António Duarte.
 */
public class ArrayList<E> implements List<E> {
	  
  /* Constants */
  private static final long serialVersionUID = 1L;
	private static final int DEFAULT_SIZE = 10, GROWTH_FACTOR = 2;
	
	/* Variables */
	private E[] array;
	private int numElements;
	
	/* Constructor */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		array = (E[]) new Object[DEFAULT_SIZE];
		numElements = 0;
	}
	
	@Override
	public int size() {
		return numElements;
	}
	
	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}
	
	@Override
	public int find(E element) {
		for (int i = 0; i < numElements; i++) {
			if (array[i].equals(element)) {
				return i;
			}
		}
		return -1;
	}
	
	@Override
	public E get(int index) throws InvalidPositionException {
		if (index >= numElements || index < 0) {
			throw new InvalidPositionException();
		}
		return array[index];
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
		return array[numElements-1];
	}
	
	@Override
	public boolean remove(E element) {
		int index = find(element);
		
		if (index > -1) {
			remove(index);
			return true;
		}
		return false;
	}
	
	@Override
	public E remove(int index) throws InvalidPositionException {
		if (index < 0  || index >= numElements) {
			throw new InvalidPositionException();
		}
		E element = array[index];
		for (int i = index; i < numElements; i++) {
			array[i-1] = array[i];
		}
		numElements--;
		return element;
	}
	
	@Override
	public E removeFirst() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return remove(0);
	}
	
	@Override
	public E removeLast() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return array[--numElements];
	}
	
	@Override
	public void add(int index, E element) throws InvalidPositionException {
		if (index < 0 || index > numElements) {
			throw new InvalidPositionException();
		}
		if (index == array.length) {
			resize();
		}
		
		for (int i = numElements-1; i >= index; i--) {
			array[i+1] = array[i];
		}
		array[index] = element;
		numElements++;
	}
	
	@Override
	public void addFirst(E element) {
		add(0, element);
	}
	
	@Override
	public void addLast(E element) {
		add(numElements, element);
	}
	
	@Override
	public Iterator<E> iterator() {
		return null;
	}
	
	/* Private methods */
	
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
