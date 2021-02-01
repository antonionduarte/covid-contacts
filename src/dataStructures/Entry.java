package dataStructures;

public interface Entry<K, V> {
	
	/**
	 * @return The key in the entry.
	 */
	K getKey();
	
	/**
	 * @return The value in the entry.
	 */
	V getValue();
	
	/**
	 * Sets a new value.
	 * @param newValue New value.
	 * @return Previous value.
	 */
	V setValue(V newValue);
	
}
