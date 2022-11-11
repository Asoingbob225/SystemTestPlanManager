/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * This extends AbstractTestPlan and implements the comparable interface. It has test cases and 
 * they can be returned as an array. You can also add test cases the test plan.
 * @author yujim
 *
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan>{

	/**
	 * This is the TestPlan constructor. It makes a test plan with the given name
	 * @param testPlanName
	 * @throws IllegalArgumentException if testPlanName is the same as FailingListTest.FAILING_TEST_LIST_NAME
	 */
	public TestPlan(String testPlanName) {
		super(testPlanName);
		// add code
	}
	
	/**
	 * This returns a 2D string array where the first column is the test case id, 
	 * the second column is the test type, and the third column is the status
	 * @return array the 2D array
	 */
	public String[][] getTestCasesAsArray() {
		return null;
	}
	
	/**
	 * This adds the test case via the super and it sets the testCase's TestPlan to the current TestPlan
	 */
	@Override
	public void addTestCase(TestCase testCase) {
		//add code
	}
	
	/**
	 * Compares the names of the test plans (case insensitive)
	 */
	public int compareTo(TestPlan testPlan) {
		
		return 0;
	}
	
}
