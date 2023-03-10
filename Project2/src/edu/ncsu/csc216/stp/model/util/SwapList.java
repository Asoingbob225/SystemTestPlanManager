/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * 
 * This is the SwapList class. It implements the ISwapList interface. This
 * allows elements inside of the list to be moved to the front or to the back.
 * It can also move the element up or down in the list.
 * 
 * @param <E> the object's generic type
 * 
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
	 * 
	 * @param element element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element cannot be added
	 */
	@SuppressWarnings("unchecked")
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}

		try {
			
			if (size == list.length) {

				E[] tempList = (E[]) new Object[list.length * 2];
				for (int i = 0; i < list.length; i++) {
					tempList[i] = list[i];
				}
				list = tempList;
			}

			list[size] = element;
			size++;
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Cannot add element");
		}
		


	}

	/**
	 * Returns the element from the given index. The element is removed from the
	 * list.
	 * 
	 * @param index index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public E remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		E element = list[index];
		list[index] = null;
		for (int i = index; i < size; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return element;
	}

	/**
	 * Moves the element at the given index to index-1. If the element is already at
	 * the front of the list, the list is not changed.
	 * 
	 * @param index index of element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public void moveUp(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		if (index != 0) {
			E element = list[index];
			list[index] = list[index - 1];
			list[index - 1] = element;
		} else {
			list[index] = list[index];
		}

	}

	/**
	 * Moves the element at the given index to index+1. If the element is already at
	 * the end of the list, the list is not changed.
	 * 
	 * @param index index of element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public void moveDown(int index) {
		// add code

		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		if (index != size() - 1) {
			E element = list[index];
			list[index] = list[index + 1];
			list[index + 1] = element;
		} else {
			list[index] = list[index];
		}

	}

	/**
	 * Moves the element at the given index to index 0. If the element is already at
	 * the front of the list, the list is not changed.
	 * 
	 * @param index index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public void moveToFront(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		if (index != 0) {
			E element = list[index];
			list[index] = null;
			for (int i = index - 1; i >= 0; i--) {
				list[i + 1] = list[i];
			}
			list[0] = element;
		} else {
			list[index] = list[index];
		}
	}

	/**
	 * Moves the element at the given index to size-1. If the element is already at
	 * the end of the list, the list is not changed.
	 * 
	 * @param index index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public void moveToBack(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}

		if (index != size() - 1) {
			E element = list[index];
			list[index] = null;
			for (int i = index + 1; i < size(); i++) {
				list[i - 1] = list[i];
			}
			list[size() - 1] = element;
		} else {
			list[size() - 1] = list[size() - 1];
		}

	}

	/**
	 * Returns the element at the given index.
	 * 
	 * @param index index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return list[index];
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return this.size;
	}

}
