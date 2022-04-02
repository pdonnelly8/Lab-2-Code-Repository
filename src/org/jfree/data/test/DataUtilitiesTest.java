package org.jfree.data.test;

import java.lang.IllegalArgumentException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {

	private Values2D values2D;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1,  0,  0);
		testValues.addValue(2,  0,  1);
		testValues.addValue(3,  1,  0);
		testValues.addValue(4,  1,  1);
		System.out.println(testValues.toString());
	}

	@After
	protected void tearDown() throws Exception {
		values2D = null;
	}

	@Test
	public void testCalculateColumnTotal1() {
		assertEquals("Wrong Sum Returned. It should be 4.0", 4.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testNullDataColumnTotal() {
		try 
		{
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testIncorrectColumnIndex() {
		try {
			DataUtilities.calculateColumnTotal(values2D, -1);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	//These don't work but just adding in
	@Test
	public void testValidRowTotal() {
		assertEquals("Wrong Sum Returned. It should be 1.0", 1.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testIncorrectRowIndex() {
		try 
		{
			DataUtilities.calculateRowTotal(values2D, -1);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testNullDataRowTotal() {
		try 
		{
			DataUtilities.calculateRowTotal(null, 0);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray() {
		double[] data = {10, 20, 30};
		Number[] newData = DataUtilities.createNumberArray(data);
		assertEquals("TC3 Failed. Incorrect Middle Value - Expected 20", 20.0, newData[1]);
		assertEquals("TC4 Failed. Incorrect Left Boundary Value - Expected 10", 10.0, newData[0]);
		assertEquals("TC5 Failed. Incorrect Right Boundary Value - Expected 30", 30.0, newData[2]);

		try {
			Number leftWrong = newData[-1];
			fail("TC6 Failed. No Exception was thrown for index past left boundary - Expected Outcome Was: A thrown exception of type: IndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC6 FailedIncorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}
		
		try {
			Number rightWrong = newData[3];
			fail("TC7 Failed. No Exception was thrown for index past right boundary - Expected Outcome Was: A thrown exception of type: IndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC7 Failed. Incorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testNullCreateNumberArray() {
		try {
			DataUtilities.createNumberArray(null);
			fail("TC2 Failed. No Exception was thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("TC2 Failed. Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testValidCreateNumberArray2D() {
		double[][] arr = { {1,2,3}, {4,5,6}, {7,8,9}};
		Number[][] newArr = DataUtilities.createNumberArray2D(arr);
		assertEquals(newArr.getClass(), Number[][].class);	
	}
	
	@Test
	public void testNullCreateNumberArray2D() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("No Exception was thrown");
		}
		catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	
	public void testValidGetCumulative() {
		
	}
}
