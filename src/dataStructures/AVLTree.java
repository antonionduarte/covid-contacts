package dataStructures;

public class AVLTree<K extends Comparable<K>, V> extends AdvancedBSTree<K, V> {
	
	@Override
	public V insert(K key, V value) {
		if (root == null) {
			root = new BSTNode<>(key, value);
		}
		else {
			BSTNode<K, V> parent = findPlaceToInsert(root, key);
			int result = key.compareTo(parent.getKey());
			
			if (result == 0) {
				return parent.getEntry().setValue(value);
			}
			
			AVLNode<K, V> newNode = new AVLNode<>(key, value, (AVLNode<K, V>) parent, null, null);
			
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
			
			if (nodeToRemove.getParent() != null) {
				rebalance((AVLNode<K, V>) nodeToRemove.getParent());
			}
			
			numElements--;
			return oldValue;
		}
		return null;
		
		
		// TODO
		V valueToReturn = null;
		AVLNode<K, V> node = null; // father of node where the key was deleted
		
		if (node != null) //(if find(key)==null)
			rebalance(node); // rebalance up from the node
		return valueToReturn;
	}
	
	/**
	 * Auxiliary method called by insert and remove.
	 * Traverses the path from X to the root. For each node encountered, we recompute its height
	 * and perform a trinode restructuring if it's unbalanced.
	 * the rebalance is completed with O(log n)running time
	 */
	private void rebalance(AVLNode<K, V> x) {
		if (x.isInternal())
			x.setHeight();
		// Melhorar se possivel
		while (x != null) {  // traverse up the tree towards the root
			x = (AVLNode<K, V>) x.getParent();
			x.setHeight();
			if (!x.isBalanced()) {
				//perform a trinode restructuring at zPos's tallest grandchild
				//If yPos (tallerChild(zPos)) denote the child of zPos with greater height.
				//Finally, let xPos be the child of yPos with greater height
				AVLNode<K, V> xPos = x.tallestChild().tallestChild();
				x = (AVLNode<K, V>) restructure(xPos); // tri-node restructure (from parent class)
				//note that zPos now may be a different node (the new root of the tri-node)
				
				// recompute heights for these 3 nodes
				((AVLNode<K, V>) x.getLeft()).setHeight();
				((AVLNode<K, V>) x.getRight()).setHeight();
				x.setHeight();
			}
		}
	}
	
	/**
	 *
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
			height = 1 + tallestChild().getHeight();
			return height;
		}
		
		/**
		 * Returns the tallest child node.
		 */
		protected AVLNode<K, V> tallestChild() {
			AVLNode<K, V> leftChild = (AVLNode<K, V>) getLeft(), rightChild = (AVLNode<K, V>) getRight();
			int leftChildHeight = getHeight((AVLNode<K, V>) getLeft()), rightChildHeight = getHeight((AVLNode<K, V>) getRight();
			
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
