package dataStructures;

public class AVLTree<K extends Comparable<K>, V> extends AdvancedBSTree<K, V> {
	
	@Override
	public V insert(K key, V value) {
		if (root == null) {
			root = new AVLNode<>(key, value);
		}
		else {
			AVLNode<K, V> parent = (AVLNode<K, V>) findPlaceToInsert(root, key);
			int result = key.compareTo(parent.getKey());
			
			if (result == 0) {
				return parent.getEntry().setValue(value);
			}
			
			AVLNode<K, V> newNode = new AVLNode<>(key, value, parent, null, null);
			
			if (result < 0) {
				parent.setLeft(newNode);
			}
			else {
				parent.setRight(newNode);
			}
			
			rebalance(newNode);
		}
		numElements++;
		return null;
	}
	
	@Override
	public V remove(K key) {
		BSTNode<K, V> nodeToRemove = findNode(root, key);
		
		if (nodeToRemove != null) {
			V oldValue = nodeToRemove.getValue();
			
			if (numChildren(nodeToRemove) < 2) {
				replaceNodeWithChild(nodeToRemove);
			}
			else {
				BSTNode<K, V> leftMax = maxNode(nodeToRemove.getLeft());
				nodeToRemove.setEntry(leftMax.getEntry());
				replaceNodeWithChild(leftMax);
			}
			
			rebalance((AVLNode<K, V>) nodeToRemove);
			
			numElements--;
			return oldValue;
		}
		return null;
	}
	
	/**
	 * Auxiliary method called by insert and remove.
	 * Traverses the path from Z to the root. For each node encountered, we recompute its height
	 * and perform a trinode restructuring if it's unbalanced.
	 * The rebalancing is completed with O(log2(n)) time complexity.
	 */
	private void rebalance(AVLNode<K, V> z) {
		if (z.isInternal()) {
			z.setHeight();
		}
		
		while (z.getParent() != null) {
			z = (AVLNode<K, V>) z.getParent();
			z.setHeight();
			
			if (!z.isBalanced()) {
				z = (AVLNode<K, V>) restructure(z.tallestChild().tallestChild());
				
				((AVLNode<K, V>) z.getLeft()).setHeight();
				((AVLNode<K, V>) z.getRight()).setHeight();
				z.setHeight();
				
				return;
			}
		}
	}
	
	/**
	 * @param <K>
	 * @param <V>
	 */
	static class AVLNode<K, V> extends BSTNode<K, V> {
		
		/* Variables */
		private int height;
		
		/**
		 * Constructor.
		 * @param key Nodes' key.
		 * @param value Nodes' value.
		 */
		public AVLNode(K key, V value) {
			super(key, value);
			height = 1;
		}
		
		/**
		 * Constructor.
		 * @param key Nodes' key.
		 * @param value Nodes' value.
		 * @param parent Nodes' parent node.
		 * @param left Nodes' left child node.
		 * @param right Nodes' right child node.
		 */
		public AVLNode(K key, V value, AVLNode<K, V> parent, AVLNode<K, V> left, AVLNode<K, V> right) {
			super(key, value, parent, left, right);
			height = 1 + Math.max(getHeight(left), getHeight(right));
		}
		
		protected int getHeight(AVLNode<K, V> node) {
			return node == null ? 0 : node.getHeight();
		}
		
		public int getHeight() {
			return height;
		}
		
		public boolean isBalanced() {
			int dif = getHeight((AVLNode<K, V>) getLeft()) - getHeight((AVLNode<K, V>) getRight());
			return dif >= -1 && dif <= 1;
		}
		
		public int setHeight() {
			return height = 1 + getHeight(tallestChild());
		}
		
		/**
		 * Returns the tallest child node.
		 */
		protected AVLNode<K, V> tallestChild() {
			AVLNode<K, V> leftChild = (AVLNode<K, V>) getLeft(), rightChild = (AVLNode<K, V>) getRight();
			int leftChildHeight = getHeight((AVLNode<K, V>) getLeft()), rightChildHeight = getHeight((AVLNode<K, V>) getRight());
			
			if (leftChildHeight > rightChildHeight) {
				return leftChild;
			}
			if (leftChildHeight < rightChildHeight) {
				return rightChild;
			}
			return null;
		}
		
	}
	
}
