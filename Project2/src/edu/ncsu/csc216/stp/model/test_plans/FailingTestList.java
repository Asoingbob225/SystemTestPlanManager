/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * @author stbeuav
 *
 */
public class FailingTestList extends AbstractTestPlan {

	/** Constant for the name of the failing test list */
	public static final String FAILING_TEST_LIST_NAME = "Failing_Tests";
	
	/**
	 * This is the constructor for FailingTestList. It creates
	 * it with the name of the constant FAILING_TEST_LIST_NAME.
	 */
	public FailingTestList() {
		super(FAILING_TEST_LIST_NAME);
	}
	
	/**
	 * Adds the given test case to the end of the ISwapList.
	 * @throws IllegalArgumentException if the testCase is not a failing test
	 */
	@Override
	public void addTestCase(TestCase testCase) {
		//add code
	}
	
	/**
	 * Makes sure the test plan name matches the failing test plan name constant.
	 * @throws IllegalArgumentException if testPlanName does not match FAILING_TEST_LIST_NAME (case insensitive)
	 */
	@Override
	public void setTestPlanName(String testPlanName) {
		//add code
	}

	/**
	 * This returns a 2D string array where the first column is the test case id, 
	 * the second column is the test type, and the third column is the test plan name associated with the test case
	 * @return array the 2D array
	 */
	@Override
	public String[][] getTestCasesAsArray() {
		return null;
	}
	
	/**
	 * This clears the FailingTestList of all of the test cases
	 */
	public void clearTests() {
		//add code
	}
}
