package dataStructures;

import dataStructures.SinglyLinkedList.SListNode;

/**
 * Implementation of Iterator for SinglyLinkedList
 * @param <E> Generic Element
 * @author AED  Team
 * @version 1.0
 */

public class SinglyLLIterator<E> implements Iterator<E> {
	
	/* Constants */
	private static final long serialVersionUID = 0L;
	
	/* Variables */
	private SListNode<E> firstNode, nextToReturn;
	
	/**
	 * Constructor.
	 * @param first Starting node for the iteration.
	 */
	public SinglyLLIterator(SListNode<E> first) {
		firstNode = first;
		this.rewind();
	}
	
	@Override
	public boolean hasNext() {
		return nextToReturn != null;
	}
	
	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		SListNode<E> node = nextToReturn;
		nextToReturn = nextToReturn.getNext();
		return node.getElement();
	}
	
	@Override
	public void rewind() {
		nextToReturn = firstNode;
	}
	
}
