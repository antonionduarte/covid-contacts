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
	
	/**
	 * Tree Constructor - creates an empty tree.
	 */
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
	
	/**
	 * @param node Starting node.
	 * @param key Specified key.
	 * @return Node with the specified key || Null.
	 */
	protected BSTNode<K, V> findNode(BSTNode<K, V> node, K key) {
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
	public V find(K key) {
		BSTNode<K, V> node = findNode(root, key);
		if (node == null) {
			return null;
		}
		return node.getValue();
	}
	
	@Override
	public Entry<K, V> minEntry() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		//TODO
	}
	
	@Override
	public Entry<K, V> maxEntry() throws NoElementException {
		if (isEmpty()) {
			throw new NoElementException();
		}
		return maxNode(root).getEntry();
	}
	
	
	/**
	 * Returns the node with the largest key
	 * in the tree rooted at the specified node.
	 * Requires: node != null.
	 * @param node that roots the tree
	 * @return node with the largest key in the tree
	 */
	protected BSTNode<K, V> maxNode(BSTNode<K, V> node) {
		if (node.getRight() == null)
			return node;
		else
			return this.maxNode(node.getRight());
	}
	
	public V insert(K key, V value) {
		if (root == null) //arvore estava vazia
		//caso especial � inserir raiz
        else{
			BSTNode<K, V> parent = findPlaceToInsert(root, key);  //metodo auxiliar para implementarem
			//findPlaceToInsert - parecido com o findNode mas devolve pai do novo no
			
			//TODO
			/*Se chave de parent == key
			 *   Alterar valor de parent para value
			 *   devolver value antigo
			 *Senao
			 *  inserir novo no como filho esquerdo ou direito de parent
			 *  devolver null (nao esquecer o currentSize)
			 */
		}
	}
	
	/**
	 * @param root
	 * @param key
	 * @return
	 */
	private BSTNode<K, V> findPlaceToInsert(BSTNode<K, V> root, K key) {
	
	}
	
	
	//sugestao: implementar metodo auxiliary replaceParentWithChild(nodeToRemove, child) que poe
	//pai de noteToRemove a apontar para child (filho de nodeToRemove)
	public V remove(K key) {
		BSTNode<K, V> nodeToRemove = findNode(root, key);
		
		if (nodeToRemove != null) {
			/*se nodeToRemove so tem um filho ou e folha
			 *   o pai fica a apontar para esse filho (ou para null)
			 *senao  //tem 2 filhos
			 *  procurar no substituto (na subarvore esq. ou na dir.)
			 *  remover no substituto
			 *  trocar entry do nodeToRemove pela entry do no substituto
			 *  (reparem que, caso ainda nao o tenham feito, e preciso
			 *  implementar a classe EntryClass, e precisam do metodo setEntry)
			 *
			 *return ...  (nao esquecer o currentSize)
			 */
			
		}
		else  //n�o encontra n� para remover
		//return ...
	}
	
	/**
	 * @return New entry iterator.
	 */
	public Iterator<Entry<K, V>> iterator() {
		//TODO: Original comentado para nao dar erro de compilacao.
		// return new BSTKeyOrderIterator<K,V>(root);
		return null;
	}
	
	/**
	 * Ret
	 * /**
	 * BST node implementation
	 * @param <K> Generic type Key
	 * @param <V> Generic type Value
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

