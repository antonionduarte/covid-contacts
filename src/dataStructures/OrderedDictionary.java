package dataStructures;

import exceptions.NoElementException;

/**
 * Ordered Dictionary interface
 * @param <K> Generic type Key, must extend comparable
 * @param <V> Generic type Value
 * @author AED team
 * @version 1.0
 */
public interface OrderedDictionary<K extends Comparable<K>, V> extends Dictionary<K, V> {
	
	/**
	 * @return Entry with the smallest key.
	 */
	Entry<K, V> minEntry() throws NoElementException;
	
	/**
	 * @return Entry with the largest key.
	 */
	Entry<K, V> maxEntry() throws NoElementException;
	
} 

