package dataStructures;

public class EntryClass<K, V> implements Entry<K, V> {
	
	/* Variables */
	private final K key;
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
	
	@Override
	public V setValue(V newValue) {
		V oldValue = value;
		value = newValue;
		return oldValue;
	}
	
}
