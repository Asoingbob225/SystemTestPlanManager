/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * @author levic
 *
 */
class TestPlanTest {
	
	/** String representing test case name for testing **/
	public static final String ID = "test1";
	
	/** String representing test case type for testing **/

	public static final String TYPE = "type";
	
	/** String representing test case description for testing **/
	public static final String DESCRIPTION = "description";
	
	/** String representing test case expected results for testing **/
	public static final String EXPECTED = "expected results";
	
	
	@Test
	void testTestPlan() {
		TestPlan testPlan = new TestPlan("Test");
		assertEquals("Test", testPlan.getTestPlanName());
	}
	
	@Test
	void testGetTestCasesAsArray() {
		TestPlan testPlan = new TestPlan("Test");
		TestCase testCase = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		testPlan.addTestCase(testCase);
		assertEquals(1, testPlan.getTestCasesAsArray().length);
	}
	
	@Test
	void testCompareTo() {
		TestPlan testPlan = new TestPlan("Test");
		TestPlan testPlan2 = new TestPlan("Test2");
		TestPlan testPlan3 = new TestPlan("test");
		TestPlan testPlan4 = new TestPlan("TENT");
		assertEquals(0, testPlan.compareTo(testPlan3));
		assertEquals(-1, testPlan.compareTo(testPlan2));
		assertEquals(1, testPlan.compareTo(testPlan4));
	}
	
	@Test
	void testgetTestCase() {
		TestPlan testPlan = new TestPlan("Test");
		TestCase testCase = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		testPlan.addTestCase(testCase);
		assertEquals(testCase, testPlan.getTestCase(0));
	}
	
	@Test
	void testEquals() {
		TestPlan testPlan1 = new TestPlan("Test1");
		TestCase testCase1 = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		testPlan1.addTestCase(testCase1);
	
		TestPlan testPlan2 = new TestPlan("Test2");
		TestCase testCase2 = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		testPlan2.addTestCase(testCase2);
		assertFalse(testPlan1.equals(testPlan2));
	}
	
	@Test
	void testAddResult() {
		TestPlan testPlan = new TestPlan("Test");
		TestCase testCase = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		
		testPlan.addTestCase(testCase);
		testPlan.addTestResult(0, true, "results");
		assertEquals("Pass", testPlan.getTestCase(0).getStatus());
	}

}
