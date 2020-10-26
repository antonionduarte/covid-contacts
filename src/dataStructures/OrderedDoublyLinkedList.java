package dataStructures;

import comparators.Comparator;
import dataStructures.DoublyLinkedList.DListNode;
import exceptions.InvalidPositionException;
import exceptions.NoElementException;

/**
 * @param <E> Generic Element.
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * 
 * Ordered Doubly Linked List abstract data type.
 */

public class OrderedDoublyLinkedList<E> implements OrderedList<E> {
	
	/* Variables */
	private Comparator<E> comparator;
	private DListNode<E> head, tail;
	private int size;
	
	/**
	 * Constructor.
	 * @param comparator Comparator used to order the elements.
	 */
	public OrderedDoublyLinkedList(Comparator<E> comparator) {
		this.comparator = comparator;
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public E getFirst() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return head.getElement();
	}
	
	@Override
	public E getLast() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return tail.getElement();
	}
	
	@Override
	public E get(int position) throws InvalidPositionException {
		if (position < 0 || position >= size) {
			throw new InvalidPositionException();
		}
		return getNode(position).getElement();
	}
	
	private DListNode<E> getNode(int position) {
		DListNode<E> pointerNode;
		
		if (position < size / 2) {
			pointerNode = head;
			for (int i = 0; i < position; i++) {
				pointerNode = pointerNode.getNext();
			}
		}
		else {
			pointerNode = tail;
			for (int i = size - 1; i > position; i--) {
				pointerNode = pointerNode.getPrevious();
			}
		}
		return pointerNode;
	}
	
	@Override
	public int find(E element) {
		DListNode<E> pointerNode = head;
		
		for (int i = 0; i < size; i++) {
			if (pointerNode.getElement().equals(element)) {
				return i;
			}
			pointerNode = pointerNode.getNext();
		}
		return -1;
	}
	
	@Override
	public void insert(E element) {
		if (head == null || comparator.compare(head.getElement(), element) >= 0) {
			addFirst(element);
		}
		else if (comparator.compare(tail.getElement(), element) <= 0) {
			addLast(element);
		}
		else {
			DListNode<E> pointerNode = head;
			boolean found = false;
			
			for (int i = 0; i < size - 1 && !found; i++) {
				if (comparator.compare(pointerNode.getElement(), element) <= 0 &&
						comparator.compare(pointerNode.getNext().getElement(), element) >= 0) {
					addMiddle(i + 1, element);
					found = true;
				}
				pointerNode = pointerNode.getNext();
			}
		}
	}
	
	/**
	 * Adds a new node at the beginning of the linked list.
	 * @param element Element inside the new node.
	 */
	private void addFirst(E element) {
		head = new DListNode<>(element, null, head);
		
		if (tail == null) {
			tail = head;
		}
		else {
			head.getNext().setPrevious(head);
		}
		size++;
	}
	
	/**
	 * Adds a new node at the end of the linked list.
	 * @param element Element inside the new node.
	 */
	private void addLast(E element) {
		tail = new DListNode<>(element, tail, null);
		
		if (head == null) {
			head = tail;
		}
		else {
			tail.getPrevious().setNext(tail);
		}
		size++;
	}
	
	/**
	 * Adds a new node to the middle of the linked list.
	 * @param position Position of the new node.
	 * @param element Element inside the new node.
	 */
	private void addMiddle(int position, E element) {
		DListNode<E> nextNode = getNode(position), previousNode = nextNode.getPrevious(), newNode = new DListNode<>(element, previousNode, nextNode);
		previousNode.setNext(newNode);
		nextNode.setPrevious(newNode);
		size++;
	}
	
	/**
	 * Removes the first node in the list.
	 * Pre-condition: the list is not empty.
	 */
	private void removeFirstNode() {
		head = head.getNext();
		
		if (head == null) {
			tail = null;
		}
		else {
			head.setPrevious(null);
		}
		size--;
	}
	
	@Override
	public E removeFirst() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		
		DListNode<E> removed = head;
		removeFirstNode();
		return removed.getElement();
	}
	
	/**
	 * Removes the last node in the list.
	 * Pre-condition: the list is not empty.
	 */
	private void removeLastNode() {
		tail = tail.getPrevious();
		
		if (tail == null) {
			head = null;
		}
		else {
			tail.setNext(null);
		}
		size--;
	}
	
	@Override
	public E removeLast() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		
		DListNode<E> removed = tail;
		removeLastNode();
		return removed.getElement();
	}
	
	/**
	 * Removes the specified node from the list.
	 * Pre-condition: the node is neither the head nor the tail of the list.
	 * @param node - middle node to be removed
	 */
	private void removeMiddleNode(DListNode<E> node) {
		node.getPrevious().setNext(node.getNext());
		node.getNext().setPrevious(node.getPrevious());
		size--;
	}
	
	
	private E removeMiddle(int position) {
		DListNode<E> nodeToRemove = getNode(position);
		removeMiddleNode(nodeToRemove);
		return nodeToRemove.getElement();
	}
	
	@Override
	public E remove(int index) throws InvalidPositionException {
		if (index < 0 || index >= size) {
			throw new InvalidPositionException();
		}
		
		if (index == 0) {
			return removeFirst();
		}
		if (index == size - 1) {
			return removeLast();
		}
		return removeMiddle(index);
	}
	
	@Override
	public boolean remove(E element) {
		DListNode<E> node = findNode(element);
		
		if (node == null) {
			return false;
		}
		else if (node == head) {
			removeFirstNode();
		}
		else if (node == tail) {
			removeLastNode();
		}
		else {
			removeMiddleNode(node);
		}
		return true;
	}
	
	/**
	 * Searches for a node containing a specified element.
	 * @param element Element to be found.
	 * @return Node containing specified element (or null in case it isn't found).
	 */
	private DListNode<E> findNode(E element) {
		DListNode<E> pointerNode = head;
		
		while (pointerNode != null && !pointerNode.getElement().equals(element)) {
			pointerNode = pointerNode.getNext();
		}
		return pointerNode;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new DoublyLLIterator<>(head, tail);
	}
	
}
