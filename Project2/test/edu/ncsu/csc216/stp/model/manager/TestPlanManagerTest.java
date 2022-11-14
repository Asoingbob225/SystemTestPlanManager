/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
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
		assertEquals("Failing_Tests", manager.getCurrentTestPlan().getTestPlanName());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#loadTestPlans(java.io.File)}.
	 */
	@Test
	void testLoadTestPlans() {
		TestPlanManager manager = new TestPlanManager();
		manager.loadTestPlans(new File("test-files/test-plans0.txt"));
		assertEquals(2, manager.getTestPlanNames().length);
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#saveTestPlans(java.io.File)}.
	 */
	@Test
	void testSaveTestPlans() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("TestPlan1");
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
		manager.addTestCase(t0);
		manager.addTestCase(t1);
		manager.addTestCase(t2);
		manager.addTestPlan("TestPlan2");
		
		manager.saveTestPlans(new File("test-files/urmom.txt"));
		try (Scanner expected = new Scanner(new File("test-files/actual_output.txt"));
		Scanner actual = new Scanner(new File("test-files/urmom.txt"));) {
			
			while (expected.hasNextLine()) {
				assertEquals(expected.nextLine(), actual.nextLine());
			}
			expected.close();
			actual.close();
			} catch (FileNotFoundException e) {
				fail("Error");
			}
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#isChanged()}.
	 */
	@Test
	void testIsChanged() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestPlan(java.lang.String)}.
	 */
	@Test
	void testAddTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#getTestPlanNames()}.
	 */
	@Test
	void testGetTestPlanNames() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#setCurrentTestPlan(java.lang.String)}.
	 */
	@Test
	void testSetCurrentTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#getCurrentTestPlan()}.
	 */
	@Test
	void testGetCurrentTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#editTestPlan(java.lang.String)}.
	 */
	@Test
	void testEditTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#removeTestPlan()}.
	 */
	@Test
	void testRemoveTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestCase(edu.ncsu.csc216.stp.model.tests.TestCase)}.
	 */
	@Test
	void testAddTestCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestResult(int, boolean, java.lang.String)}.
	 */
	@Test
	void testAddTestResult() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#clearTestPlans()}.
	 */
	@Test
	void testClearTestPlans() {
		fail("Not yet implemented");
	}

}
