package dataStructures;

import exceptions.NoElementException;

/**
 * @param <E> Generic Element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * Queue implementation with Doubly Linked List.
 */
public class QueueInList<E> implements Queue<E> {
	
	/* Constants */
	private static final long serialVersionUID = 0L;
	
	/* Variables */
	private List<E> list;
	
	/* Constructor */
	public QueueInList() {
		list = new DoublyLinkedList<>();
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public void enqueue(E element) {
		list.addLast(element);
	}
	
	@Override
	public E dequeue() throws NoElementException {
		if (list.isEmpty()) {
			throw new NoElementException();
		}
		
		return list.removeFirst();
	}
	
	
}
