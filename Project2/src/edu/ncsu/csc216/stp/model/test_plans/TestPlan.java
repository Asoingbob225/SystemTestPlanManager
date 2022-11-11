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
		if (testPlanName.equals(FailingTestList.FAILING_TEST_LIST_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		}
	}
	
	/**
	 * This returns a 2D string array where the first column is the test case id, 
	 * the second column is the test type, and the third column is the status
	 * @return array the 2D array
	 */
	public String[][] getTestCasesAsArray() {
		String[][] array = new String[getTestCases().size()][3];
		for (int i = 0; i < getTestCases().size(); i++) {
			array[i][0] = getTestCases().get(i).getTestCaseId();
			array[i][1] = getTestCases().get(i).getTestType();
			array[i][2] = getTestCases().get(i).getStatus();
		}
		return array;
		
	}
	
	/**
	 * This adds the test case via the super and it sets the testCase's TestPlan to the current TestPlan
	 * @param testCase the case to add
	 */
	@Override
	public void addTestCase(TestCase testCase) {
		super.addTestCase(testCase);
	}
	
	/**
	 * Compares the names of the test plans (case insensitive)
	 */
	public int compareTo(TestPlan testPlan) {
		if (testPlan.getTestPlanName().toUpperCase().equals(this.getTestPlanName().toUpperCase())) {
			return 1;
		}
		return 0;
	}
	
}
