package dataStructures;

import dataStructures.BinarySearchTree.BSTNode;
import exceptions.NoSuchElementException;

public class BSTKeyOrderIterator<K, V> implements Iterator<Entry<K, V>> {
	
	/* Variables */
	private final BSTNode<K, V> root;
	private Stack<BSTNode<K, V>> stack;
	
	/**
	 * Constructor.
	 * @param root BST root node.
	 */
	public BSTKeyOrderIterator(BSTNode<K, V> root) {
		this.root = root;
		rewind();
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	@Override
	public Entry<K, V> next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		BSTNode<K, V> nextToReturn = stack.pop();
		
		if (nextToReturn.getRight() != null) {
			stack.push(nextToReturn.getRight());
			stackLeftNodes();
		}
		
		return nextToReturn.getEntry();
	}
	
	@Override
	public void rewind() {
		stack = new StackInList<>();
		stack.push(root);
		stackLeftNodes();
	}
	
	/**
	 * Auxiliary method to stack all leftmost nodes below the current node.
	 */
	private void stackLeftNodes() {
		while (stack.top().getLeft() != null) {
			stack.push(stack.top().getLeft());
		}
	}
	
}
