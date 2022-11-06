/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
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

	@SuppressWarnings("unchecked")
	public SwapList() {
		size = 0;
		list = (E[]) new Object[INIT_SIZE];
	}
	
	public void add(E element) {
		//add code
	}
	
	private void checkCapacity(int size) {
		//add code
	}
	
	public E remove(int index) {
		return null;
	}
	
	private void checkIndex(int index) {
		//add code
	}
	
	public void moveUp(int index) {
		//add code
	}
	
	public void moveDown(int index) {
		//add code
	}
	
	public void moveToFront(int index) {
		//add code
	}
	
	public void moveToBack(int index) {
		//add code
	}
	
	public E get(int index) {
		return null;
	}

	public int size() {
		return this.size;
	}
	
	
}
