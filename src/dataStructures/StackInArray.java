package dataStructures;

import exceptions.EmptyStackException;
import exceptions.FullStackException;

/**
 * @param <E> Generic Element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Stack implementation with an array.
 */

public class StackInArray<E> implements Stack<E> {
	
	/* Constants */
	private static final int DEFAULT_CAPACITY = 1000;
	
	/* Variables */
	private final E[] array;
	private int top;
	
	@SuppressWarnings("unchecked")
	public StackInArray(int capacity) {
		// Compiler gives a warning.
		array = (E[]) new Object[capacity];
		top = 0;
	}
	
	public StackInArray() {
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public boolean isEmpty() {
		return top == 0;
	}
	
	public boolean isFull() {
		return top == array.length;
	}
	
	@Override
	public int size() {
		return top;
	}
	
	@Override
	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return array[top - 1];
	}
	
	@Override
	public void push(E element) throws FullStackException {
		if (isFull()) {
			throw new FullStackException("Stack is full.");
		}
		array[top++] = element;
	}
	
	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty.");
		}
		return array[--top];
	}
	
}
