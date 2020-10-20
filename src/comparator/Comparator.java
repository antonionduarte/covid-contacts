package comparator;

public interface Comparator<E> {
  
  /**
   * Compares two elements of a generic type.
   * Possible return values:
   * -1 in case element < element2
   * 0 in case element == element2
   * 1 in case element > element2
   * @param element
   * @param element2
   * @return Either -1, 0 or 1 dependent on the
   * relation between the elements.
   */
  int compare(E element, E element2);

}
