/**
 * 
 */
package test_plans;

import tests.TestCase;

/**
 * @author stbeuav
 *
 */
public class FailingTestList extends AbstractTestPlan {

	public static final String FAILING_TEST_LIST_NAME = "Failing_Tests";
	
	public FailingTestList(String testPlanName) {
		super(testPlanName);
	}
	
	@Override
	public void addTestCase(TestCase testCase) {
		//add code
	}
	
	@Override
	public void setTestPlanName(String testPlanName) {
		//add code
	}

	@Override
	public String[][] getTestCasesAsArray() {
		return null;
	}
	
	public void clearTests() {
		//add code
	}
}
