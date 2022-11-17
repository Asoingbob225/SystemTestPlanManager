/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Unit Tests for the FailingTestList class
 * 
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
		assertEquals("Failing Tests", list.getTestPlanName());
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
		list.setTestPlanName("FaIlInG tests");
		assertEquals("Failing Tests", list.getTestPlanName());
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
		TestCase testCase2 = new TestCase("test2", TYPE, DESCRIPTION, EXPECTED);
		TestCase testCase3 = new TestCase("test3", TYPE, DESCRIPTION, EXPECTED);
		TestCase testCase4 = new TestCase("test4", TYPE, DESCRIPTION, EXPECTED);
		list.addTestCase(testCase);
		list.addTestCase(testCase2);
		list.addTestCase(testCase3);
		list.addTestCase(testCase4);
		list.clearTests();
		assertEquals(0, list.getTestCasesAsArray().length);
	}

}
