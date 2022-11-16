/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.Log;

/**
 * This contains information on each test case. It has the testId, the testType,
 * the testDescription, and the expectedResults. It also belongs to a certain
 * TestPlan.
 * 
 * @author yujim
 *
 */
public class TestCase {

	/** The test case's ID */
	private String testCaseId;

	/** The test type */
	private String testType;

	/** The test description */
	private String testDescription;

	/** The expected results */
	private String expectedResults;

	/** The test plan that the test case belongs to */
	private TestPlan testPlan;

	/** The test results stored in a log */
	private Log<TestResult> testResults;

	/**
	 * This is the constructor for TestCases. Sets all of these parameters to what
	 * is given. The testPlan is set to null.
	 * 
	 * @param testCaseId      the ID for the test case
	 * @param testType        the type of test
	 * @param testDescription the description of the test
	 * @param expectedResults the expected results of the test
	 * @throws IllegalArgumentException if any of the parameters are null or an
	 *                                  empty string
	 */
	public TestCase(String testCaseId, String testType, String testDescription, String expectedResults) {
		setTestCaseId(testCaseId);
		setTestType(testType);
		setTestDescription(testDescription);
		setExpectedResults(expectedResults);
		this.testPlan = null;
		testResults = new Log<TestResult>();
	}

	/**
	 * This gets the ID for the test case
	 * 
	 * @return testCaseId the test case ID
	 */
	public String getTestCaseId() {
		return testCaseId;
	}

	/**
	 * This sets the ID for the test case to whatever is given.
	 * 
	 * @param testCaseId the ID to set
	 * @throws IllegalArgumentException if testCaseId is null or an empty string
	 */
	private void setTestCaseId(String testCaseId) {
		if (testCaseId == null || testCaseId.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testCaseId = testCaseId;
	}

	/**
	 * This returns the type of the test
	 * 
	 * @return testType the type of the test
	 */
	public String getTestType() {
		return testType;
	}

	/**
	 * This sets the test type to whatever is given
	 * 
	 * @param testType the test type to set
	 * @throws IllegalArgumentException if testType is null or an empty string
	 */
	private void setTestType(String testType) {
		if (testType == null || testType.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testType = testType;
	}

	/**
	 * This gets the test description
	 * 
	 * @return testDescription the description of the test
	 */
	public String getTestDescription() {
		return testDescription;
	}

	/**
	 * This sets the test description to whatever is given
	 * 
	 * @param testDescription the test description to set
	 * @throws IllegalArgumentException if testDescription is null or an empty
	 *                                  string
	 */
	private void setTestDescription(String testDescription) {
		if (testDescription == null || testDescription.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.testDescription = testDescription;
	}

	/**
	 * This gets the expected test results
	 * 
	 * @return expectedResults expected test results
	 */
	public String getExpectedResults() {
		return expectedResults;
	}

	/**
	 * This sets the expected test results to whatever is given
	 * 
	 * @param expectedResults the expected test results to set
	 * @throws IllegalArgumentException if expectedResults is null or an empty
	 *                                  string
	 */
	private void setExpectedResults(String expectedResults) {
		if (expectedResults == null || expectedResults.length() == 0) {
			throw new IllegalArgumentException("Invalid test information.");
		}
		this.expectedResults = expectedResults;
	}
	
	/**
	 * Sets the testPlan to the given testPlan
	 * 
	 * @param testPlan the testPlan to set
	 * @throws IllegalArgumentException if the parameter is null
	 */
	public void setTestPlan(TestPlan testPlan) {
		if (testPlan == null) {
			throw new IllegalArgumentException();
		}
		this.testPlan = testPlan;
	}

	/**
	 * This gets the test plan
	 * 
	 * @return testPlan the test plan
	 */
	public TestPlan getTestPlan() {
		return testPlan;
	}

	/**
	 * This makes a test result from what is given and adds it to the log
	 * 
	 * @param passing       the boolean saying whether or not the test is passing
	 * @param actualResults the description of the results
	 * @throws IllegalArgumentException if the test results can't be constructed
	 */
	public void addTestResult(boolean passing, String actualResults) {
		try {
			TestResult result = new TestResult(passing, actualResults);
			testResults.add(result);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid test results.");
		}

	}

	/**
	 * This returns whether or not the test case of the last testResult in the log
	 * is passing.
	 * 
	 * @return true if the last testResult in the log is passing and false
	 *         otherwise.
	 */
	public boolean isTestCasePassing() {
		if (testResults.size() != 0) {
			return testResults.get(testResults.size() - 1).isPassing();
		}
		return false;
	}

	/**
	 * This returns the status of the testCase
	 * 
	 * @return "PASS" if passing or "FAIL" if fail (using testResult constants)
	 */
	public String getStatus() {
		if (isTestCasePassing()) {
			return TestResult.PASS;
		}
		return TestResult.FAIL;
	}

	/**
	 * This returns a string of the testResults log
	 * 
	 * @return log the log in string form
	 */
	public String getActualResultsLog() {
		String log = "";

		for (int i = 0; i < testResults.size(); i++) {
			log += "- " + testResults.get(i).toString() + "\n";
		}
		return log;
	}

	/**
	 * This returns a string form of the test case
	 * 
	 * @return testCaseString the string form of the test case
	 */
	public String toString() {
		return "# " + testCaseId + "," + testType + "\n" + "* " + testDescription + "\n" + "* " + expectedResults + "\n"
				+ getActualResultsLog();
	}

}
