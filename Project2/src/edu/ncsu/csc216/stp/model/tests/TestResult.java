/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

/**
 * 
 * This class contains the result of a single test case.
 * This contains if the test passed or failed, and
 * also has details about the results of the execution of the test case.
 * @author yujim
 *
 */
public class TestResult {

	/** The string for a passing test case */
	public static final String PASS = "Pass";
	
	/** The string for a failing test case */
	public static final String FAIL = "Fail";
	
	/** A boolean for if it is passing or not */
	private boolean passing;
	
	/** A string for the results */
	private String actualResults;
	
	/**
	 * This is the TestResult constructor. It sets the passing boolean
	 * to true or false based on what is given, and also contains a string that
	 * has the results of the test.
	 * @param passing
	 * @param actualResults
	 * @throws IllegalArgumentException if actualResults is null or an empty string
	 */
	public TestResult(boolean passing, String actualResults) {
		//code here
		setActualResults(actualResults);
		setPassing(passing);
	}
	
	/**
	 * Returns the results of the test
	 * @return actualResutls the results of the test
	 */
	public String getActualResults() {
		return actualResults;
	}
	
	/**
	 * This sets the results to whatever is input
	 * @param actualResults the actual results to set
	 * @throws IllegalArgumentException if actualResults is null or an empty string
	 */
	private void setActualResults(String actualResults) {
		if (actualResults == null || actualResults.length() == 0) {
			throw new IllegalArgumentException("Invalid test results.");
		}
		this.actualResults = actualResults;
	}
	
	/**
	 * Returns whether or not the test is passing
	 * @return passing the passing boolean
	 */
	public boolean isPassing() {
		return passing;
	}
	
	/**
	 * This sets the passing boolean to whatever is given
	 * @param passing the boolean that is input
	 */
	private void setPassing(boolean passing) {
		this.passing = passing;
	}
	
	/**
	 * This returns the string of the TestResult
	 * @return "PASS: " + actualResults if passing == true
	 * "FAIL: " + actualResults if passing == false
	 */
	public String toString() {
		String result = null;
		if (passing == true) {
			result = PASS;
		}
		else {
			result = FAIL;
		}
		return result.toUpperCase() + ": " + actualResults;
	}
}
