package dataStructures;

public class EntryClass<K,V> implements Entry<K,V> {

	/* Variables */

	private K key;
	private V value;

	/**
	 * Constructor.
	 * @param key The key of the entry to create.
	 * @param value The value of the entry to create.
	 */
	public EntryClass(K key, V value) {
		this.key = key;
		this.value = value;
	}

	/* Methods */

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}
	
}
