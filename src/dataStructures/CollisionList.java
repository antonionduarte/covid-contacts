package dataStructures;

import dataStructures.DoublyLinkedList.DListNode;

public class CollisionList<K, V> implements Dictionary<K, V> {
	
	/* Variables */
	private DListNode<Entry<K, V>> head, tail;
	private int size;
	
	/* Constructor */
	public CollisionList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/* Public methods */
	
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
		DListNode<Entry<K, V>> pointerNode = findNode(key);
		return pointerNode == null ? null : pointerNode.getElement().getValue();
	}
	
	@Override
	public V insert(K key, V value) {
		DListNode<Entry<K, V>> pointerNode = findNode(key);
		
		if (pointerNode != null) {
			return pointerNode.getElement().setValue(value);
		}
		
		tail = new DListNode<>(new EntryClass<>(key, value), tail, null);
		
		if (head == null) {
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
		DListNode<Entry<K, V>> pointerNode = findNode(key);
		
		if (pointerNode == null) {
			return null;
		}
		else if (pointerNode == head) {
			removeFirstNode();
		}
		else if (pointerNode == tail) {
			removeLastNode();
		}
		else {
			removeMiddleNode(pointerNode);
		}

		return pointerNode.getElement().getValue();
	}
	
	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new CollisionIterator<>(head);
	}
	
	/* Private methods */
	
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
	private void removeMiddleNode(DListNode<Entry<K, V>> node) {
		node.getPrevious().setNext(node.getNext());
		node.getNext().setPrevious(node.getPrevious());
		size--;
	}
	
	/**
	 * Searches for a node containing a specified element.
	 * @param key Key to be found.
	 * @return Node containing specified element (or null in case it isn't found).
	 */
	private DListNode<Entry<K, V>> findNode(K key) {
		DListNode<Entry<K, V>> pointerNode = head;
		
		while (pointerNode != null && !pointerNode.getElement().getKey().equals(key)) {
			pointerNode = pointerNode.getNext();
		}
		
		return pointerNode;
	}
	
}
