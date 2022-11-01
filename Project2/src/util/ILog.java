/**
 * 
 */
package util;

/**
 * @author yujim
 *
 */
public interface ILog<E> {

	void add(E element);
	
	E get(int index); 
	
	int size();
}
