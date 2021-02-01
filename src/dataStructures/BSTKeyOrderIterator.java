package dataStructures;

import dataStructures.BinarySearchTree.BSTNode;
import covidContacts.exceptions.NoSuchElementException;

/**
 * @author Antonio Duarte (58278).
 * @author Goncalo Virginia (56773).
 * BST Key Order Iterator implementation.
 * @param <K> Key.
 * @param <V> Value.
 */

public class BSTKeyOrderIterator<K, V> implements Iterator<Entry<K, V>> {
	
	/* Constants */
	private static final long serialVersionUID = 1L;
	
	/* Variables */
	private final BSTNode<K, V> root;
	private Stack<BSTNode<K, V>> stack;
	private final int numElements;
	
	/**
	 * Constructor.
	 * @param root BST root node.
	 */
	public BSTKeyOrderIterator(BSTNode<K, V> root, int numElements) {
		this.root = root;
		this.numElements = numElements;
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
		
		if (numElements != 0) {
			stack.push(root);
			stackLeftNodes();
		}
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
