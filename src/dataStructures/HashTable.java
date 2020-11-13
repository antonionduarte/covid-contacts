package dataStructures;

/**
 * Hash table implementation
 * @param <K> Generic Key
 * @param <V> Generic Value
 * @author AED Team
 * @version 1.0
 */

public abstract class HashTable<K, V> implements Dictionary<K, V> {
	
	/* Constants */
	protected static final int DEFAULT_CAPACITY = 50;
	protected static final int[] PRIMES = {11, 19, 31, 47, 73, 113, 181, 277, 421, 643, 967, 1451, 2179, 3299, 4951,
			7433, 11173, 16763, 25163, 37747, 56671, 85009, 127529, 191299, 287003, 430517, 645787, 968689, 1453043, 2179571,
			3269377, 4904077, 7356119, 11034223, 16551361, 24827059, 37240597, 55860923, 83791441, 125687173, 188530777,
			282796177, 424194271, 636291413, 954437161, 1431655751, 2147483647};
	
	/* Variables */
	protected int numElements, maxSize;
	
	/* Protected methods */
	
	/**
	 * Returns the hash code of the specified key, which is an integer in the range
	 * 0, ..., b-1.
	 * @param key to be encoded
	 * @return hash code of the specified key
	 */
	protected static int hash(String key) {
		int a = 127; // a is a prime number.
		int b = 2147483647; // b is a prime number.
		int hashCode = 0;
		
		for (int i = 0; i < key.length(); i++)
			hashCode = (hashCode * a + key.charAt(i)) % b;
		return hashCode;
	}
	
	/**
	 * Returns a prime number that is not less than the specified number; or zero if
	 * all such primes are greater than Integer.MAX_VALUE.
	 * @param number Number less than the next prime.
	 * @return next prime number not less than <code>number</code>, or zero if all
	 * such primes are greater than Integer.MAX_VALUE
	 */
	protected static int nextPrime(int number) {
		for (int prime : PRIMES) {
			if (prime >= number) {
				return prime;
			}
		}
		return 0;
	}
	
	/* Public Methods */
	
	@Override
	public boolean isEmpty() {
		return numElements == 0;
	}
	
	@Override
	public int size() {
		return numElements;
	}
	
	@Override
	public abstract V find(K key);
	
	@Override
	public abstract V insert(K key, V value);
	
	@Override
	public abstract V remove(K key);
	
	@Override
	public abstract Iterator<Entry<K, V>> iterator();
	
	/**
	 * @return True if the hash table cannot contain more entries.
	 */
	public boolean isFull() {
		return numElements == maxSize;
	}
	
}
