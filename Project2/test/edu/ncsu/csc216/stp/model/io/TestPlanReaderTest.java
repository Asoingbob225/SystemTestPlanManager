/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * @author yujim
 *
 */
class TestPlanReaderTest {
	
	/** Valid test file to read **/
	private final String validTestFile = "test-files/test-plans0.txt";

	/** Invalid test file to read **/
	private final String invalidTestFile = "test-files/faketest-plan.txt";

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.io.TestPlanReader#readTestPlansFile(java.io.File)}.
	 */
	@Test
	void testReadTestPlansFile() {
		ISortedList<TestPlan> testPlans = TestPlanReader.readTestPlansFile(validTestFile);
		assertEquals(2, testPlans.size());


		
	}

}
