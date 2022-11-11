package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestResultTest {
	
	/** The string for a passing test case */
	public static final String PASS = "Pass";
	
	/** The string for a failing test case */
	public static final String FAIL = "Fail";
	
	/** The string for a test's actual results for testing **/
	public static final String ACTUAL = "result";
	
	/**
	 * Test method for {@link tests.TestResult#TestResult(boolean, String)}.
	 */
	@Test
	void testTestResult() {
		TestResult t = new TestResult(true, ACTUAL);
		assertTrue(t.isPassing());
		assertEquals("result", t.getActualResults());
		
		assertThrows(IllegalArgumentException.class, () -> new TestResult(false, null));
	}
	


	/**
	 * Test method for {@link tests.TestResult#toString()}.
	 */
	@Test
	void testToString() {
		TestResult t = new TestResult(true, ACTUAL);
		assertEquals("Pass: result", t.toString());
	}

}
