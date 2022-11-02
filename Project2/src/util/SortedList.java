/**
 * 
 */
package util;

import edu.ncsu.csc216.pack_scheduler.util.LinkedAbstractList.ListNode;

/**
 * @author stbeuav
 *
 */
public class SortedList<E> implements ISortedList<E>{

	private int size;
	private ListNode front;

	public SortedList() {
		this.size = 0;
		this.front = null;
	}

	@Override
	public void add(E element) {
		//code here
		
	}

	@Override
	public E remove(int index) {
		return null;
	}

	private void checkIndex(int index) {
		//code here
	}
	
	@Override
	public boolean contains(E element) {
		return false;
	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
	

	private class ListNode {
		private E data;
		private ListNode next;
		
		private ListNode(E data) {
			this(data, null);
		}
		private ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
	
	
}
