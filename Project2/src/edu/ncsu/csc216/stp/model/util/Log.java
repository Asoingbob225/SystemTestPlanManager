/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
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
	
	public Log() {
		size = 0;
		log = (E[]) new Object[INIT_SIZE];
	}
	
	@Override
	public void add(E element) {
		//add code
	}
	
	@Override
	public E get(int index) {
		return null;
	}
	
	@Override
	public int size() {
		return this.size;
	}
}
