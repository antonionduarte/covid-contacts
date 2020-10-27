package dataStructures;

import exceptions.InvalidPositionException;
import exceptions.NoElementException;

/**
 * @param <E> Generic Element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * 
 * List abstract data type, implemented with an array.
 */

public class ArrayList<E> implements List<E> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_SIZE = 100, GROWTH_FACTOR = 2;
	
	/* Variables */
	private E[] array;
	private int numElements;
	
	/* Constructors */
	@SuppressWarnings("unchecked")
	public ArrayList(int size) {
		array = (E[]) new Object[size];
		numElements = 0;
	}
	
	public ArrayList() {
		this(DEFAULT_SIZE);
	}
	
	/* Methods */
	
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
		return array[numElements - 1];
	}
	
	@Override
	public E remove(E element) {
		int index = find(element);
		
		if (index > -1) {
			return remove(index);
		}
		return null;
	}
	
	@Override
	public void append(List<E> list) {
		if (numElements + list.size() > array.length) {
			resize();
		}
		
		for (int i = 0; i < list.size(); i++) {
			array[numElements + i] = list.get(i);
		}
	}
	
	@Override
	public E remove(int index) throws InvalidPositionException {
		if (index < 0 || index >= numElements) {
			throw new InvalidPositionException();
		}
		
		E element = array[index];
		for (int i = index; i < numElements - 1; i++) {
			array[i] = array[i + 1];
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
		if (numElements == array.length - 1) {
			resize();
		}
		
		for (int i = numElements - 1; i >= index; i--) {
			array[i + 1] = array[i];
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
		return new ArrayListIterator<>(array, numElements);
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
