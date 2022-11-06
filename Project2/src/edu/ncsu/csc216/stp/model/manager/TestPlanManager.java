/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * @author stbeuav
 *
 */
public class TestPlanManager {
	
	private boolean isChanged;
	
	private ISortedList<TestPlan> testPlans;
	
	private FailingTestList failingTests;
	
	private AbstractTestPlan currentTestPlan;
	
	public TestPlanManager() {
		//code here
	}
	
	public void loadTestPlans(File testPlanFile) {
		//code here
	}
	
	public void saveTestPlans(File testPlanFile) {
		//code here
	}
	
	public boolean isChanged() {
		return false;
	}
	
	public void addTestPlan(String testPlanName) {
		//add code
	}
	
	public String[] getTestPlanNames() {
		return null;
	}
	
	private void getFailingTests() {
		//add code
	}
	
	public void setCurrentTestPlan(String testPlanName) {
		//add code
	}
	
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}
	
	public void editTestPlan(String testPlanName) {
		//add code
	}
	
	public void removeTestPlan() {
		//add code
	}
	
	public void addTestCase(TestCase testCase) {
		//add code
	}
	
	public void addTestResult(int index, boolean passing, String actualResult) {
		//add code
	}
	
	public void clearTestPlans() {
		//add code
	}
}
