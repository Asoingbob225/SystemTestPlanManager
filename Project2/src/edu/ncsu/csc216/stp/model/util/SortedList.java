/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * This is the SortedList class. It implements the ISortedList<E> interface.
 * This is a list that can take any list of elements and sorts them.
 * 
 * @author stbeuav
 *
 */
public class SortedList<E> implements ISortedList<E> {

	/** The size of the sorted list */
	private int size;

	/** The front of the sorted list */
	private ListNode front;

	/**
	 * This is the constructor for the SortedList. It initializes the size at 0 and
	 * the front of the list to null
	 */
	public SortedList() {
		this.size = 0;
		this.front = null;
	}

	/**
	 * Adds the element to the list in sorted order.
	 * 
	 * @param element element to add
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element cannot be added
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		
		ListNode temp = front;
		if (size() != 0) {
			for (int i = 0; i < size(); i++) {
				if (compareTo(temp.data) == 0) {
					throw new IllegalArgumentException();
				}
				temp = temp.next;
			}
		}
		if (size == 0) {
			front = new ListNode(element, front);
			size++;
			return;
		}
		temp = front;
		for (int i = 0; i < size() - 1; i++) {
			temp = temp.next;
		}
		temp.next = new ListNode(element);
		size++;

	}

	/**
	 * Returns the element from the given index. The element is removed from the
	 * list.
	 * 
	 * @param idx index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the index is out of bounds for the list
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		E element = null;
		if (index == 0) {
			element = front.data;
			front = front.next;
		} else {
			ListNode current = front;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			element = current.next.data;
			current.next = current.next.next;
		}
		size--;
		return element;
	}

//	/**
//	 * This checks if the index is valid
//	 * 
//	 * @param index the index to check at
//	 * @throws IndexOutOfBoundsException if the index is out of bounds for the list
//	 */
//	private void checkIndex(int index) {
//		// code here
//	}

	/**
	 * Returns true if the element is in the list.
	 * 
	 * @param element element to search for
	 * @return true if element is found
	 */
	@Override
	public boolean contains(E element) {
		ListNode current = front;
		for (int i = 0; i < size(); i++) {
			if (current == element) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Returns the element at the given index.
	 * 
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the index is out of bounds for the list
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		ListNode current = front;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * This is the inner class called the ListNode. It contains data and also knows
	 * what is next in the order.
	 * 
	 * @author levic
	 *
	 */
	private class ListNode {

		/** The data */
		private E data;

		/** The next ListNode */
		private ListNode next;

		/**
		 * This is the ListNode constructor
		 * 
		 * @param data the data
		 */
		private ListNode(E data) {
			this(data, null);
		}

		/**
		 * This is the ListNode constructor with data and the next ListNode
		 * 
		 * @param data the data
		 * @param next the next ListNode
		 */
		private ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		return 0;
	}



}
