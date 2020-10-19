package dataStructures;

import exceptions.InvalidPositionException;
import exceptions.NoElementException;
import comparator.*;

public class OrderedArrayList<E> implements List<E> {

  private static final long serialVersionUID = 1L;

  public OrderedArrayList(Comparator<E> comparator) {

  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E getFirst() throws NoElementException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E getLast() throws NoElementException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E get(int position) throws InvalidPositionException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int find(E element) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void addFirst(E element) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addLast(E element) {
    // TODO Auto-generated method stub

  }

  @Override
  public void add(int position, E element) throws InvalidPositionException {
    // TODO Auto-generated method stub

  }

  @Override
  public E removeFirst() throws NoElementException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E removeLast() throws NoElementException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public E remove(int position) throws InvalidPositionException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean remove(Object element) {
    // TODO Auto-generated method stub
    return false;
  }
  
}
