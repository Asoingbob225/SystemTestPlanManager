package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

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
		ISortedList<TestPlan> testPlans = new SortedList<TestPlan>();
		Scanner fileReader;
		try {
			fileReader = new Scanner(new FileInputStream(filename)); 
			
			String fileString = "";

			while (fileReader.hasNextLine()) {
				fileString += fileReader.nextLine() + "\n";

			}
			fileReader.close();
			
			if (fileString.charAt(0) != '!') {
				throw new IllegalArgumentException("Unable to load file.");
			}
			
			Scanner n = new Scanner(fileString);
			n.useDelimiter("\\r?\\n?[!]");
			
			while (n.hasNext()) {
				
				try {
					testPlans.add(processTestPlan(n.next()));
				} catch (Exception e) {
//					n.close();
//					throw new IllegalArgumentException();
				}
			}

			n.close();

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");

		}
		



		return testPlans;
	}
	
	/**
	 * This processes individual test plans and sorts them into different tests
	 * @param line the line that is being read
	 * @return testPlan the test plan
	 */
	private static TestPlan processTestPlan(String line) {
		try {
			Scanner n = new Scanner(line);
			String testPlanName = n.nextLine().trim();
			TestPlan testPlan = new TestPlan(testPlanName);
			n.useDelimiter("\\r?\\n?[#]");
			
			while(n.hasNext()) {
				try {
					testPlan.addTestCase(processTest(testPlan, n.next()));
				} catch (Exception e) {
					
				}
			}
			n.close();
			
			return testPlan;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * This processes individual tests and sorts them before returning them
	 * back into a test case that will go inside of a test plan
	 * @param testPlan the test plan
	 * @param line the line that is being read
	 * @return test the test case
	 */
	private static TestCase processTest(AbstractTestPlan testPlan, String line) {
		
		String id = "";
		String type = "";
		String description = "";
		String expected = "";
		String results = "";
		
		Scanner n = new Scanner(line);
		
		Scanner m = new Scanner(n.nextLine());
		m.useDelimiter(",");
		id = m.next().trim();
		type = m.next().trim();
		if (m.hasNext()) {
			m.close();
			n.close();
			throw new IllegalArgumentException();
		}
		m.close();
		
		n.useDelimiter("\\r?\\n?[*]");
		
		
		description = n.next().trim().replaceAll("[\\t\\n\\r]", " ");
		
		results = n.next().trim();
		
		n.close();
		
		String [] r = results.split("\\r?\\n?[-]");
		
		expected = r[0].replaceAll("[\\t\\n\\r]", " ");
		
		TestCase testCase = new TestCase(id, type, description, expected);

		for (int i = 1; i < r.length; i++) {
			boolean testStatus = false;
			//System.out.println(r[i]);
			if ("FAIL".equals(r[i].trim().substring(0, 4))) {
				testStatus = false;
			}
			else if ("PASS".equals(r[i].trim().substring(0, 4))) {
				testStatus = true;
			}
			else {
				return null;
			}
			
			testCase.addTestResult(testStatus, r[i].substring(6).trim().replaceAll("[\\t\\n\\r]", " "));
		}
		
		
		return testCase;


	}
		

}
