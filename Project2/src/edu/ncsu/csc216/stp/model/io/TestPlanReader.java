package edu.ncsu.csc216.stp.model.io;

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
	public static ISortedList<TestPlan> readTestPlansFile(String filename) {
		ISortedList<TestPlan> testPlans = new SortedList<TestPlan>();
		Scanner fileReader;
		try {
			fileReader = new Scanner(new FileInputStream(filename)); // Create a file scanner to read the file

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");

		}

		String fileString = "";

		while (fileReader.hasNextLine()) {
			fileString += fileReader.nextLine() + "\n";

		}
		fileReader.close();
		
		if (fileString.charAt(0) != '!') {
			throw new IllegalArgumentException("Unable to load file");
		}
		
		Scanner n = new Scanner(fileString);
		n.useDelimiter("\\r?\\n?[!]");
		
		while (n.hasNext()) {
			try {
				testPlans.add(processTestPlan(n.next()));
			} catch (Exception e) {
				n.close();
				return testPlans;
			}
		}

		n.close();
		
		return testPlans;
	}
	
	/**
	 * This processes individual test plans and sorts them into different tests
	 * @param line the line that is being read
	 * @return testplan the test plan
	 */
	private static TestPlan processTestPlan(String line) {
		Scanner n = new Scanner(line);
		String testPlanName = n.nextLine().trim();
		System.out.println(testPlanName);
		TestPlan testPlan = new TestPlan(testPlanName);
		n.useDelimiter("\\r?\\n?[#]");
		
		while(n.hasNext()) {
			try {
				testPlan.addTestCase(processTest(testPlan, n.next()));
			} catch (Exception e) {
				n.close();
			}
		}
		n.close();
		
		return testPlan;
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
		String descriptionandexpected = "";
		String description = "";
		String expected = "";
		String actual = "";
		
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
		
		n.useDelimiter("\\r?\\n?[-]");

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				descriptionandexpected = n.next().trim();
			}
			if (i == 1) {
				actual = n.next().trim();
			}
		}
		
		descriptionandexpected = descriptionandexpected.substring(2);
		String [] d = descriptionandexpected.split("\\r?\\n?[*]");
		description = d[0].trim();
		expected = d[1].trim();
		
		
		
		

		System.out.println(id);
		System.out.println(type);
		System.out.println(description);
		System.out.println(expected);
		System.out.println(actual);
		
		
		return null;
	}

}
