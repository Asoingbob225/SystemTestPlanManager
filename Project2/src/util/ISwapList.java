/**
 * 
 */
package util;

/**
 * @author yujim
 *
 */
public interface ISwapList<E> {

	void add(E element);
	
	E remove(int index);
	
	void moveUp(int index);
	
	void moveDown(int index);
	
	void moveToFront(int index);
	
	void moveToBack(int index);
	
	E get(int index);
	
	int size();
}
