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

	/*
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
	*/

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
	
	@Test
	public void testLowerBoundWithNULLInputs() {
		Range r = new Range(4, );
		assertEquals("Input values: 4 and NULL. Should return error.", 0.0, r.getLowerBound(), 0.000000001d);
	}
	
	
									// Test Upper Bound
	///////////// not working
	public void testUpperBoundTwoPositiveInputs() {
		Range r = new Range(2, 10);
		assertEquals("Input values: 2 and 10. Should return 10.", 10.0, r.getUpperBound(), 0.000000001d);
	}

	//////////// not working
	@Test
	public void testUpperBoundWithBoundZero() {
		Range r = new Range(0, 15);
		assertEquals("Input values: 0 and 15. Should return 15.", 15.0, r.getUpperBound(), 0.000000001d);
	}

	//////// not working
	@Test
	public void testUpperBoundWithTwoNegativeInputs() {
		Range r = new Range(-11, -5);
		assertEquals("Input values: -11 and -5. Should return -5.", -5.0, r.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundWithTwoSamePositiveInputs() {
		Range r = new Range(34, 34);
		assertEquals("Input values: 34 and 34. Should return 34.", 34.0, r.getUpperBound(), 0.000000001d);
	}

	@Test
	public void testUpperBoundWithTwoSameNegativeInputs() {
		Range r = new Range(-90, -90);
		assertEquals("Input values: -90 and -90. Should return -90.", -90.0, r.getUpperBound(), 0.000000001d);
	}
	
	//errororororrororororrrr
	@Test
	public void testUpperBoundWithNullInput() {
		Range r = new Range(7, );
		assertEquals("Input values: 12. Should return error.", 1, r.getUpperBound(), 0.000000001d);
	}


											// Test Contains
	@Test
	public void testContainsPositiveInputTrue() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -34 and 6. Testing if contains 3. Should return true.", true, r.contains(3));
	}

	@Test
	public void testContainsPositiveInputFalse() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -34 and 6. Testing if contains 19. Should return false.", false, r.contains(19));
	}

	@Test
	public void testContainsNegativeInputTrue() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -34 and 6. Testing if contains -20. Should return true.", true, r.contains(-20));
	}

	@Test
	public void testContainsNegativeInputFalse() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -34 and 6. Testing if contains -97. Should return false.", false, r.contains(-97));
	}

	@Test
	public void testContainsStringInputFalse() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -34 and 6. Testing if contains 'r'. Should return false.", false, r.contains('r'));
	}
		
	///////////////////////////// compile error???????////////////////
	
	@Test
	public void testContainsNullInputFalse() {
		Range r = new Range(-34, 6);
		assertEquals("Input values: -34 and 6. Testing NULL. Should return false.", false, r.contains(''));
	}

												//Test Constrain
	@Test
	public void testConstrainPositiveInputInRange(){
		Range r = new Range(-30, 50);
		double constraint = 6;
		assertEquals("Input values: -30 and 50. Constraint: 6. Should return 6.", constraint, r.constrain(6), 0.000000001d);
	}

	@Test 
	public void testConstrainNegativeInputInRange(){
		Range r = new Range(-30, 50);
		double constraint = -11;
		assertEquals("Input values: -30 and 50. Constraint: -11. Should return -11.", constraint, r.constrain(-11), 0.000000001d);
	}

	@Test 
	public void testConstrainPositiveNotInRange(){
		Range r = new Range(-30, 50);
		double constraint = 50;
		assertEquals("Input values: -30 and 50. Constraint: 53. Not in range, should return 50.", constraint, r.constrain(53), 0.000000001d);
	}

	//not working ?????
	@Test 
	public void testConstrainNegativeNotInRange(){
		Range r = new Range(-30, 50);
		double constraint = -30;
		assertEquals("Input values: -30 and 50. Constraint: -76. Not in range, should return -30.", constraint, r.constrain(-76), 0.000000001d);
	}

	@Test 
	public void testConstrainStringNotInRange(){
		Range r = new Range(-30, 50);
		double constraint = 0;
		assertEquals("Input values: -30 and 50. Constraint: 'a'. Should return error.", constraint, r.constrain('a'), 0.000000001d);
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
	public void testGetLengthWithSamePositiveInput() {
		Range r = new Range(8, 8);
		assertEquals("Input values: 8 and 8. Should return 0", 0.0, r.getLength(), 0.000000001d);
	}

	@Test
	public void testGetLengthWithSameNegativeInput() {
		Range r = new Range(-3, -3);
		assertEquals("Input values: -3 and -3. Should return 0", 0.0, r.getLength(), 0.000000001d);
	}

}
