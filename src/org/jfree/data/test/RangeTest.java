package org.jfree.data.test;

import org.junit.After;
import org.jfree.data.Range;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
	
	private Range rangeObjectUnderTest;

	@BeforeClass
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	public void testGetLength() {
		Range r1 = new Range(2, 2);
			assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength());
		Range r2 = new Range(4, 9);
			assertEquals("getLength: Did not return the expected output", 5.0, r2.getLength());
		Range r3 = new Range(-99, -99);
			assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength());
		Range r4 = new Range(-11, -4);
			assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength());
		Range r5 = new Range(-5, 3);
			assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength());
		}
	
	@AfterClass
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	// Lab 2
									//Test Lower Bound
	@Test
	public void testLowerBoundTwoPositiveInputs() {
		Range r = new Range(2, 10);
			assertEquals("Input values: 2 and 10. Should return 2.", 2.0, r.getLowerBound());
	}

	public void testLowerBoundWithBoundZero() {
		Range r = new Range(0, 15);
		assertEquals("Input values: 0 and 15. Should return 0.", 0.0, r.getLowerBound());
	}
	
	public void testLowerBoundWithNegativeLower() {
		Range r = new Range(-5, 11);
		assertEquals("Input values: -5, 11. Should return -5.", -5.0, r.getLowerBound());
	}
	
	public void testLowerBoundWithTwoSamePositiveInputs() {
		Range r = new Range(12, 12);
		assertEquals("Input values: 12 and 12. Should return 12.", 12.0, r.getLowerBound());
	}
	
	public void testLowerBoundWithTwoSameNegativeInputs() {
		Range r = new Range(-90, -90);
		assertEquals("Input values: -90, -90. Should return -90.", -90.0, r.getLowerBound());
	}
	
									//Test Upper Bound
	///////////// not working
	public void testUpperBoundTwoPositiveInputs() {
		Range r = new Range(2, 10);
		assertEquals("Input values: 2 and 10. Should return 10.", 10.0, r.getUpperBound());
	}
	
	public void testUpperBoundWithBoundZero() {
		Range r = new Range(0, 15);
		assertEquals("Input values: 0 and 15. Should return 0.", 0.0, r.getUpperBound());
	}
	
	//////// not working
	public void testUpperBoundWithTwoNegativeInputs() {
		Range r = new Range(-11, -5);
		assertEquals("Input values: -11 and -5. Should return -5.", -5.0, r.getUpperBound());
	}
	
	public void testUpperBoundWithTwoSameInputs() {
		Range r = new Range(34, 34);
		assertEquals("Input values: 34 and 34. Should return 34.", 34.0, r.getUpperBound());
	}
	
	public void testUpperBoundWithTwoSamePositiveInputs() {
		Range r = new Range(-90, -90);
		assertEquals("Input values: -90 and -90. Should return -90.", -90.0, r.getUpperBound());
	}

									//Test Intersects
	public void testIntersectsTwoPositiveInputs() {
		Range r = new Range(10, 30);
		assertEquals("Input values: 10 and 30. Should return true.", true, r.intersects(10, 30));
	}
	
	public void testIntersectsTwoSamePositiveInputs() {
		Range r = new Range(21, 21);
		assertEquals("Input values: 21 and 21. Should return true.", true, r.intersects(21, 21));
	}
	
	public void testIntersectsOneNegativeInput() {
		Range r = new Range(-11, 5);
		assertEquals("Input values: -11 and 5. Should return true.", true, r.intersects(-11, 5));
	}
	
	public void testIntersectsTwoSameNegativeInputs() {
		Range r = new Range(-58, -58);
		assertEquals("Input values: -58 and -58. Should return true.", true, r.intersects(-58, -58));
	}
	
	public void testIntersectsTwoNegativeInputs() {
		Range r = new Range(-199, -1);
		assertEquals("Input values: -199 and -1. Should return true.", true, r.intersects(-199, -1));
	}
	

										//Test Contains
	public void testContainsTwoPositiveInputsTrue() {
		Range r = new Range(10, 100);
		assertEquals("Input values: 10 and 100. Testing if contains 73. Should return true.", true, r.contains(73));
	}
	
	public void testContainsTwoPositiveInputsFalse() {
		Range r = new Range(21, 25);
		assertEquals("Input values: 21 and 25. Testing if contains 345. Should return false.", false, r.contains(345));
	}
	
	public void testContainsOneNegativeInputTrue() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -11 and 5. Testing if contains -13. Should return true.", true, r.contains(-13));
	}
	
	public void testContainsTwoSameNegativeInputFalse() {
		Range r = new Range(-42, -42);
		assertEquals("Input values: -42 and -42. Testing if contains -19. Should return false.", false, r.contains(-19));
	}

	public void testContainsTwoNegativeInputsTrue() {
		Range r = new Range(-59, -18);
		assertEquals("Input values: -90 and 189. Testing if contains -36. Should return true.", true, r.contains(-36));
	}
	
	public void testContainsTwoSamePositiveInputFalse() {
		Range r = new Range(63, 63);
		assertEquals("Input values: 63 and 63. Testing if contains 62. Should return false.", false, r.contains(62));	
	}
	
	public void testContainsTwoSamePositiveInputsTrue() {
		Range r = new Range(8, 8);
		assertEquals("Input values: 8 and 8. Testing if contains 62. Should return true.", true, r.contains(8));	
	}
	
										//Test Equals
	public void testEqualsTwoSamePositiveInputsTrue() {
		Range r = new Range(76, 76);
		assertEquals("Input values: 76 and 76. Should return true.", true, r.equals(r));	
	}
	
	public void testEqualsTwoSameNegativeInputsTrue() {
		Range r = new Range(-98, -98);
		assertEquals("Input values: -98 and -98. Should return true.", true, r.equals(r));	
	}
	
	//not working
	public void testEqualsTwoDifferentPositiveInputsFalse() {
		Range r = new Range(1, 9);
		assertEquals("Input values: 1 and 9. Should return false.", false, r.equals(r));	
	}
	
	//not working
	public void testEqualsTwoDifferentNegativeInputsFalse() {
		Range r = new Range(-5, -4);
		assertEquals("Input values: -5 and -4. Should return false.", false, r.equals(r));	
	}
	
	//not working
	public void testEqualsOnePositiveOneNegativeFalse() {
		Range r = new Range(-2, 7);
		assertEquals("Input values: -2 and 7. Should return false.", false, r.equals(r));	
	}
	
	

	////////////////////////////////// ???????????????????????????///////////////////////////////
	public void testLowerBound() {
		Range r1 = new Range(2, 10);
			assertEquals("Input values: 2 and 10. Should return 2.", 2.0, r1.getLowerBound());
		Range r2 = new Range(0, 15);
			assertEquals("Input values: 0 and 15. Should return 0.", 0.0, r2.getLowerBound());
		Range r3 = new Range(-5, 11);
			assertEquals("Input values: -5 and 11. Should return -5.", -5.0, r3.getLowerBound());
		Range r4 = new Range(12, 12);
			assertEquals("Input values: 12 and 12. Should return 12.", 12.0, r4.getLowerBound());
		Range r5 = new Range(-90, -90);
			assertEquals("Input values: -90 and -90. Should return -90.", -90.0, r5.getLowerBound());
	}
	
	public void testUpperBound() {
		Range r1 = new Range(2, 10);
			assertEquals("Input values: 2 and 10. Should return 10.", 10.0, r1.getUpperBound());
		Range r2 = new Range(15, 0);
			assertEquals("Input values: 15 and 0. Should return 15.", 15.0, r2.getUpperBound());
		Range r3 = new Range(-11, -5);
			assertEquals("Input values: 11 amd -5. Should return -5.", -5.0, r3.getUpperBound());
	    Range r4 = new Range(34, 34);
			assertEquals("Input values: 34 and 34. Should return 34.", 34.0, r4.getUpperBound());
		Range r5 = new Range(-90, -90);
			assertEquals("Input values: -90 and -90. Should return -90.", -90.0, r5.getUpperBound());
	}
	
	
	public void testIntersects() {
		Range r1 = new Range(10, 30);
			assertEquals("Input values: 10 and 30. Should return true.", true, r1.intersects(10, 30));
		Range r2 = new Range(21, 21);
			assertEquals("Input values: 21 and 21. Should return true.", true, r2.intersects(21, 21));
		Range r3 = new Range(-11, 5);
			assertEquals("Input values: -11 and 5. Should return true.", true, r3.intersects(-11, 5));
	    Range r4 = new Range(-58, -58);
			assertEquals("Input values: -58 and -58. Should return true.", true, r4.intersects(-58, -58));
		Range r5 = new Range(-199, -1);
			assertEquals("Input values: -90 and -189. Should return true.", true, r5.intersects(-199, -1));
	}
	
	public void testEquals() {
		Range r1 = new Range(10, 30);
			assertEquals("Input values: 10 and 30. Should return false.", false, r1.equals(r1));
		Range r2 = new Range(21, 21);
			assertEquals("Input values: 21 and 21. Should return true.", true, r2.equals(r2));
			/*
			 * Range r3 = new Range(-11, 5);
			 * assertEquals("Input values: -11 and 5. Should return true.", true,
			 * r3.equals(r3)); Range r4 = new Range(-58, -58);
			 * assertEquals("Input values: -58 and -58. Should return true.", true,
			 * r4.equals(r4)); Range r5 = new Range(-99, 189);
			 * assertEquals("Input values: -90 and 189. Should return true.", true,
			 * r5.equals(r5));
			 */
	}
	
	public void testContains() {
		Range r1 = new Range(10, 100);
			assertEquals("Input values: 10 and 100. Testing if contains 73. Should return true.", true, r1.contains(73));
		Range r2 = new Range(21, 25);
			assertEquals("Input values: 21 and 25. Testing if contains 345. Should return false.", false, r2.contains(345));
		Range r3 = new Range(-34, 6);
			assertEquals("Input values: -11 and 5. Testing if contains -13. Should return true.", true, r3.contains(-13));
		Range r4 = new Range(-42, -42);
			assertEquals("Input values: -42 and -42. Testing if contains -19. Should return false.", false, r4.contains(-19));
		Range r5 = new Range(-59, -18);
			assertEquals("Input values: -90 and 189. Testing if contains -36. Should return true.", true, r5.contains(-36));
		Range r6 = new Range(63, 63);
			assertEquals("Input values: 63 and 63. Testing if contains 62. Should return false.", false, r6.contains(62));	
			
	}
}
