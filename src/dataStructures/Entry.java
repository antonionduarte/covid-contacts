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
}
