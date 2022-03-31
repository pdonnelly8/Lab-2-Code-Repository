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
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	// Lab 2
	// Test Lower Bound
	@Test
	public void testLowerBoundTwoPositiveInputs() {
		Range r = new Range(2, 10);
		assertEquals("Input values: 2 and 10. Should return 2.", 2.0, r.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundWithBoundZero() {
		Range r = new Range(0, 15);
		assertEquals("Input values: 0 and 15. Should return 0.", 0.0, r.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundWithNegativeLower() {
		Range r = new Range(-5, 11);
		assertEquals("Input values: -5, 11. Should return -5.", -5.0, r.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundWithTwoSamePositiveInputs() {
		Range r = new Range(12, 12);
		assertEquals("Input values: 12 and 12. Should return 12.", 12.0, r.getLowerBound(), 0.000000001d);
	}

	@Test
	public void testLowerBoundWithTwoSameNegativeInputs() {
		Range r = new Range(-90, -90);
		assertEquals("Input values: -90, -90. Should return -90.", -90.0, r.getLowerBound(), 0.000000001d);
	}

									// Test Upper Bound
	///////////// not working
	public void testUpperBoundTwoPositiveInputs() {
		Range r = new Range(2, 10);
		assertEquals("Input values: 2 and 10. Should return 10.", 10.0, r.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundWithBoundZero() {
		Range r = new Range(0, 15);
		assertEquals("Input values: 0 and 15. Should return 0.", 0.0, r.getUpperBound(), 0.000000001d);
	}

	//////// not working
	@Test
	public void testUpperBoundWithTwoNegativeInputs() {
		Range r = new Range(-11, -5);
		assertEquals("Input values: -11 and -5. Should return -5.", -5.0, r.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundWithTwoSameInputs() {
		Range r = new Range(34, 34);
		assertEquals("Input values: 34 and 34. Should return 34.", 34.0, r.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundWithTwoSamePositiveInputs() {
		Range r = new Range(-90, -90);
		assertEquals("Input values: -90 and -90. Should return -90.", -90.0, r.getUpperBound(), 0.000000001d);
	}


											// Test Contains
	@Test
	public void testContainsTwoPositiveInputsTrue() {
		Range r = new Range(10, 100);
		assertEquals("Input values: 10 and 100. Testing if contains 73. Should return true.", true, r.contains(73), 0.000000001d);
	}

	@Test
	public void testContainsTwoPositiveInputsFalse() {
		Range r = new Range(21, 25);
		assertEquals("Input values: 21 and 25. Testing if contains 345. Should return false.", false, r.contains(345), 0.000000001d);
	}

	@Test
	public void testContainsOneNegativeInputTrue() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -11 and 5. Testing if contains -13. Should return true.", true, r.contains(-13), 0.000000001d);
	}

	@Test
	public void testContainsTwoSameNegativeInputFalse() {
		Range r = new Range(-42, -42);
		assertEquals("Input values: -42 and -42. Testing if contains -19. Should return false.", false, r.contains(-19), 0.000000001d);
	}

	@Test
	public void testContainsTwoNegativeInputsTrue() {
		Range r = new Range(-59, -18);
		assertEquals("Input values: -90 and 189. Testing if contains -36. Should return true.", true, r.contains(-36), 0.000000001d);
	}

	@Test
	public void testContainsTwoSamePositiveInputFalse() {
		Range r = new Range(63, 63);
		assertEquals("Input values: 63 and 63. Testing if contains 62. Should return false.", false, r.contains(62), 0.000000001d);
	}

	@Test
	public void testContainsTwoSamePositiveInputsTrue() {
		Range r = new Range(8, 8);
		assertEquals("Input values: 8 and 8. Testing if contains 62. Should return true.", true, r.contains(8), 0.000000001d);
	}

										// Test Equals
	@Test
	public void testEqualsTwoSamePositiveInputsTrue() {
		Range r = new Range(76, 76);
		assertEquals("Input values: 76 and 76. Should return true.", true, r.equals(r), 0.000000001d);
	}

	@Test
	public void testEqualsTwoSameNegativeInputsTrue() {
		Range r = new Range(-98, -98);
		assertEquals("Input values: -98 and -98. Should return true.", true, r.equals(r), 0.000000001d);
	}

	// not working
	@Test
	public void testEqualsTwoDifferentPositiveInputsFalse() {
		Range r = new Range(1, 9);
		assertEquals("Input values: 1 and 9. Should return false.", false, r.equals(r), 0.000000001d);
	}

	// not working
	@Test
	public void testEqualsTwoDifferentNegativeInputsFalse() {
		Range r = new Range(-5, -4);
		assertEquals("Input values: -5 and -4. Should return false.", false, r.equals(r), 0.000000001d);
	}

	// not working
	@Test
	public void testEqualsOnePositiveOneNegativeFalse() {
		Range r = new Range(-2, 7);
		assertEquals("Input values: -2 and 7. Should return false.", false, r.equals(r), 0.000000001d);
	}

	@Test
	public void testConstrainTwoPositiveInputs(){
		Range r = new Range(2, 10);
		double constraint = 6;
		assertEquals("Input values: 2 and 10. Constraint: 6. Should return 6.", constraint, r.constrain(6), 0.000000001d);
	}

	@Test 
	public void testConstrainTwoNegativeInputs(){
		Range r = new Range(-40, -30);
		double constraint = -11;
		assertEquals("Input values: -40 and -30. Constraint: -11. Should return -11.", constraint, r.constrain(-11), 0.000000001d);
	}

	@Test 
	public void testConstrainPositiveOutOfRange(){
		Range r = new Range(20, 100);
		double constraint = 13;
		assertEquals("Input values: 20 and 100. Constraint: 13. Should return 20.", constraint, r.constrain(20), 0.000000001d);
	}

	@Test 
	public void testConstrainTwoNegativeInputs(){
		Range r = new Range(-40, -30);
		double constraint = -11;
		assertEquals("Input values: -40 and -30. Constraint: -11. Should return -11.", constraint, r.constrain(-11), 0.000000001d);
	}

										// Test Get Length
	@Test
	public void testGetLengthTwoPositiveInputs() {
		Range r = new Range(4, 9);
		assertEquals("Input values: 4 and 9. Should return 5", 5.0, r.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthTwoNegativeInputs() {
		Range r = new Range(-17, -1);
		assertEquals("Input values: -17 and -1. Should return 16", 16.0, r.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthOnePositiveOneNegativeInput() {
		Range r = new Range(-53, 64);
		assertEquals("Input values: -53 and 64. Should return 117", 117.0, r.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthWithSameNumber() {
		Range r = new Range(8, 8);
		assertEquals("Input values: 8 and 8. Should return 0", 0.0, r.getLength()), 0.000000001d;
	}

	// not showing up???????????
	@Test
	public void oooooooooooooheyintersect() {
		Range r = new Range(0, 1);
		assertEquals("is it  true?", true, r.intersects(0.5, 1.5), 0.000000001d);
	}
	
	//not showing up??????????
	@Test
	public void eeeeeeeeeeeeeeeeeequals() {
		Range r1 = new Range(0, 1);
		Range r2 = new Range(0, 1);
		Range r3 = new Range(4, 9);
		assertEquals("yes true?", true, r1.equals(r2), 0.000000001d);
		assertEquals("yes true?", true, r2.equals(r1), 0.000000001d);
		assertEquals("nooo!!!!", false, r1.equals(r3), 0.000000001d);
	}
	
	////////////////////////////////// ???????????????????????????///////////////////////////////
	/*
	 * public void testLowerBound() { Range r1 = new Range(2, 10);
	 * assertEquals("Input values: 2 and 10. Should return 2.", 2.0,
	 * r1.getLowerBound()); Range r2 = new Range(0, 15);
	 * assertEquals("Input values: 0 and 15. Should return 0.", 0.0,
	 * r2.getLowerBound()); Range r3 = new Range(-5, 11);
	 * assertEquals("Input values: -5 and 11. Should return -5.", -5.0,
	 * r3.getLowerBound()); Range r4 = new Range(12, 12);
	 * assertEquals("Input values: 12 and 12. Should return 12.", 12.0,
	 * r4.getLowerBound()); Range r5 = new Range(-90, -90);
	 * assertEquals("Input values: -90 and -90. Should return -90.", -90.0,
	 * r5.getLowerBound()); }
	 * 
	 * public void testUpperBound() { Range r1 = new Range(2, 10);
	 * assertEquals("Input values: 2 and 10. Should return 10.", 10.0,
	 * r1.getUpperBound()); Range r2 = new Range(15, 0);
	 * assertEquals("Input values: 15 and 0. Should return 15.", 15.0,
	 * r2.getUpperBound()); Range r3 = new Range(-11, -5);
	 * assertEquals("Input values: 11 amd -5. Should return -5.", -5.0,
	 * r3.getUpperBound()); Range r4 = new Range(34, 34);
	 * assertEquals("Input values: 34 and 34. Should return 34.", 34.0,
	 * r4.getUpperBound()); Range r5 = new Range(-90, -90);
	 * assertEquals("Input values: -90 and -90. Should return -90.", -90.0,
	 * r5.getUpperBound()); }
	 * 
	 * 
	 * public void testIntersects() { Range r1 = new Range(10, 30);
	 * assertEquals("Input values: 10 and 30. Should return true.", true,
	 * r1.intersects(10, 30)); Range r2 = new Range(21, 21);
	 * assertEquals("Input values: 21 and 21. Should return true.", true,
	 * r2.intersects(21, 21)); Range r3 = new Range(-11, 5);
	 * assertEquals("Input values: -11 and 5. Should return true.", true,
	 * r3.intersects(-11, 5)); Range r4 = new Range(-58, -58);
	 * assertEquals("Input values: -58 and -58. Should return true.", true,
	 * r4.intersects(-58, -58)); Range r5 = new Range(-199, -1);
	 * assertEquals("Input values: -90 and -189. Should return true.", true,
	 * r5.intersects(-199, -1)); }
	 * 
	 * public void testEquals() { Range r1 = new Range(10, 30);
	 * assertEquals("Input values: 10 and 30. Should return false.", false,
	 * r1.equals(r1)); Range r2 = new Range(21, 21);
	 * assertEquals("Input values: 21 and 21. Should return true.", true,
	 * r2.equals(r2));
	 * 
	 * Range r3 = new Range(-11, 5);
	 * assertEquals("Input values: -11 and 5. Should return true.", true,
	 * r3.equals(r3)); Range r4 = new Range(-58, -58);
	 * assertEquals("Input values: -58 and -58. Should return true.", true,
	 * r4.equals(r4)); Range r5 = new Range(-99, 189);
	 * assertEquals("Input values: -90 and 189. Should return true.", true,
	 * r5.equals(r5));
	 * 
	 * }
	 * 
	 * public void testContains() { Range r1 = new Range(10, 100);
	 * assertEquals("Input values: 10 and 100. Testing if contains 73. Should return true."
	 * , true, r1.contains(73)); Range r2 = new Range(21, 25);
	 * assertEquals("Input values: 21 and 25. Testing if contains 345. Should return false."
	 * , false, r2.contains(345)); Range r3 = new Range(-34, 6);
	 * assertEquals("Input values: -11 and 5. Testing if contains -13. Should return true."
	 * , true, r3.contains(-13)); Range r4 = new Range(-42, -42);
	 * assertEquals("Input values: -42 and -42. Testing if contains -19. Should return false."
	 * , false, r4.contains(-19)); Range r5 = new Range(-59, -18);
	 * assertEquals("Input values: -90 and 189. Testing if contains -36. Should return true."
	 * , true, r5.contains(-36)); Range r6 = new Range(63, 63);
	 * assertEquals("Input values: 63 and 63. Testing if contains 62. Should return false."
	 * , false, r6.contains(62));
	 * 
	 * }
	 */
}
