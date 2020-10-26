package dataStructures;

import exceptions.InvalidPositionException;
import exceptions.NoElementException;

/**
 * Singly linked list Implementation
 * @param <E> Generic Element
 * @author AED Team
 * @version 1.0
 */
public class SinglyLinkedList<E> implements List<E> {
	
	/* Constants */
	private static final long serialVersionUID = 0L;
	
	protected static class SListNode<E> {
		
		/* Variables */
		private E element;
		private SListNode<E> next;
		
		/**
		 * Constructor.
		 * @param element Element stored in the node.
		 * @param theNext Next node.
		 */
		public SListNode(E element, SListNode<E> theNext) {
			this.element = element;
			next = theNext;
		}
		
		/**
		 * Constructor.
		 * @param element Element stored in the node.
		 */
		public SListNode(E element) {
			this(element, null);
		}
		
		public E getElement() {
			return element;
		}
		
		public SListNode<E> getNext() {
			return next;
		}
		
		public void setElement(E newElement) {
			element = newElement;
		}
		
		public void setNext(SListNode<E> newNext) {
			next = newNext;
		}
		
	}
	
	/* Variables */
	private SListNode<E> head, tail;
	private int size;
	
	public SinglyLinkedList() {
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
	public Iterator<E> iterator() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return new SinglyLLIterator<>(head);
	}
	
	@Override
	public int find(E element) {
		SListNode<E> pointerNode = head;
		
		for (int i = 0; pointerNode.getNext() != null; i++) {
			if (pointerNode.getElement().equals(element)) {
				return i;
			}
			pointerNode = pointerNode.getNext();
		}
		return -1;
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
		if (position < 0 || position > size - 1) {
			throw new InvalidPositionException();
		}
		
		SListNode<E> pointerNode = head;
		
		for (int i = 0; i < position; i++) {
			pointerNode = pointerNode.getNext();
		}
		return pointerNode.getElement();
	}
	
	@Override
	public void addFirst(E element) {
		head = new SListNode<>(element, head);
		size++;
		
		if (tail == null) {
			tail = head;
		}
	}
	
	@Override
	public void addLast(E element) {
		if (tail == null) {
			tail = new SListNode<>(element);
			head = tail;
		}
		else {
			tail.setNext(new SListNode<>(element));
			tail = tail.getNext();
		}
		size++;
	}
	
	@Override
	public void add(int position, E element) throws InvalidPositionException {
		if (position < 0 || position > size) {
			throw new InvalidPositionException();
		}
		
		if (position == 0) {
			addFirst(element);
		}
		else if (position == size) {
			addLast(element);
		}
		else {
			SListNode<E> pointerNode = head.getNext();
			for (int i = 1; i < position; i++) {
				pointerNode = pointerNode.getNext();
			}
			
			pointerNode.setNext(new SListNode<>(element, pointerNode.getNext()));
			size++;
		}
	}
	
	@Override
	public E removeFirst() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		
		SListNode<E> removedNode = head;
		head = head.getNext();
		
		if (head == null) {
			tail = null;
		}
		
		size--;
		return removedNode.getElement();
	}
	
	@Override
	public E removeLast() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		
		SListNode<E> removedNode = tail;
		
		if (head.getNext() == null) {
			head = null;
			tail = null;
		}
		else {
			SListNode<E> pointerNode = head;
			
			for (int i = 0; i < size - 1; i++) {
				pointerNode = pointerNode.getNext();
			}
			
			pointerNode.setNext(null);
			tail = pointerNode;
		}
		
		size--;
		return removedNode.getElement();
	}
	
	@Override
	public E remove(int position) throws InvalidPositionException {
		if (position < 0 || position > size - 1) {
			throw new InvalidPositionException();
		}
		
		if (position == 0) {
			return removeFirst();
		}
		else if (position == size - 1) {
			return removeLast();
		}
		else {
			SListNode<E> pointerNode = head.getNext();
			for (int i = 1; i < position; i++) {
				pointerNode = pointerNode.getNext();
			}
			
			pointerNode.setNext(pointerNode.getNext().getNext());
			size--;
			return pointerNode.getNext().getElement();
		}
	}
	
	@Override
	public E remove(E element) {
		int index = find(element);
		if (index > -1) {
			return remove(index);
		}
		return null;
	}
	
	@Override
	public void append(List<E> list) {
		// TODO
	}
	
}
