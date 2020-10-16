package dataStructures;

import java.util.Iterator;
import exceptions.*;

/**
 * List abstract data type, implemented with an array.
 * @author António Duarte.
 * @param <E> Generic Element.
 */
public class ArrayList<E> implements List<E> {

  /* Constants */

  private static final int DEFAULT_SIZE = 10;
  private static final int GROWTH_FACTOR = 2;

  /* Variables */

  private E[] array;
  private int counter;

  /**
   * Constructor of the ArrayList.
   */
  @SuppressWarnings("unchecked")
  public ArrayList() {
    array = (E[]) new Object[DEFAULT_SIZE];
    counter = 0;
  }

  /* Methods */

  @Override
  public int find(E element) {
    for (int i = 0; i < counter; i++)
      if (array[i].equals(element)) return i;
    return -1;
  }

  @Override
  public int size() {
    return counter;
  }

  @Override
  public boolean isEmpty() {
    return counter == 0;
  }

  @Override
  public E get(int index) throws InvalidPositionException {
    if (index >= counter || index < 0) throw new InvalidPositionException();
    return array[index];
  }

  @Override
  public E getFirst() throws NoElementException {
    if (isEmpty()) throw new NoElementException();
    return array[0];
  }

  @Override
  public E getLast() throws NoElementException {
    if (isEmpty()) throw new NoElementException();
    return array[counter - 1];
  }

  @Override
  public boolean remove(E element) {
    for (int i = 0; i < counter; i++) {
      if (array[i].equals(element)) {
        for (int j = i + 1; j < counter; j++)
          array[j - 1] = array[j];
        counter--;
        array[counter] = null;
        return true;
      }
    }
    return false;
  }

  @Override
  public E remove(int index) throws InvalidPositionException {
    if (index >= counter || index < 0) throw new InvalidPositionException();
    E element = array[index];
    for (int i = index + 1; i < counter; i++)
      array[i - 1] = array[i];
    counter--;
    array[counter] = null;
    return element;
  }

  @Override
  public E removeFirst() throws NoElementException {
    if (isEmpty()) throw new NoElementException();
    E element = array[0];
    for (int i = 1; i < counter; i++)
      array[i] = array[i + 1];
    counter--;
    return element;
  }

  @Override
  public E removeLast() throws NoElementException {
    if (isEmpty()) throw new NoElementException();
    E element = array[counter - 1];
    array[counter - 1] = null;
    counter--;
    return element;
  }

  @Override
  public void add(int index, E element) throws InvalidPositionException {
    if (index < 0) throw new InvalidPositionException();
    while (array.length < index) resize();
    for (int i = counter - 1; i >= index; i--)
      array[i + 1] = array[i];
    array[index] = element;
    counter++;
  }

  @Override
  public void addFirst(E element) {
    if (counter == array.length) resize();
    for (int i = counter - 1; i >= 0; i--)
      array[i + 1] = array[i];
    array[0] = element;
    counter++;
  }

  @Override
  public void addLast(E element) {
    if (counter == array.length) resize();
    array[counter] = element;
    counter++;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }

  /* Private methods */

  /**
   * Resizes the array by a specified growth factor
   */
  @SuppressWarnings("unchecked")
  private void resize() {
    E[] tempArray = (E[]) new Object[array.length * GROWTH_FACTOR];
    for (int i = 0; i < counter; i++) 
      tempArray[i] = array[i];
    array = tempArray;
  }
  
}
