package dataStructures;

public class CollisionList<K, V> implements Dictionary<K, V> {

	/* Variables */

	private CollisionNode<Entry<K, V>> head, tail;
	private int size;

	/**
	 * Constructor for Collision List.
	 */
	public CollisionList() {
		head = null;
		tail = null;
		size = 0;
	}

	/* Methods */

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public V find(K key) {
		CollisionNode<Entry<K, V>> pointerNode = head;

		while (pointerNode.getElement() != null) {
			if (pointerNode.getElement().getKey().equals(key)) {
				return pointerNode.getElement().getValue();
			}
		}

		return null;
	}

	@Override
	public V insert(K key, V value) {
		Entry<K, V> entry = new EntryClass<K, V>(key, value);
		tail = new CollisionNode<>(entry, tail, null);

		CollisionNode<Entry<K, V>> node = findNode(key);
		Entry<K,V> previous;

		if (node != null) {
			previous = node.getElement();
			node.setElement(previous);
			return previous.getValue();
		}
		else if (head == null) {
			head = tail;
		}
		else {
			tail.getPrevious().setNext(tail);
		}

		size++;
		return null;
	}

	@Override
	public V remove(K key) {
		CollisionNode<Entry<K, V>> node = findNode(key);

		if (node == null) {
			return null;
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

		return node.getElement().getValue();
	}

		
	/**
	 * Removes the first node in the list. Pre-condition: the list is not empty.
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

	/**
	 * Removes the last node in the list. Pre-condition: the list is not empty.
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

	/**
	 * Removes the specified node from the list. Pre-condition: the node is neither the head nor the tail of the list.
	 * @param node - middle node to be removed
	 */
	private void removeMiddleNode(CollisionNode<Entry<K, V>> node) {
		node.getPrevious().setNext(node.getNext());
		node.getNext().setPrevious(node.getPrevious());
		size--;
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new CollisionIterator<>(head);
	}

		/**
	 * Searches for a node containing a specified element.
	 * @param element Element to be found.
	 * @return Node containing specified element (or null in case it isn't found).
	 */
	private CollisionNode<Entry<K, V>> findNode(K key) {
		CollisionNode<Entry<K, V>> pointerNode = head;
		
		while (pointerNode != null && !pointerNode.getElement().getKey().equals(key)) {
			pointerNode = pointerNode.getNext();
		}

		return pointerNode;
	}

	
	/**
	 * Doubly linked node.
	 * @param <E> Generic element.
	 */
	protected static class CollisionNode<E> {
	
		/* Variables */
		private E element;
		private CollisionNode<E> previous, next;
	
		public CollisionNode(E elem, CollisionNode<E> thePrev, CollisionNode<E> theNext) {
			element = elem;
			previous = thePrev;
			next = theNext;
		}
	
		public CollisionNode(E theElement) {
			this(theElement, null, null);
		}
	
		public E getElement() {
			return element;
		}
	
		public void setElement(E newElement) {
			element = newElement;
		}
	
		public CollisionNode<E> getNext() {
			return next;
		}
	
		public void setNext(CollisionNode<E> newNext) {
			next = newNext;
		}
	
		public CollisionNode<E> getPrevious() {
			return previous;
		}
	
		public void setPrevious(CollisionNode<E> newPrevious) {
			previous = newPrevious;
		}
	
	}
	
}
