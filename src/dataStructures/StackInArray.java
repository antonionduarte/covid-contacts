package dataStructures;

import exceptions.EmptyStackException;
import exceptions.FullStackException;

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
	
	// Returns true iff the stack contains no elements.
	public boolean isEmpty() {
		return top == 0;
	}
	
	// Returns true iff the stack cannot contain more elements.
	public boolean isFull() {
		return top == array.length;
	}
	
	// Returns the number of elements in the stack.
	public int size() {
		return top;
	}
	
	// Returns the element at the top of the stack.
	// Requires: size() > 0
	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return array[top - 1];
	}
	
	// Inserts the specified element onto the top of the stack.
	// Requires: size() < array.length
	public void push(E element) throws FullStackException {
		if (isFull()) {
			throw new FullStackException("Stack is full.");
		}
		array[top++] = element;
	}
	
	// Removes and returns the element at the top of the stack.
	// Requires: size() > 0
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty.");
		}
		return array[--top];
	}
	
}
