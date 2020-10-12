package dataStructures;

/**
 * Doubly linked list Implementation
 * @param <E> Generic Element
 * @author AED  Team
 * @version 1.0
 */
public class DoublyLinkedList<E> implements List<E> {
	
	/* Constants */
	private static final long serialVersionUID = 0L;
	
	protected static class DListNode<E> {
		
		/* Variables */
		private E element;
		private DListNode<E> previous, next;
		
		public DListNode(E elem, DListNode<E> thePrev, DListNode<E> theNext) {
			element = elem;
			previous = thePrev;
			next = theNext;
		}
		
		public DListNode(E theElement) {
			this(theElement, null, null);
		}
		
		public E getElement() {
			return element;
		}
		
		public DListNode<E> getNext() {
			return next;
		}
		
		public DListNode<E> getPrevious() {
			return previous;
		}
		
		public void setElement(E newElement) {
			element = newElement;
		}
		
		public void setNext(DListNode<E> newNext) {
			next = newNext;
		}
		
		public void setPrevious(DListNode<E> newPrevious) {
			previous = newPrevious;
		}
		
	}
	
	
	/* Variables */
	protected DListNode<E> head, tail;
	protected int size;
	
	public DoublyLinkedList() {
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
	public int find(E element) {
		DListNode<E> pointerNode = head;
		
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
		if (position < 0 || position >= size)
			throw new InvalidPositionException();
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
	public void addFirst(E element) {
		head = new DListNode<>(element, null, head);
		
		if (tail == null) {
			tail = head;
		}
		else {
			head.getNext().setPrevious(head);
		}
		size++;
	}
	
	@Override
	public void addLast(E element) {
		tail = new DListNode<>(element, tail, null);
		
		if (head == null) {
			head = tail;
		}
		else {
			tail.getPrevious().setNext(tail);
		}
		size++;
	}
	
	private void addMiddle(int position, E element) {
		DListNode<E> nextNode = getNode(position), previousNode = nextNode.getPrevious(), newNode = new DListNode<>(element, previousNode, nextNode);
		previousNode.setNext(newNode);
		nextNode.setPrevious(newNode);
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
			addMiddle(position, element);
		}
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
	public E remove(int position) throws InvalidPositionException {
		if (position < 0 || position >= size) {
			throw new InvalidPositionException();
		}
		
		if (position == 0) {
			return removeFirst();
		}
		if (position == size - 1) {
			return removeLast();
		}
		return removeMiddle(position);
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
		return new DoublyLLIterator<E>(head, tail);
	}
	
	/**
	 * Removes all of the elements from the specified list and
	 * inserts them at the end of the list (in proper sequence).
	 * @param list - list to be appended to the end of this
	 */
	public void append(DoublyLinkedList<E> list) {
		if (list != null && !list.isEmpty()) {
			if (isEmpty()) {
				head = list.head;
				tail = list.tail;
				size = list.size;
			}
			else {
				tail.setNext(list.head);
				list.head.setPrevious(tail);
				tail = list.tail;
				size += list.size;
			}
		}
		list = null;
	}
	
	
}
