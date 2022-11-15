package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * Unit tests for TestCase class
 * @author yujim
 *
 */
class TestCaseTest {
	
	/** String representing test case name for testing **/
	public static final String ID = "test1";
	
	/** String representing test case type for testing **/

	public static final String TYPE = "type";
	
	/** String representing test case description for testing **/
	public static final String DESCRIPTION = "description";
	
	/** String representing test case expected results for testing **/
	public static final String EXPECTED = "expected results";
	

	/**
	 * Test method for {@link tests.TestCase#TestCase(String, String, String, String)}.
	 */
	@Test
	void testTestCase() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		assertEquals("test1", t.getTestCaseId());
		assertEquals("type", t.getTestType());
		assertEquals("description", t.getTestDescription());
		assertEquals("expected results", t.getExpectedResults());
		assertEquals(null, t.getTestPlan());
		
		assertThrows(IllegalArgumentException.class, () -> new TestCase(null, TYPE, DESCRIPTION, EXPECTED));
		assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, null, DESCRIPTION, EXPECTED));
		assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, null, EXPECTED));
		assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, DESCRIPTION, null));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("", TYPE, DESCRIPTION, EXPECTED));
		assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, "", DESCRIPTION, EXPECTED));
		assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, "", EXPECTED));
		assertThrows(IllegalArgumentException.class, () -> new TestCase(ID, TYPE, DESCRIPTION, ""));
	}
	
	/**
	 * Test method for {@link tests.TestCase#setTestPlan(TestPlan)}.
	 */
	@Test
	void testSetTestPlan() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		TestPlan tp = new TestPlan("test plan name");
		assertThrows(IllegalArgumentException.class, () -> t.setTestPlan(null));
		t.setTestPlan(tp);
		assertEquals("test plan name", tp.getTestPlanName());
		
	}

	/**
	 * Test method for {@link tests.TestCase#getStatus()}.
	 */
	@Test
	void testGetStatus() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		assertEquals("Fail", t.getStatus());
	}

	/**
	 * Test method for {@link tests.TestCase#toString()}.
	 */
	@Test
	void testToString() {
		TestCase t = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		assertEquals("# test1,type\n* description\n* expected results\n", t.toString());
	}

}
