/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import java.util.Objects;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;

/**
 * 
 * This is an abstract class and has a hierarchy of test
 * plans. It has a test plan name and an ISwapList that contains
 * the test cases.
 * @author yujim
 *
 */
public abstract class AbstractTestPlan {
	
	/** The name of the test plan */
	private String testPlanName;
	
	/** The swap list of the test cases */
	private ISwapList<TestCase> testCases;
	
	/**
	 * This is the constructor of the AbstractTestPlan. It 
	 * sets the fields and makes a swap list of test cases.
	 * @param testPlanName the test plan name
	 * @throws IllegalArgumentException if testPlanName is null or an empty string
	 */
	public AbstractTestPlan(String testPlanName) {
		setTestPlanName(testPlanName);
	}
	
	/**
	 * This sets the name of the test plan
	 * @param testPlanName the testPlan name
	 * @throws IllegalArgumentException if testPlanName is null or an empty string
	 */
	public void setTestPlanName(String testPlanName) {
		this.testPlanName = testPlanName;
	}
	
	/**
	 * Gets the name of the test plan
	 * @return testPlanName the name of the test plann
	 */
	public String getTestPlanName() {
		return testPlanName; 
	}
	
	/**
	 * This gets the test cases
	 * @return testCases the test cases
	 */
	public ISwapList<TestCase> getTestCases() {
		return testCases;
	}
	
	/**
	 * This adds a test cases to the end of the testCases list
	 * (any exceptions from the list should be thrown out of the method)
	 * @param testCase the test case
	 */
	public void addTestCase(TestCase testCase) {
		//add code
	}
	
	/**
	 * Removes the test case at that index from the testCases list.
	 * (any exceptions from the list should be thrown out of the method)
	 * @param index the index
	 * @return removedTestCase the test case that was removed
	 */
	public TestCase removeTestCase(int index) {
		return null;
	}
	
	/**
	 * Gets the test case at the given index
	 * @param index the index
	 * @return testCase the testCase at the given index
	 */
	public TestCase getTestCase(int index) {
		return null;
	}
	
	/**
	 * This gets the amount of failing test cases
	 * @return count the amount of failing test cases
	 */
	public int getNumberOfFailingTests() {
		return 0;
	}
	
	/**
	 * This sends the TestResult parameters to the test result at the given index
	 * (any exceptions from the list should be thrown out of the method)
	 * @param index the index
	 * @param passing the boolean that says whether the test case is passing or not
	 * @param actualResults the results of the test 
	 */
	public void addTestResult(int index, boolean passing, String actualResults) {
		//add code
	}
	
	
	/**
	 * This returns a 2D string array of test cases
	 * @return testCasesArray the test cases as an array
	 */
	public abstract String[][] getTestCasesAsArray();
	
	
	/**
	 * This is the hashcode for the AbstractTestPlan
	 */
	@Override
	public int hashCode() {
		return Objects.hash(testCases, testPlanName);
	}

	/**
	 * This is the equals method for equals in the AbstractTestPlan
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTestPlan other = (AbstractTestPlan) obj;
		return Objects.equals(testCases, other.testCases) && Objects.equals(testPlanName, other.testPlanName);
	}
}
