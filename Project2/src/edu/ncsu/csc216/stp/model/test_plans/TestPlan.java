/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * This extends AbstractTestPlan and implements the comparable interface. It has
 * test cases and they can be returned as an array. You can also add test cases
 * the test plan.
 * 
 * @author yujim
 *
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {

	/**
	 * This is the TestPlan constructor. It makes a test plan with the given name
	 * 
	 * @param testPlanName name of the test plan being constructed
	 * @throws IllegalArgumentException if testPlanName is the same as
	 *                                  FailingListTest.FAILING_TEST_LIST_NAME
	 */
	public TestPlan(String testPlanName) {
		super(testPlanName);
		if (testPlanName.toLowerCase().equals(FailingTestList.FAILING_TEST_LIST_NAME.toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
	}

	/**
	 * This returns a 2D string array where the first column is the test case id,
	 * the second column is the test type, and the third column is the status
	 * 
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
	 * This adds the test case via the super and it sets the testCase's TestPlan to
	 * the current TestPlan
	 * 
	 * @param testCase the case to add
	 */
	@Override
	public void addTestCase(TestCase testCase) {
		super.addTestCase(testCase);
		testCase.setTestPlan(this);
	}

	/**
	 * This method does an alphabetical comparison (case insensitive) of the
	 * testPlanName string values for ordering purposes.
	 * 
	 * @param testPlan the test plan to compare to
	 * @return 0, -1, or 1 if this test plan's name is alphabetically equal, ahead,
	 *         or behind the given TestPlan parameter, respectively. If the given
	 *         test plan name is longer than this test plan but equal up until the
	 *         length difference, than the method returns -1.
	 */
	public int compareTo(TestPlan testPlan) {

		String plan1 = this.getTestPlanName().toUpperCase();
		String plan2 = testPlan.getTestPlanName().toUpperCase();

		// If the entire strings are equal to each other
		if (plan1.equals(plan2)) {
			return 0;
		}

		// Checks for the first character of each test plan name string
		else if (plan1.charAt(0) < plan2.charAt(0)) {
			return -1;
		} else if (plan1.charAt(0) > plan2.charAt(0)) {
			return 1;
		}

		// If there is more than one similar character to start the test plans' names,
		// this part catches it. A for loop compares all characters up to whichever name
		// has the shorter length so there are no out of bounds errors.
		int y;
		if (plan1.length() > plan2.length()) {
			y = plan2.length();
		} else {
			y = plan1.length();
		}
		for (int x = 1; x < y; x++) {
			if (plan1.charAt(x) < plan2.charAt(x)) {
				return -1;
			}
			if (plan1.charAt(x) > plan2.charAt(x)) {
				return 1;
			}
		}
		return -1;

	}
	
	

}
