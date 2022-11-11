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
class FailingTestListTest {
	/** String representing test case name for testing **/
	public static final String ID = "test1";
	
	/** String representing test case type for testing **/

	public static final String TYPE = "type";
	
	/** String representing test case description for testing **/
	public static final String DESCRIPTION = "description";
	
	/** String representing test case expected results for testing **/
	public static final String EXPECTED = "expected results";
	
	@Test
	void testFailingTestList() {
		FailingTestList list = new FailingTestList();
		assertEquals("Failing_Tests", list.getTestPlanName());
		assertEquals(0, list.getNumberOfFailingTests());
	}
	
	@Test
	void testAddTestCase() {
		FailingTestList list = new FailingTestList();
		TestCase testCase = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		list.addTestCase(testCase);
		assertEquals(1, list.getNumberOfFailingTests());
	}
	
	@Test
	void testSetTestPlanName() {
		FailingTestList list = new FailingTestList();
		list.setTestPlanName("FaIlInG_tests");
		assertEquals("Failing_Tests", list.getTestPlanName());
	}
	
	@Test
	void testGetTestCasesAsArray() {
		FailingTestList list = new FailingTestList();
		TestPlan testPlan = new TestPlan("Tests");
		TestCase testCase = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		testCase.setTestPlan(testPlan);
		list.addTestCase(testCase);
		assertEquals(1, list.getTestCasesAsArray().length);
	}
	
	@Test
	void testClearTests() {
		FailingTestList list = new FailingTestList();
		TestCase testCase = new TestCase(ID, TYPE, DESCRIPTION, EXPECTED);
		list.addTestCase(testCase);
		list.clearTests();
		assertEquals(0, list.getTestCasesAsArray().length);
	}

}
