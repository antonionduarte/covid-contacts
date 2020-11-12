package dataStructures;

import dataStructures.CollisionList.CollisionNode;
import exceptions.NoSuchElementException;

public class CollisionIterator<E> implements Iterator<E> {

	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */ 
	private CollisionNode<E> firstNode, next;

	/**
	 * Constructor.
	 * @param firstNode Node with the first element of the iteration.
	 */
	public CollisionIterator(CollisionNode<E> firstNode) {
		this.firstNode = firstNode;
		this.next = firstNode;
		this.rewind();
	}

	/* Variables */

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public E next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		CollisionNode<E> node = next;
		next = next.getNext();
		return node.getElement();
	}

	@Override
	public void rewind() {
		next = firstNode;
	}
	
}
