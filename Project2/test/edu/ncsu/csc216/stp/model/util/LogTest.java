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
		a.add(40);
		a.add(50);
		a.add(60);
		a.add(70);
		a.add(80);
		a.add(90);
		a.add(100);
		a.add(110);
		assertEquals(11, a.size());
		assertEquals(10, a.get(0));
		assertEquals(20, a.get(1));
		assertEquals(30, a.get(2));
		assertThrows(NullPointerException.class, () -> a.add(null));
	}



}
