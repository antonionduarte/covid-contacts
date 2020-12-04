package dataStructures;

import dataStructures.SinglyLinkedList.SListNode;
import covidContacts.exceptions.NoSuchElementException;

/**
 * @param <E> Generic Element.
 * Iterator implementation for a Singly Linked List.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

public class SinglyLLIterator<E> implements Iterator<E> {
	
	/* Constants */
	private static final long serialVersionUID = 0L;
	
	/* Variables */
	private final SListNode<E> firstNode;
	private SListNode<E> nextToReturn;
	
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
