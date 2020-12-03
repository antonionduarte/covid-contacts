package dataStructures;

/**
 * Chained Hash table implementation
 * @param <K> Generic Key, must extend comparable
 * @param <V> Generic Value
 * @author AED Team
 * @version 1.0
 */

public class ChainedHashTable<K extends Comparable<K>, V> extends HashTable<K, V> {
	
	/* Variables */
	private Dictionary<K, V>[] table;
	
	/**
	 * Constructor of an empty chained hash table, with the specified initial
	 * capacity. Each position of the array is initialized to a new ordered list
	 * maxSize is initialized to the capacity.
	 * @param capacity Defines the table capacity.
	 */
	@SuppressWarnings("unchecked")
	public ChainedHashTable(int capacity) {
		int arraySize = nextPrime((int) (1.1 * capacity));
		// Compiler gives a warning.
		table = (Dictionary<K, V>[]) new Dictionary[arraySize];
		for (int i = 0; i < arraySize; i++)
			table[i] = new CollisionList<K, V>();
		maxSize = capacity;
		numElements = 0;
	}
	
	public ChainedHashTable() {
		this(DEFAULT_CAPACITY);
	}
	
	/* Methods */
	
	/**
	 * Returns the hash value of the specified key.
	 * @param key The key to be encoded.
	 * @return Hash value of the specified key.
	 */
	protected int hash(K key) {
		return Math.abs(key.hashCode()) % table.length;
	}
	
	@Override
	public V find(K key) {
		return table[hash(key)].find(key);
	}
	
	@Override
	public V insert(K key, V value) {
		if (isFull()) {
			rehash();
		}
		
		numElements++;
		return table[hash(key)].insert(key, value);
	}
	
	@Override
	public V remove(K key) {
		V value = table[hash(key)].remove(key);
		
		if (value != null) {
			numElements--;
		}
		return value;
	}
	
	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new TableIterator<>(table, numElements);
	}
	
	/**
	 * Rehashes the dictionary if it gets full.
	 * TODO: Perguntar ao Campones se isto funciona
	 * TODO: Lembrar-me da questão do maxSize e assim (porque acho que não tou a usar a var correcta mas logo resolvo).
	 */
	private void rehash() {
		ChainedHashTable<K, V> auxTable = new ChainedHashTable<>(maxSize);
		
		Iterator<Entry<K, V>> iterator = iterator();
		
		while (iterator.hasNext()) {
			auxTable.insert(iterator.next().getKey(), iterator.next().getValue());
		}
		
		this.maxSize = auxTable.maxSize;
		this.table = auxTable.table;
	}
	
}
