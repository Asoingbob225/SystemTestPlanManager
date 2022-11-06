/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.Log;

/**
 * @author yujim
 *
 */
public class TestCase {

	private String testCaseId;
	
	private String testType;
	
	private String testDescription;
	
	private String expectedResults;
	
	private TestPlan testPlan = null;
	
	private Log<TestResult> testResults;
	
	public TestCase(String testCaseId, String testType, String testDescription, String expectedResults) {
		setTestCaseId(testCaseId);
		setTestType(testType);
		setTestDescription(testDescription);
		setExpectedResults(expectedResults);
	}
	
	public String getTestCaseId() {
		return testCaseId;
	}
	
	private void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}
	
	public String getTestType() {
		return testType;
	}
	
	private void setTestType(String testType) {
		this.testType = testType;
	}
	
	public String getTestDescription() {
		return testDescription;
	}
	
	private void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	
	public String getExpectedResults() {
		return expectedResults;
	}
	
	private void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}
	
	public void addTestResult(boolean passing, String actualResults) {
		TestResult result = new TestResult(passing, actualResults);
		testResults.add(result);	
	}
	
	public boolean isTestCasePassing() {
		return false;
	}
	
	public String getStatus() {
		return null;
	}
	
	public String getActualResultsLog() {
		return null;
	}
	
	public void setTestPlan(TestPlan testPlan) {
		this.testPlan = testPlan;
	}
	
	public TestPlan getTestPlan() {
		return testPlan;
	}
	
	public String toString() {
		return null;
	}
	
}
