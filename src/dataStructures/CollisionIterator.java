package dataStructures;

import dataStructures.DoublyLinkedList.DListNode;
import exceptions.NoSuchElementException;

public class CollisionIterator<E> implements Iterator<E> {

	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */ 
	private DListNode<E> firstNode, nextToReturn;

	/**
	 * Constructor.
	 * @param firstNode Node with the first element of the iteration.
	 */
	public CollisionIterator(DListNode<E> firstNode) {
		this.firstNode = firstNode;
		this.rewind();
	}

	/* Public methods */

	@Override
	public boolean hasNext() {
		return nextToReturn != null;
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
	public void rewind() {
		nextToReturn = firstNode;
	}
	
}
