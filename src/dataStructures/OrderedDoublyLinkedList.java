package dataStructures;

import comparators.Comparator;

public class OrderedDoublyLinkedList<E> extends DoublyLinkedList<E> implements OrderedList<E> {
	
	/* Variables */
	Comparator<E> comparator;
	
	/**
	 * Constructor.
	 * @param comparator Comparator used to order the elements.
	 */
	public OrderedDoublyLinkedList(Comparator<E> comparator) {
		super();
		this.comparator = comparator;
	}
	
	@Override
	public void insert(E element) {
		DListNode<E> pointerNode = head;
		
		for (int i = 0; pointerNode != null; i++) {
			if (comparator.compare(pointerNode.getElement(), element) == 0) {
				//TODO
			}
			pointerNode = pointerNode.getNext();
		}
	}
}
