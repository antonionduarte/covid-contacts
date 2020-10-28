package dataStructures;

import exceptions.NoElementException;
import exceptions.OutOfCapacityException;

/**
 * @param <E> Generic Element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Queue implementation with an array.
 */

public class QueueInArray<E> implements Queue<E> {
	
	/* Constants */
	private static final long serialVersionUID = 0L;
	private static final int DEFAULT_CAPACITY = 1000;
	
	/* Variables */
	private E[] array;
	private int front, rear, currentSize;
	
	/**
	 * Constructor.
	 * @param capacity The queues' maximum capacity.
	 */
	@SuppressWarnings("unchecked")
	public QueueInArray(int capacity) {
		// Compiler gives a warning.
		array = (E[]) new Object[capacity];
		front = 0;
		rear = capacity - 1;
		currentSize = 0;
	}
	
	/* Constructor */
	public QueueInArray() {
		this(DEFAULT_CAPACITY);
	}
	
	@Override
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	/**
	 * @return True if the queue is full, false otherwise
	 */
	public boolean isFull() {
		return currentSize == array.length;
	}
	
	@Override
	public int size() {
		return currentSize;
	}
	
	/**
	 * Increments with "wrap around".
	 * @param index - current index
	 * @return next index
	 */
	private int nextIndex(int index) {
		return (index + 1) % array.length;
	}
	
	
	/**
	 * Inserts the specified element at the rear of the queue.
	 * @param element - element to be added to the end of the queue
	 */
	public void enqueue(E element) throws OutOfCapacityException {
		if (this.isFull()) {
			throw new OutOfCapacityException();
		}
		
		rear = this.nextIndex(rear);
		array[rear] = element;
		currentSize++;
	}
	
	
	@Override
	public E dequeue() throws NoElementException {
		if (this.isEmpty()) {
			throw new NoElementException();
		}
		
		E element = array[front];
		front = this.nextIndex(front);
		currentSize--;
		return element;
	}
	
	
}
