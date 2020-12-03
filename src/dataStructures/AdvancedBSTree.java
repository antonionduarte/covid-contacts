package dataStructures;

public class AdvancedBSTree<K extends Comparable<K>, V> extends BinarySearchTree<K, V> {
	
	/**
	 * Performs a single right rotation rooted at Y node.
	 * Node X is a  left  child  of Y before the  rotation, then Y becomes the right child of X after the rotation.
	 * @param y - root of the rotation
	 * @pre: Y has a left child
	 *   Y				X
	 *  /	turns into:	 \
	 * X 				  Y
	 */
	protected void rotateRight(BSTNode<K, V> y) {
		BSTNode<K, V> x = y.getLeft();
		
		y.setLeft(x.getRight());
		x.setRight(y);
		x.setParent(y.getParent());
		y.setParent(x);
		
		parentYXChildSwap(x);
	}
	
	/**
	 * Performs a single left rotation rooted at Y node.
	 * Node X is a right child of Y before the rotation, then Y becomes the left child of X after the rotation.
	 * @param y - root of the rotation
	 * @pre: Y has a right child
	 * Y				  X
	 *  \  turns into:	 /
	 *   X 				Y
	 */
	protected void rotateLeft(BSTNode<K, V> y) {
		BSTNode<K, V> x = y.getRight();
		
		y.setRight(x.getLeft());
		x.setLeft(y);
		x.setParent(y.getParent());
		y.setParent(x);
		
		parentYXChildSwap(x);
	}
	
	/**
	 * Auxiliary method for rotateLeft and rotateRight.
	 * Swaps the parents' y child node with the new x node after their rotation.
	 * @param x Top node after rotation.
	 */
	private void parentYXChildSwap(BSTNode<K, V> x) {
		BSTNode<K, V> xParent = x.getParent();
		
		if (xParent != null) {
			if (xParent.getLeft() == y) {
				xParent.setLeft(x);
			}
			else {
				xParent.setRight(x);
			}
		}
		else {
			root = x;
		}
	}
	
	/**
	 * Performs a tri-node restructuring (a single or double rotation).
	 * Assumes the nodes are in one of following configurations:
	 * @param x Node that has both a parent y and a grandparent z.
	 * <pre>
	 *          z=c       z=c        z=a         z=a
	 *         /  \      /  \       /  \        /  \
	 *       y=b  t4   y=a  t4    t1  y=c     t1  y=b
	 *      /  \      /  \           /  \         /  \
	 *    x=a  t3    t1 x=b        x=b  t4       t2 x=c
	 *   /  \          /  \       /  \             /  \
	 *  t1  t2        t2  t3     t2  t3           t3  t4
	 * </pre>
	 * @return The new root of the restructured subtree.
	 */
	protected BSTNode<K, V> restructure(BSTNode<K, V> x) {
		BSTNode<K, V> y = x.getParent(), z = y.getParent();
		boolean directionZY = z.getRight() == y, directionYX = y.getRight() == x; // false represents left and vice versa.
		
		if (!directionZY && !directionYX) {
			rotateRight(z);
		}
		else if (!directionZY && directionYX) {
			rotateLeft(y);
			rotateRight(z);
		}
		else if (directionZY && !directionYX) {
			rotateRight(y);
			rotateLeft(z);
		}
		else {
			rotateLeft(z);
		}
		
		return directionZY == directionYX ? y : x;
	}
	
}

