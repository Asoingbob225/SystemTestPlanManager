/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

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
		PrintStream fileWriter;
		try {
			fileWriter = new PrintStream(filename);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file");
		} 
		
		for (int i = 0; i < testPlans.size(); i++) {
			fileWriter.print("! " + testPlans.get(i).getTestPlanName());
			if (testPlans.get(i).getTestCases().size() > 0) {
				fileWriter.println();
				for (int j = 0; j < testPlans.get(i).getTestCases().size(); j++){
					fileWriter.print(testPlans.get(i).getTestCases().get(j).toString());
				}
			}

		}
		
		fileWriter.println();
		
		fileWriter.close();
		
	}

}
