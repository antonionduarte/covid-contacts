package dataStructures;

import exceptions.InvalidPositionException;
import exceptions.NoElementException;

import java.io.Serializable;

/**
 * List (sequence) Abstract Data Type
 * Includes description of general methods to be implemented by lists.
 * @param <E> Generic Element
 * @author AED  Team
 * @version 1.0
 */

public interface List<E> extends Serializable {
	
	/**
	 * @return True if the list is empty.
	 */
	boolean isEmpty();
	
	/**
	 * @return Number of elements in the list.
	 */
	int size();
	
	/**
	 * @return Iterator of the elements in the list.
	 */
	Iterator<E> iterator();
	
	/**
	 * @return First element in the list.
	 * @throws NoElementException If isEmpty() == true.
	 */
	E getFirst() throws NoElementException;
	
	/**
	 * @return Last element in the list.
	 * @throws NoElementException If isEmpty() == true.
	 */
	E getLast() throws NoElementException;
	
	/**
	 * @param position Position of the element to be returned.
	 * @return Element at the given position in the list.
	 * @throws InvalidPositionException If (position < 0 || position >= numElements)
	 */
	E get(int position) throws InvalidPositionException;
	
	/**
	 * @param element Element to be searched in the list.
	 * @return Position of the first occurrence of the element in the list (or -1 in the case it isn't found).
	 */
	int find(E element);
	
	/**
	 * Inserts the specified element at the first position in the list.
	 * @param element Element to be inserted.
	 */
	void addFirst(E element);
	
	/**
	 * Inserts the specified element at the last position in the list.
	 * @param element Element to be inserted.
	 */
	void addLast(E element);
	
	/**
	 * Inserts the specified element at the specified position in the list.
	 * @param position Position to insert the element.
	 * @param element Element to be inserted.
	 */
	void add(int position, E element) throws InvalidPositionException;
	
	/**
	 * Removes and returns the element at the first position in the list.
	 * @return Element removed from the first position in the list.
	 */
	E removeFirst() throws NoElementException;
	
	/**
	 * Removes and returns the element at the last position in the list.
	 * @return Element removed from the last position in the list.
	 */
	E removeLast() throws NoElementException;
	
	/**
	 * Removes and returns the element at the specified position in the list.
	 * @param position Position of element to be removed.
	 * @return Element removed from the specified position.
	 */
	E remove(int position) throws InvalidPositionException;
	
	/**
	 * Finds and removes the first occurrence of the specified element.
	 * @param element Element to be removed from list
	 * @return True if the element was found and removed.
	 */
	E remove(E element);
	
	/**
	 * Removes all of the elements from the specified list and
	 * inserts them at the end of the list (in proper sequence).
	 * @param list List to be appended to the end.
	 */
	void append(List<E> list);
	
}   
