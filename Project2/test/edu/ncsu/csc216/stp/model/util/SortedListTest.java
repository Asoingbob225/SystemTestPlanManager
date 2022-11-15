/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for SortedList custom list
 * 
 * @author levic
 *
 */
class SortedListTest {

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.stp.model.util.SortedList#SortedList()}.
	 */
	@Test
	void testSortedList() {
		SortedList<Integer> sortedList = new SortedList<Integer>();
		assertEquals(0, sortedList.size());

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.stp.model.util.SortedList#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		SortedList<Integer> sortedList = new SortedList<Integer>();
		sortedList.add(0);
		assertEquals(1, sortedList.size());
		sortedList.add(7);
		sortedList.add(4);
		sortedList.add(5);
		sortedList.add(-5);
		assertEquals(-5, sortedList.get(0));
		assertEquals(0, sortedList.get(1));
		assertEquals(4, sortedList.get(2));
		assertEquals(5, sortedList.get(3));
		assertEquals(7, sortedList.get(4));

		assertThrows(NullPointerException.class, () -> sortedList.add(null));
	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.stp.model.util.SortedList#remove(int)}.
	 */
	@Test
	void testRemove() {
		SortedList<Integer> sortedList = new SortedList<Integer>();
		sortedList.add(0);
		sortedList.add(1);
		sortedList.add(2);
		sortedList.add(3);
		sortedList.remove(0);
		assertEquals(3, sortedList.size());
		sortedList.remove(2);
		assertEquals(2, sortedList.size());

		assertThrows(IndexOutOfBoundsException.class, () -> sortedList.remove(-1));

	}

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.stp.model.util.SortedList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		SortedList<Integer> sortedList = new SortedList<Integer>();
		sortedList.add(0);
		assertTrue(sortedList.contains(0));
		assertFalse(sortedList.contains(3));
		sortedList.add(3);
		assertTrue(sortedList.contains(3));
	}

}
