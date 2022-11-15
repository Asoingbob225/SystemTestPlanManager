/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * 
 * The log class implements the ILog interface. This is similar to the
 * interface, only it allows duplicate elements.
 * 
 * @param <E> the object's generic type
 * 
 * @author yujim
 *
 */
public class Log<E> implements ILog<E> {

	/** a constant value for initializing the list size **/
	public static final int INIT_SIZE = 10;
	/** an array of type E **/
	private E[] log;
	/** the size of the list */
	private int size;

	/**
	 * This is the constructor for the log
	 */
	@SuppressWarnings("unchecked")
	public Log() {
		size = 0;
		log = (E[]) new Object[INIT_SIZE];
	}

	/**
	 * Adds the element to the end of the list.
	 * 
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		log[size++] = element;
	}

	/**
	 * Returns the element at the given index.
	 * 
	 * @param index index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the index is out of bounds for the list
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return log[index];
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return this.size;
	}
}
