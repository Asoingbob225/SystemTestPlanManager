/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;


/**
 * Unit Tests for TestPlanManager class
 * @author levic
 *
 */
class TestPlanManagerTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#TestPlanManager()}.
	 */
	@Test
	void testTestPlanManager() {
		TestPlanManager manager = new TestPlanManager();
		assertEquals("Failing Tests", manager.getCurrentTestPlan().getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#loadTestPlans(java.io.File)}.
	 */
	@Test
	void testLoadTestPlans() {
		TestPlanManager manager = new TestPlanManager();
		manager.loadTestPlans(new File("test-files/test-plans0.txt"));
		assertEquals(3, manager.getTestPlanNames().length);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#saveTestPlans(java.io.File)}.
	 */
	@Test
	void testSaveTestPlans() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
		
		TestCase t0 = new TestCase("ID 0", "type 0", "description 0", "expected results 0");
		TestCase t1 = new TestCase("ID 1", "type 1", "description 1", "expected results 1");
		TestCase t2 = new TestCase("ID 2", "type 2", "description 2", "expected results 2");
	
		t0.addTestResult(false, "actual results 0-1");
		t1.addTestResult(true, "actual results 1-1");
		t1.addTestResult(false, "actual results 1-2");
		t2.addTestResult(true, "actual results 2-1");
		t2.addTestResult(true, "actual results 2-2");
		manager.addTestCase(t0);
		manager.addTestCase(t1);
		manager.addTestCase(t2);
		manager.addTestPlan("TestPlan2");
		
		manager.saveTestPlans(new File("test-files/urmom.txt"));
		checkFiles("test-files/expected_out.txt", "test-files/urmom.txt");
		
		assertThrows(IllegalArgumentException.class, () -> manager.saveTestPlans(new File("")));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestPlan(java.lang.String)}.
	 */
	@Test
	void testAddTestPlan() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
		assertEquals(2, manager.getTestPlanNames().length);
		assertEquals("TestPlan1", manager.getCurrentTestPlan().getTestPlanName());
		assertThrows(IllegalArgumentException.class, () -> manager.addTestPlan("Failing Tests"));
		assertThrows(IllegalArgumentException.class, () -> manager.addTestPlan("TestPlan1"));
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#setCurrentTestPlan(java.lang.String)}.
	 */
	@Test
	void testSetCurrentTestPlan() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
		manager.addTestPlan("TestPlan2");
		manager.addTestPlan("TestPlan3");
		manager.setCurrentTestPlan("TestPlan2");
		assertEquals("TestPlan2", manager.getCurrentTestPlan().getTestPlanName());
		manager.setCurrentTestPlan("TestPlan4");
		assertEquals("Failing Tests", manager.getCurrentTestPlan().getTestPlanName());
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#editTestPlan(java.lang.String)}.
	 */
	@Test
	void testEditTestPlan() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
		manager.addTestPlan("TestPlan2");
		manager.addTestPlan("TestPlan3");
		manager.setCurrentTestPlan("TestPlan2");
		manager.editTestPlan("TestPlan4");
		assertEquals("TestPlan4", manager.getTestPlanNames()[3]);
		assertEquals("TestPlan3", manager.getTestPlanNames()[2]);
		manager.setCurrentTestPlan("TestPlan34234");
		assertThrows(IllegalArgumentException.class, () -> manager.editTestPlan("InvalidTestPlan"));
		manager.setCurrentTestPlan("TestPlan2");
		assertThrows(IllegalArgumentException.class, () -> manager.editTestPlan("Failing Tests"));
		assertThrows(IllegalArgumentException.class, () -> manager.editTestPlan("TestPlan1"));
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#removeTestPlan()}.
	 */
	@Test
	void testRemoveTestPlan() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
		manager.addTestPlan("TestPlan2");
		manager.addTestPlan("TestPlan3");
		assertEquals("TestPlan3", manager.getCurrentTestPlan().getTestPlanName());
		manager.removeTestPlan();
		assertEquals(3, manager.getTestPlanNames().length);
		assertEquals("Failing Tests", manager.getCurrentTestPlan().getTestPlanName());
		assertThrows(IllegalArgumentException.class, () -> manager.removeTestPlan());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestCase(edu.ncsu.csc216.stp.model.tests.TestCase)}.
	 */
	@Test
	void testAddTestCase() {
		TestPlanManager manager = new TestPlanManager();
		TestCase t0 = new TestCase("ID 0", "type 0", "description 0", "expected results 0");
		manager.addTestPlan("TestPlan1");
		manager.addTestPlan("TestPlan2");
		manager.addTestPlan("TestPlan3");
		
		manager.addTestCase(t0);
		assertEquals("ID 0", manager.getCurrentTestPlan().getTestCases().get(0).getTestCaseId());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestResult(int, boolean, java.lang.String)}.
	 */
	@Test
	void testAddTestResult() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
		manager.addTestPlan("TestPlan2");
		TestCase t0 = new TestCase("ID 0", "type 0", "description 0", "expected results 0");
		manager.addTestCase(t0);
		
		manager.addTestResult(0, true, "result");
		assertTrue(manager.getCurrentTestPlan().getTestCases().get(0).isTestCasePassing());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#clearTestPlans()}.
	 */
	@Test
	void testClearTestPlans() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
		manager.addTestPlan("TestPlan2");
		manager.addTestPlan("TestPlan3");
		
		manager.clearTestPlans();
		
		assertEquals(1, manager.getTestPlanNames().length);
		assertEquals(0, manager.getCurrentTestPlan().getTestCases().size());
		
		
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
