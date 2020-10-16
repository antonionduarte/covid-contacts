package dataStructures;

import exceptions.*;

/**
 * Queue List Implementation
 * @param <E> Generic Element
 * @author AED  Team
 * @version 1.0
 */
public class QueueInList<E> implements Queue<E> {
	
	/**
	 * Serial Version UID of the Class
	 */
	static final long serialVersionUID = 0L;
	
	/**
	 * Memory of the queue: a list.
	 */
	protected List<E> list;
	
	/**
	 * Constructor create an empty Doubly Linked List.
	 */
	public QueueInList() {
		//TODO - inicializar o atributo list (tem que se usar new...)
	}
	
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	
	@Override
	public int size() {
		return list.size();
	}
	
	
	@Override
	public void enqueue(E element) {
		//TODO
	}
	
	
	@Override
	public E dequeue() throws NoElementException {
		if (list.isEmpty())
			throw new NoElementException();
		
    //TODO
    return null;
	}
	
	
}
