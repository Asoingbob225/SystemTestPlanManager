/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.io.TestPlanReader;
import edu.ncsu.csc216.stp.model.io.TestPlanWriter;
import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * 
 * This class has an ISortedList of testPlans along with a FailingListTest and
 * an AbstractTestPlan that is the current test plan. It also has an isChanged
 * boolean that tracks if the the TestPlanManager has been changed since it was
 * last saved.
 * 
 * @author stbeuav
 *
 */
public class TestPlanManager {

	/**
	 * This is the boolean to keep track if the manager has been changed since the
	 * last save.
	 */
	private boolean isChanged;

	/** This is the ISortedList of the TestPlans */
	private ISortedList<TestPlan> testPlans;

	/** This is the FailingTestList that contains the failing test */
	private FailingTestList failingTests;

	/** This is the AbstractTestList that is the current test plan */
	private AbstractTestPlan currentTestPlan;

	/**
	 * This is the constructor for the TestPlanManager. This constructs the
	 * testPlans field as a SortedList and a currentTestPlan as a failingTestList.
	 * It also initializes the isChanged bo0lean to false.
	 */
	public TestPlanManager() {
		testPlans = new SortedList<TestPlan>();
		failingTests = new FailingTestList();
		currentTestPlan = failingTests;
		isChanged = false;
	}

	/**
	 * This uses TestPlanReader to load a file and returns a list a potential test
	 * plans to add to the testPlans list. If there already is a test plan with the
	 * same name as one of the ones trying to be added, it will not get added. After
	 * this, the currentTestPlan is set to the "Failing Tests" list. IsChanged is
	 * changed to true after this.
	 * 
	 * @param testPlanFile the testPlanFile to read through
	 */
	public void loadTestPlans(File testPlanFile) {
		ISortedList<TestPlan> potentialTestPlans = new SortedList<TestPlan>();
		testPlans = TestPlanReader.readTestPlansFile(testPlanFile);
		for (int i = 0; i < potentialTestPlans.size(); i++) {
			testPlans.add(potentialTestPlans.get(i));
		}
		getFailingTests();
		currentTestPlan = failingTests;
		isChanged = true;

	}

	/**
	 * This saves the currentTestPlan to the given file and isChanged is changed to
	 * true
	 * 
	 * @param testPlanFile the file to save to
	 */
	public void saveTestPlans(File testPlanFile) {
		TestPlanWriter.writeTestPlanFile(testPlanFile, testPlans);
		isChanged = false;
	}

	/**
	 * Returns whether or not the test plans list was changed
	 * 
	 * @return whether or not the test plans list was changed
	 */
	public boolean isChanged() {
		return isChanged;
	}

	/**
	 * Returns the list of test plans
	 * 
	 * @return list of test plans
	 */
	public ISortedList<TestPlan> getTestPlans() {
		return testPlans;
	}
	

	/**
	 * This adds a new test plan named whatever testPlanName is given.
	 * 
	 * @param testPlanName the name to be given to the new test plan.
	 * @throws IllegalArgumentException if testPlan name is FAILING_TESTS_LIST_NAME
	 *                                  or is a name that is already in the list of
	 *                                  test plans.
	 */
	public void addTestPlan(String testPlanName) {
		if (testPlanName.toUpperCase().equals(FailingTestList.FAILING_TEST_LIST_NAME.toUpperCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().toUpperCase().equals(testPlanName.toUpperCase())) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		TestPlan newTestPlan = new TestPlan(testPlanName);
		testPlans.add(newTestPlan);
		setCurrentTestPlan(testPlanName);
		// currentTestPlan = newTestPlan;
		isChanged = true;

	}

	/**
	 * This gets a list of test plan names with "Failing Tests" listed first
	 * 
	 * @return testPlanNames the list of test plan names
	 */
	public String[] getTestPlanNames() {
		String[] testNames = new String[testPlans.size() + 1];
		testNames[0] = failingTests.getTestPlanName();
		for (int i = 0; i < testPlans.size(); i++) {
			testNames[i + 1] = testPlans.get(i).getTestPlanName();
		}
		return testNames;
	}

	/**
	 * This is a helper for the FailingTestList. It helps organize the failing
	 * tests.
	 */
	private void getFailingTests() {
		failingTests.clearTests();
		for (int i = 0; i < testPlans.size(); i++) {
			for (int j = 0; j < testPlans.get(i).getTestCases().size(); j++) {
				if (!(testPlans.get(i).getTestCase(j).isTestCasePassing())) {
					failingTests.addTestCase(testPlans.get(i).getTestCase(j));
				}
			}
		}
	}

	/**
	 * This sets the currentTestPlan to the AbstractTestPlan with the name that is
	 * given.If that testPlanName is not found then the currentTestPlan is set to a
	 * FailingTestList.
	 * 
	 * @param testPlanName the name of the test plan to set as current test plan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				currentTestPlan = testPlans.get(i);
				return;
			}
		}
		getFailingTests();
		currentTestPlan = failingTests;
	}

	/**
	 * This gets the current test plan
	 * 
	 * @return currentTestPlan the current test plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}

	/**
	 * This edits the current test plan to have the specified test plan name.
	 * isChanged updates to true.
	 * 
	 * @param testPlanName the name of the test plan
	 * @throws IllegalArgumentException if the currentTestPlan is a FailingTestList,
	 *                                  if the name matches "Failing Tests" or if
	 *                                  the testPlanName is already the name of
	 *                                  another TestPlan.
	 */
	public void editTestPlan(String testPlanName) {
		if (currentTestPlan == failingTests) {
			throw new IllegalArgumentException("The Failing Tests list may not be edited.");
		}
		if (testPlanName.toLowerCase().equals("Failing Tests".toLowerCase())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}

		int index = 0;
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).equals(currentTestPlan)) {
				index = i;
			}
		}

		TestPlan edited = testPlans.remove(index);
		edited.setTestPlanName(testPlanName);
		testPlans.add(edited);
		isChanged = true;

	}

	/**
	 * This removes the currentTestPlan. isChanged updates to true.
	 * 
	 * @throws IllegalArgumentException if the currentTestPlan is a FailingTestList.
	 */
	public void removeTestPlan() {
		if (currentTestPlan == failingTests) {
			throw new IllegalArgumentException("The Failing Tests list may not be deleted.");
		}

		int index = 0;
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).equals(currentTestPlan)) {
				index = i;
			}
		}

		testPlans.remove(index);
		setCurrentTestPlan(failingTests.getTestPlanName());
		isChanged = true;

	}

	/**
	 * This adds a given test case to the currentTestPlan. isChanged updates to
	 * true.
	 * 
	 * @param testCase test case to add to the test plan
	 */
	public void addTestCase(TestCase testCase) {
		if (currentTestPlan == failingTests) {
			isChanged = false; // do nothing
		} else {
			isChanged = true;
			currentTestPlan.addTestCase(testCase);
			if (!testCase.isTestCasePassing()) {
				getFailingTests();
			}
		}
		
	}

	/**
	 * This adds the test result to the test case at a given index.
	 * 
	 * @param index        the index
	 * @param passing      the boolean of if the test is passing or not
	 * @param actualResult the result of the test
	 */
	public void addTestResult(int index, boolean passing, String actualResult) {
		currentTestPlan.getTestCase(index).addTestResult(passing, actualResult);
		if (!passing) {
			getFailingTests();
		}

	}

	/**
	 * This sets testPlans to an empty SortedList, sets failingTestList to an empty
	 * FailingTestList(), and sets the currentTestPlan to a failingTestList.
	 * isChanged is set to false.
	 */
	public void clearTestPlans() {
		// add code
		testPlans = new SortedList<TestPlan>();
		failingTests = new FailingTestList();
		setCurrentTestPlan(failingTests.getTestPlanName());
		isChanged = false;
	}
}
