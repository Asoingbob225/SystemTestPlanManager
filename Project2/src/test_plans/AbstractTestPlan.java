/**
 * 
 */
package test_plans;

import java.util.Objects;

import tests.TestCase;
import util.ISwapList;

/**
 * @author yujim
 *
 */
public abstract class AbstractTestPlan {
	
	private String testPlanName;
	
	private ISwapList<TestCase> testCases;
	
	public AbstractTestPlan(String testPlanName) {
		setTestPlanName(testPlanName);
	}
	
	public void setTestPlanName(String testPlanName) {
		this.testPlanName = testPlanName;
	}
	
	public String getTestPlanName() {
		return testPlanName; 
	}
	
	public ISwapList<TestCase> getTestCases() {
		return testCases;
	}
	
	public void addTestCase(TestCase testCase) {
		//add code
	}
	
	public TestCase removeTestCase(int index) {
		return null;
	}
	

	public TestCase getTestCase(int index) {
		return null;
	}
	
	public int getNumberOfFailingTests() {
		return 0;
	}
	
	public void addTestResults(int index, boolean passing, String actualResults) {
		//add code
	}
	
	public abstract String[][] getTestCasesAsArray();
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(testCases, testPlanName);
	}

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
