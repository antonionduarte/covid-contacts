package dataStructures;

import exceptions.NoElementException;

public class StackInList<E> implements Stack<E> {
	
	/* Variables */
	private List<E> list;
	
	/* Constructor */
	public StackInList() {
		list = new DoublyLinkedList<E>();
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
	public E top() throws NoElementException {
		if (list.isEmpty()) {
			throw new NoElementException();
		}
		
		return list.getFirst();
	}
	
	@Override
	public void push(E element) {
		list.addFirst(element);
	}
	
	@Override
	public E pop() throws NoElementException {
		if (list.isEmpty()) {
			throw new NoElementException();
		}
		
		return list.removeFirst();
	}
	
}
