/**
 * 
 */
package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.util.SwapList;

/**
 * @author yujim
 *
 */
class SwapListTest {

	/**
	 * Test method for {@link util.SwapList#SwapList()}.
	 */
	@Test
	void testSwapList() {
		SwapList<Integer> a = new SwapList<Integer>();
		assertEquals(0, a.size());
		
	}

	/**
	 * Test method for {@link util.SwapList#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		SwapList<Integer> a = new SwapList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		assertEquals(3, a.size());
		assertEquals(10, a.get(0));
		assertEquals(20, a.get(1));
		assertEquals(30, a.get(2));
		assertThrows(NullPointerException.class, () -> a.add(null));
	}

	/**
	 * Test method for {@link util.SwapList#remove(int)}.
	 */
	@Test
	void testRemove() {
		SwapList<Integer> a = new SwapList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		assertEquals(3, a.size());
		assertEquals(10, a.remove(0));
		assertEquals(20, a.get(0));
		assertEquals(30, a.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> a.remove(-1));

	}

	/**
	 * Test method for {@link util.SwapList#moveUp(int)}.
	 */
	@Test
	void testMoveUp() {
		SwapList<Integer> a = new SwapList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.moveUp(2);
		assertEquals(30, a.get(1));
		assertEquals(20, a.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> a.moveUp(-1));
	}

	/**
	 * Test method for {@link util.SwapList#moveDown(int)}.
	 */
	@Test
	void testMoveDown() {
		SwapList<Integer> a = new SwapList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.moveDown(0);
		assertEquals(10, a.get(1));
		assertEquals(20, a.get(0));
		assertThrows(IndexOutOfBoundsException.class, () -> a.moveDown(-1));

	}

	/**
	 * Test method for {@link util.SwapList#moveToFront(int)}.
	 */
	@Test
	void testMoveToFront() {
		SwapList<Integer> a = new SwapList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.moveToFront(2);
		assertEquals(30, a.get(0));
		assertEquals(10, a.get(1));
		assertEquals(20, a.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> a.moveToFront(-1));

	}

	/**
	 * Test method for {@link util.SwapList#moveToBack(int)}.
	 */
	@Test
	void testMoveToBack() {
		SwapList<Integer> a = new SwapList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.moveToBack(0);
		assertEquals(20, a.get(0));
		assertEquals(30, a.get(1));
		assertEquals(10, a.get(2));
		assertThrows(IndexOutOfBoundsException.class, () -> a.moveToBack(-1));

	}


}
