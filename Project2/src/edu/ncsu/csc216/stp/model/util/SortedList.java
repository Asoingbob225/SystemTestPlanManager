/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * This is the SortedList class. It implements the ISortedList interface.
 * This is a list that can take any list of elements and sorts them.
 * 
 * @param <E> the object's generic type
 * 
 * @author stbeuav
 *
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** The size of the sorted list */
	private int size;

	/** The front of the sorted list */
	private ListNode front = new ListNode(null);

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
			throw new NullPointerException("Cannot add null element.");
		}

		ListNode temp = front;
		if (size() != 0) {
			for (int i = 0; i < size(); i++) {
				if (element.compareTo(temp.data) == 0) {
					throw new IllegalArgumentException("Cannot add duplicate element.");
				}
				temp = temp.next;
			}
		}

		if (front == null || front.data.compareTo(element) > 0) {
			front = new ListNode(element, front);
		} else {
			temp = front;
			while (temp.next != null && temp.next.data.compareTo(element) < 0) {
				temp = temp.next;
			}
			temp.next = new ListNode(element, temp.next);
		}
		size++;
	}

	/**
	 * Returns the element from the given index. The element is removed from the
	 * list.
	 * 
	 * @param index index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the index is out of bounds for the list
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index.");
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
			if (current.data == element) {
				return true;
			}
			current = current.next;
		}
		return false;
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
			throw new IndexOutOfBoundsException("Invalid index.");
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
		return size;
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


}
