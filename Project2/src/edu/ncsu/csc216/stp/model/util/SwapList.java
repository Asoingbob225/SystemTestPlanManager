/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * 
 * This is the SwapList class. It implements the 
 * ISwapList<E> interface. This allows elements
 * inside of the list to be moved to the front or to the back. It can
 * also move the element up or down in the list.
 * @author yujim
 *
 */
public class SwapList<E> implements ISwapList<E> {
	/** a constant value for initializing the list size **/
	public static final int INIT_SIZE = 10;
	/** an array of type E **/
	private E[] list;
	/** the size of the list */
	private int size;

	/**
	 * This is the constructor for the SwapList
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		size = 0;
		list = (E[]) new Object[INIT_SIZE];
	}
	
	/**
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	public void add(E element) {
		//add code
	}
	
	/**
	 * This checks the capacity of the list at a certain size
	 * @param size the size to check at
	 */
	private void checkCapacity(int size) {
		//add code
	}
	
	/**
	 * Returns the element from the given index.  The element is
	 * removed from the list.
	 * @param idx index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public E remove(int index) {
		return null;
	}
	
	/**
	 * Checks what is at the given index
	 * @param index the index to check
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	private void checkIndex(int index) {
		//add code
	}
	
	/**
	 * Moves the element at the given index to index-1.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveUp(int index) {
		//add code
	}
	
	/**
	 * Moves the element at the given index to index+1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveDown(int index) {
		//add code
	}
	
	/**
	 * Moves the element at the given index to index 0.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveToFront(int index) {
		//add code
	}
	
	/**
	 * Moves the element at the given index to size-1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public void moveToBack(int index) {
		//add code
	}
	
	/**
	 * Returns the element at the given index.
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	public E get(int index) {
		return null;
	}

	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	public int size() {
		return this.size;
	}
	
	
}
