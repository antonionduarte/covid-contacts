package dataStructures;

import dataStructures.DoublyLinkedList.DListNode;
import covidContacts.exceptions.NoSuchElementException;

/**
 * @param <E> Generic Element.
 * Two Way Iterator for a Doubly Linked List.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 */

class DoublyLLIterator<E> implements TwoWayIterator<E> {
	
	/* Constants */
	static final long serialVersionUID = 0L;
	
	/* Variables */
	protected DListNode<E> firstNode, lastNode, prevToReturn, nextToReturn;
	
	/**
	 * Constructor.
	 * @param first Node with the first element of the iteration.
	 * @param last Node with the last element of the iteration.
	 */
	public DoublyLLIterator(DListNode<E> first, DListNode<E> last) {
		firstNode = first;
		lastNode = last;
		this.rewind();
	}
	
	@Override
	public void rewind() {
		nextToReturn = firstNode;
		prevToReturn = null;
	}
	
	@Override
	public void fullForward() {
		prevToReturn = lastNode;
		nextToReturn = null;
	}
	
	@Override
	public boolean hasNext() {
		return nextToReturn != null;
	}
	
	@Override
	public boolean hasPrevious() {
		return prevToReturn != null;
	}
	
	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		DListNode<E> node = nextToReturn;
		nextToReturn = nextToReturn.getNext();
		return node.getElement();
	}
	
	@Override
	public E previous() throws NoSuchElementException {
		if (!hasPrevious()) {
			throw new NoSuchElementException();
		}
		
		DListNode<E> node = prevToReturn;
		prevToReturn = prevToReturn.getPrevious();
		return node.getElement();
	}
	
}
