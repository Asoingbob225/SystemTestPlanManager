package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogTest {

	/**
	 * Test method for {@link util.Log#Log()}.
	 */
	@Test
	void testLog() {
		Log<Integer> a = new Log<Integer>();
		assertEquals(0, a.size());
	}

	/**
	 * Test method for {@link util.Log#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		Log<Integer> a = new Log<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		assertEquals(3, a.size());
		assertEquals(10, a.get(0));
		assertEquals(20, a.get(1));
		assertEquals(30, a.get(2));
		assertThrows(NullPointerException.class, () -> a.add(null));
	}



}
