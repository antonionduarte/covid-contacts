package dataStructures;

import exceptions.NoElementException;

/**
 * BinarySearchTree implementation
 * @param <K> Generic type Key, must extend comparable
 * @param <V> Generic type Value
 * @author AED team
 * @version 1.0
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements OrderedDictionary<K, V> {
	
	/* Variables */
	protected BSTNode<K, V> root;
	protected int numElements;
	
	/* Constructor */
	public BinarySearchTree() {
		root = null;
		numElements = 0;
	}
	
	/**
	 * @param node Specified node.
	 * @return Nodes' number of children nodes.
	 */
	private int numChildren(BSTNode<K, V> node) {
		int numChildren = 0;
		boolean[] hasChildren = {node.getLeft() != null, node.getRight() != null};
		for (boolean b : hasChildren) {
			numChildren++;
		}
		return numChildren;
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}
	
	@Override
	public int size() {
		return numElements;
	}
	
	@Override
	public V find(K key) {
		BSTNode<K, V> node = findNode(root, key);
		return node == null ? null : node.getValue();
	}
	
	/**
	 * Searches for a node with the specified key recursively.
	 * @param node Current node.
	 * @param key Specified key.
	 * @return Node with the specified key || Null.
	 */
	private BSTNode<K, V> findNode(BSTNode<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		
		int result = key.compareTo(node.getKey());
		
		if (result < 0) {
			return findNode(node.getLeft(), key);
		}
		if (result > 0) {
			return findNode(node.getRight(), key);
		}
		return node;
	}
	
	@Override
	public Entry<K, V> minEntry() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return minNode(root).getEntry();
	}
	
	/**
	 * Auxiliary method to search for the smallest node recursively.
	 * @param node Current node.
	 * @return The smallest node.
	 */
	private BSTNode<K, V> minNode(BSTNode<K, V> node) {
		return node.getLeft() == null ? node : minNode(node.getLeft());
	}
	
	@Override
	public Entry<K, V> maxEntry() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return maxNode(root).getEntry();
	}
	
	/**
	 * Auxiliary method to search for the largest node recursively.
	 * @param node Current node.
	 * @return The largest node.
	 */
	private BSTNode<K, V> maxNode(BSTNode<K, V> node) {
		return node.getRight() == null ? node : maxNode(node.getRight());
	}
	
	@Override
	public V insert(K key, V value) {
		if (root == null) {
			root = new BSTNode<>(key, value);
		}
        else{
			BSTNode<K, V> parent = findPlaceToInsert(root, key);
			int result = key.compareTo(parent.getKey());
			
			if (result == 0) {
				return parent.getEntry().setValue(value);
			}
			
			BSTNode<K, V> newNode = new BSTNode<>(key, value, parent, null, null);
			
			if (result < 0) {
				parent.setLeft(newNode);
			}
			else {
				parent.setRight(newNode);
			}
		}
		numElements++;
		return null;
	}
	
	/**
	 * Auxiliary method to find a parent node to put a new node.
	 * @param node Current node.
	 * @param key Specified key.
	 * @return Parent of the new node.
	 */
	private BSTNode<K, V> findPlaceToInsert(BSTNode<K, V> node, K key) {
		int result = key.compareTo(node.getKey());
		
		if (result < 0 && node.getLeft() != null) {
			return findPlaceToInsert(node.getLeft(), key);
		}
		if (result > 0 && node.getRight() != null) {
			return findPlaceToInsert(node.getRight(), key);
		}
		return node;
	}
	
	@Override
	public V remove(K key) {
		BSTNode<K, V> nodeToRemove = findNode(root, key);
		
		if (nodeToRemove != null) {
			if (numChildren(nodeToRemove) < 2) {
				replaceNodeWithChild(nodeToRemove);
			}
			else {
				BSTNode<K, V> leftMax = maxNode(nodeToRemove.getLeft());
				replaceNodeWithChild(leftMax);
				nodeToRemove.setEntry(leftMax.getEntry());
			}
		}
		numElements--;
		return nodeToRemove == null ? null : nodeToRemove.getValue();
	}
	
	/**
	 * Auxiliary method that replaces the specified node by its child.
	 * @param nodeToRemove Node to remove.
	 */
	private void replaceNodeWithChild(BSTNode<K, V> nodeToRemove) {
		if (nodeToRemove.getLeft() != null) {
			nodeToRemove = nodeToRemove.getLeft();
		}
		else if (nodeToRemove.getRight() != null) {
			nodeToRemove = nodeToRemove.getRight();
		}
		else {
			nodeToRemove = null;
		}
	}
	
	/**
	 * @return New ordered entry iterator.
	 */
	public Iterator<Entry<K, V>> iterator() {
		return new BSTKeyOrderIterator<>(root);
	}
	
	/**
	 * BST node implementation.
	 * @param <K> Generic type Key.
	 * @param <V> Generic type Value.
	 * @author AED team
	 * @version 1.0
	 */
	static class BSTNode<K, V> {
		
		/* Variables */
		private EntryClass<K, V> entry;
		private BSTNode<K, V> parent, leftChild, rightChild;
		
		/**
		 * Constructor.
		 * @param key Nodes' key.
		 * @param value Nodes' value.
		 * @param left Left child node.
		 * @param right Right child node.
		 */
		public BSTNode(K key, V value, BSTNode<K, V> parent, BSTNode<K, V> left, BSTNode<K, V> right) {
			entry = new EntryClass<>(key, value);
			this.parent = parent;
			leftChild = left;
			rightChild = right;
		}
		
		/**
		 * Constructor.
		 * @param key Nodes' key.
		 * @param value Nodes' value.
		 */
		public BSTNode(K key, V value) {
			this(key, value, null, null, null);
		}
		
		/**
		 * @return Parent node.
		 */
		public BSTNode<K, V> getParent() {
			return parent;
		}
		
		/**
		 * Sets a new parent node.
		 * @param newParent New parent node.
		 */
		public void setParent(BSTNode<K, V> newParent) {
			parent = newParent;
		}
		
		/**
		 * @return Left child node.
		 */
		public BSTNode<K, V> getLeft() {
			return leftChild;
		}
		
		/**
		 * Sets a new left child node.
		 * @param newLeft New left child node.
		 */
		public void setLeft(BSTNode<K, V> newLeft) {
			leftChild = newLeft;
		}
		
		/**
		 * @return Right child node.
		 */
		public BSTNode<K, V> getRight() {
			return rightChild;
		}
		
		/**
		 * Sets a new right child node.
		 * @param newRight New right child node.
		 */
		public void setRight(BSTNode<K, V> newRight) {
			rightChild = newRight;
		}
		
		/**
		 * @return Entry (key and value).
		 */
		public EntryClass<K, V> getEntry() {
			return entry;
		}
		
		/**
		 * Assigns a new entry (key and value) to the node.
		 * @param newEntry New entry.
		 */
		public void setEntry(EntryClass<K, V> newEntry) {
			entry = newEntry;
		}
		
		/**
		 * @return Nodes' key.
		 */
		public K getKey() {
			return entry.getKey();
		}
		
		/**
		 * @return Nodes' value.
		 */
		public V getValue() {
			return entry.getValue();
		}
		
		/**
		 * Replaces the nodes' value.
		 * @param newValue New value.
		 */
		public void setValue(V newValue) {
			entry.setValue(newValue);
		}
		
		/**
		 * @return True if the node has at least one child node.
		 */
		public boolean isInternal() {
			return leftChild != null || rightChild != null;
		}
		
		/**
		 * @return True if the node has no child nodes.
		 */
		public boolean isLeaf() {
			return leftChild == null && rightChild == null;
		}
		
	}
	
}

