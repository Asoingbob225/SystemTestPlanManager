/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Unit Test for the TestPlanReader class
 * 
 * @author yujim
 *
 */
class TestPlanReaderTest {

	/** Valid test file to read **/
	private final String validTestFile = "test-files/test-plans0.txt";

	/** Invalid test file to read **/
	private final String invalidTestFile = "test-files/faketest-plan.txt";

	/**
	 * Test method for
	 * {@link edu.ncsu.csc216.stp.model.io.TestPlanReader#readTestPlansFile(java.io.File)}.
	 */
	@Test
	void testReadTestPlansFile() {
		ISortedList<TestPlan> testPlans = TestPlanReader.readTestPlansFile(new File(validTestFile));
		assertEquals(2, testPlans.size());

		assertEquals("PackScheduler", testPlans.get(0).getTestPlanName());
		assertEquals("WolfScheduler", testPlans.get(1).getTestPlanName());

		assertEquals(2, testPlans.get(0).getTestCases().size());
		assertEquals(3, testPlans.get(1).getTestCases().size());

		assertThrows(IllegalArgumentException.class, () -> TestPlanReader.readTestPlansFile(new File(invalidTestFile)));

	}

}
