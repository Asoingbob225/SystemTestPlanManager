/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

/**
 * @author yujim
 *
 */
public class TestResult {

	public static final String PASS = "Pass";
	
	public static final String FAIL = "Fail";
	
	private boolean passing;
	
	private String actualResults;
	
	public TestResult(boolean passing, String actualResults) {
		//code here
	}
	
	public String getActualResults() {
		return actualResults;
	}
	
	private void setActualResults(String actualResults) {
		this.actualResults = actualResults;
	}
	
	public boolean isPassing() {
		return passing;
	}
	
	private void setPassing(boolean passing) {
		this.passing = passing;
	}
	
	public String toString() {
		return null;
	}
}
