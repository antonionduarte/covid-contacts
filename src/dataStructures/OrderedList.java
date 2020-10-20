package dataStructures;

import exceptions.InvalidPositionException;
import exceptions.NoElementException;

public interface OrderedList<E> {
  
  /**
   * @return True if the list is empty. (getSize() == 0)
   */
  boolean isEmpty();

  /**
   * @return Number of elements in the list.
   */
  int size();

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
   * @return The element at the given position in the list.
   * @throws InvalidPositionException If (position < 0 || position >= numElements)
   */
  E get(int position) throws InvalidPositionException;

  /**
   * Searches the Ordered Array, using Binary Search and
   * returns the position of the desired element.
   * @param element Element to be searched in the list.
   * @return The position of the first occurrence of the element in the list.
   */
  int find(E element);

  /**
   * Inserts an element in a sorted manner, depending
   * on the Comparator provided in the constructor.
   * @param element Element to be inserted in the list.
   */  
  void insert(E element);

}
