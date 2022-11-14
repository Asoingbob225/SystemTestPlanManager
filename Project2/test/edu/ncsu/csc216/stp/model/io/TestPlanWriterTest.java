/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * @author stbeuav
 *
 */
class TestPlanWriterTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.io.TestPlanWriter#writeTestPlanFile(java.lang.String, edu.ncsu.csc216.stp.model.util.ISortedList)}.
	 */
	@Test
	void testWriteTestPlanFile() {
		//fail("Not yet implemented");
		TestPlan plan1 = new TestPlan("TestPlan1");
		TestPlan plan2 = new TestPlan("TestPlan2");
		
		TestCase t0 = new TestCase("ID 0", "type 0", "description 0", "expected results 0");
		TestCase t1 = new TestCase("ID 1", "type 1", "description 1", "expected results 1");
		TestCase t2 = new TestCase("ID 2", "type 2", "description 2", "expected results 2");
		t0.addTestResult(false, "actual results 0-1");
		t1.addTestResult(true, "actual results 1-1");
		t1.addTestResult(false, "actual results 1-2");
		t2.addTestResult(true, "actual results 2-1");
		t2.addTestResult(true, "actual results 2-2");
		
		plan1.addTestCase(t0);
		plan1.addTestCase(t1);
		plan1.addTestCase(t2);
		
		ISortedList<TestPlan> tp = new SortedList<TestPlan>();
		tp.add(plan1);
		tp.add(plan2);
		
		TestPlanWriter.writeTestPlanFile("test-files/actual_out.txt", tp);
		checkFiles("test-files/expected_out.txt", "test-files/actual_out.txt");
		
		assertThrows(IllegalArgumentException.class, () -> TestPlanWriter.writeTestPlanFile("", tp));
		
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
