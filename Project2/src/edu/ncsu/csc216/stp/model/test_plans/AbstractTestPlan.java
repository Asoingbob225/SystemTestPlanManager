/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import java.util.Objects;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.util.SwapList;

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
		if (testPlanName == null || "".equals(testPlanName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		setTestPlanName(testPlanName);
		testCases = new SwapList<TestCase>();
	}
	
	/**
	 * This sets the name of the test plan
	 * @param testPlanName the testPlan name
	 * @throws IllegalArgumentException if testPlanName is null or an empty string
	 */
	public void setTestPlanName(String testPlanName) {
		if (testPlanName == null || "".equals(testPlanName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
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
		testCases.add(testCase);
	}
	
	/**
	 * Removes the test case at that index from the testCases list.
	 * (any exceptions from the list should be thrown out of the method)
	 * @param index the index
	 * @return removedTestCase the test case that was removed
	 */
	public TestCase removeTestCase(int index) {
		TestCase removedTestCase = testCases.remove(index);
		return removedTestCase;
	}
	
	/**
	 * Gets the test case at the given index
	 * @param index the index
	 * @return testCase the testCase at the given index
	 */
	public TestCase getTestCase(int index) {
		TestCase testCase = testCases.get(index);
		return testCase;
	}
	
	/**
	 * This gets the amount of failing test cases
	 * @return count the amount of failing test cases
	 */
	public int getNumberOfFailingTests() {
		int count = 0;
		for (int i = 0; i < testCases.size(); i++) {
			if (!testCases.get(i).isTestCasePassing()) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * This sends the TestResult parameters to the test result at the given index
	 * (any exceptions from the list should be thrown out of the method)
	 * @param index the index
	 * @param passing the boolean that says whether the test case is passing or not
	 * @param actualResults the results of the test 
	 */
	public void addTestResult(int index, boolean passing, String actualResults) {
		testCases.get(index).addTestResult(passing, actualResults);
	}
	
	
	/**
	 * This returns a 2D string array of test cases
	 * @return testCasesArray the test cases as an array
	 */
	public abstract String[][] getTestCasesAsArray();
	
	
	/**
	 * Retrieves an object's hash code.
	 * @return integer representing the object's hash code.  
	 */
	@Override
	public int hashCode() {
		return Objects.hash(testCases, testPlanName);
	}

	/**
	 * Compares two courses to determine if they are equivalent. 
	 * @param obj object which is being compared to the course.
	 * @return boolean declaring whether or not two objects are equal based on credits, instructor ID, section, and name.   
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
		return Objects.equals(testCases, other.testCases) && Objects.equals(testPlanName.toUpperCase(), other.testPlanName.toUpperCase());
	}
}
