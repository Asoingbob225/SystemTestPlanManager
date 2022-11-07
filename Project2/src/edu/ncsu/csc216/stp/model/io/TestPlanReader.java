package edu.ncsu.csc216.stp.model.io;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * This class receives a file for a TestPlan and reads it. It makes 
 * a sorted list of test plans based off of what is read in the file.
 * @author levic
 *
 */
public class TestPlanReader {
	
	/**
	 * This reads a file that contains test plans. This file is then made
	 * into a sorted list of test plans.
	 * @param filename the name of the file that will be read
	 * @return testplans the list of test plans
	 * @throws IllegalArgumentException if the file does not exist or if the first 
	 * character of the file is not a "!"
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File filename) {
		return null;
	}
	
	/**
	 * This processes individual test plans and sorts them into different tests
	 * @param line the line that is being read
	 * @return testplan the test plan
	 */
	private static TestPlan processTestPlan(String line) {
		return null;
	}
	
	/**
	 * This processes individual tests and sorts them before returning them
	 * back into a test case that will go inside of a test plan
	 * @param testPlan the test plan
	 * @param line the line that is being read
	 * @return test the test case
	 */
	private static TestCase processTest(AbstractTestPlan testPlan, String line) {
		return null;
	}

}
