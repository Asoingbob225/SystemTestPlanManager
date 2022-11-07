/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * 
 * This class has a method that receives a file and writes 
 * to it from a given ISortedList of TestPlans.
 * @author stbeuav
 *
 */
public class TestPlanWriter {
	
	/**
	 * This gets a file to write to and writes to it based off of a
	 * given ISortedList of Test Plans. This uses TestCase's toString() method.
	 * @param filename the file name to write to
	 * @param testPlans the ISortedList of TestPlans
	 */
	public static void writeTestPlanFile(File filename, ISortedList<TestPlan> testPlans) {
		//add code
	}

}
