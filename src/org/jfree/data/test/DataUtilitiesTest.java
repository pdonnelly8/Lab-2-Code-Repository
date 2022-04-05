package org.jfree.data.test;

import java.lang.IllegalArgumentException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
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

	private Values2D values2DPos;
	private Values2D values2DNeg;
	private Values2D values2DMix;
	private KeyedValues keyedValuesPos;
	private KeyedValues keyedValuesNeg;
	private KeyedValues keyedValuesMix;
	private double[] data;
	private double[][] arr;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		DefaultKeyedValues2D testValuesNeg = new DefaultKeyedValues2D();
		DefaultKeyedValues2D testValuesMix = new DefaultKeyedValues2D();
		DefaultKeyedValues testKeyed = new DefaultKeyedValues();
		DefaultKeyedValues testKeyedNeg = new DefaultKeyedValues();
		DefaultKeyedValues testKeyedMix = new DefaultKeyedValues();
		values2DPos = testValues;
		values2DNeg = testValuesNeg;
		values2DMix = testValuesMix;
		keyedValuesPos = testKeyed;
		keyedValuesNeg = testKeyedNeg;
		keyedValuesMix = testKeyedMix;
		
		testValues.addValue(1,  0,  0);
		testValues.addValue(2,  0,  1);
		testValues.addValue(3,  1,  0);
		testValues.addValue(4,  1,  1);
		testValuesNeg.addValue(-1,  0,  0);
		testValuesNeg.addValue(-2,  0,  1);
		testValuesNeg.addValue(-3,  1,  0);
		testValuesNeg.addValue(-4,  1,  1);
		testValuesMix.addValue(-1,  0,  0);
		testValuesMix.addValue(-2,  0,  1);
		testValuesMix.addValue(-3,  1,  0);
		testValuesMix.addValue(-4,  1,  1);
		
		data = new double[3];
		data[0] = 10.0;
		data[1] = 20.0;
		data[2] = 30.0;
		
		arr = new double[3][3];
		arr[0][0] = 1.0;
		arr[0][1] = 2.0;
		arr[0][2] = 3.0;
		arr[1][0] = 4.0;
		arr[1][1] = 5.0;
		arr[1][2] = 6.0;
		arr[2][0] = 7.0;
		arr[2][1] = 8.0;
		arr[2][2] = 9.0;
	}

	@After
	protected void tearDown() throws Exception {
		values2DPos = null;
		data = null;
		arr = null;
	}

	@Test
	public void testCalculateColumnTotal1CorrectDataAndCol() {
		assertEquals("Wrong Sum Returned. It should be 4.0", 4.0, DataUtilities.calculateColumnTotal(values2DPos, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotal2CorrectDataNegativeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DPos, -1), 0.0000001d);
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotal3CorrectDataTooLargeColumnIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateColumnTotal(values2DPos, 20), 0.0000001d);
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotal4NullDataValidCol() {
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
	public void testCalculateColumnTotal5NullDataNegativeCol() {
		try 
		{
			DataUtilities.calculateColumnTotal(null, -1);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateColumnTotal6NullDataTooLargeCol() {
		try 
		{
			DataUtilities.calculateColumnTotal(null, 20);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotal1CorrectDataAndRow() {
		assertEquals("Wrong Sum Returned. It should be 7.0", 7.0, DataUtilities.calculateRowTotal(values2DPos, 1), 0.0000001d);
	}
	
	@Test
	public void testCalculateRowTotal2CorrectDataNegativeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DPos, -1), 0.0000001d);
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotal3CorrectDataTooLargeRowIndex() {
		try {
			assertEquals("Wrong Sum Returned. It should be 0", 0.0, DataUtilities.calculateRowTotal(values2DPos, 20), 0.0000001d);
		} catch (Exception e) {
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IndexOutOfBoundsException.class));
		}	
	}
	
	@Test
	public void testCalculateRowTotal4NullDataValidRow() {
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
	public void testCalculateRowTotal5NullDataNegativeRow() {
		try 
		{
			DataUtilities.calculateRowTotal(null, -1);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCalculateRowTotal6NullDataTooLargeRow() {
		try 
		{
			DataUtilities.calculateRowTotal(null, 20);
			fail("No Exception Was Thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2NullInput() {
		try {
			DataUtilities.createNumberArray(null);
			fail("TC2 Failed. No Exception was thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("TC2 Failed. Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray3ValidDataNotOnBoundary() {
		assertEquals("TC3 Failed. Incorrect Middle Value - Expected 20", 20.0, DataUtilities.createNumberArray(data)[1]);
	}
	
	@Test
	public void testCreateNumberArray4ValidDataOnLeftBoundary() {
		assertEquals("TC4 Failed. Incorrect Left Boundary Value - Expected 10", 10.0, DataUtilities.createNumberArray(data)[0]);
	}
	
	@Test
	public void testCreateNumberArray5ValidDataOnRightBoundary() {
		assertEquals("TC5 Failed. Incorrect Right Boundary Value - Expected 30", 30.0, DataUtilities.createNumberArray(data)[2]);
	}
	
	
	@Test
	public void testCreateNumberArray6ValidDataPastLeftBoundary() {
		try {
			Number pastleft = DataUtilities.createNumberArray(data)[-1];
			fail("TC6 Failed. No Exception was thrown for index past left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC6 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray7ValidDataPastRightBoundary() {
		try {
			Number pastRight = DataUtilities.createNumberArray(data)[3];
			fail("TC6 Failed. No Exception was thrown for index past right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC7 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DNullInput() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("TC2 Failed. No Exception was thrown - Expected Outcome Was: A thrown exception of type: IllegalArgumentException");
		}
		catch (Exception e) {
			assertTrue("TC2 Failed. Incorrect Exception Type Thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D3NotOnBoundary() {
		assertEquals("TC3 Failed. Incorrect Middle Value - Expected 5", 5.0, DataUtilities.createNumberArray2D(arr)[1][1]);
	}
	
	@Test
	public void testCreateNumberArray2D4OnLeftBoundary() {
		assertEquals("TC4 Failed. Incorrect Left Value - Expected 4", 4.0, DataUtilities.createNumberArray2D(arr)[1][0]);
	}
	
	@Test
	public void testCreateNumberArray2D5OnRightBoundary() {
		assertEquals("TC5 Failed. Incorrect Right Value - Expected 6", 6.0, DataUtilities.createNumberArray2D(arr)[1][2]);
	}
	
	@Test
	public void testCreateNumberArray2D6OnTopBoundary() { 
		assertEquals("TC6 Failed. Incorrect Top Value - Expected 2", 2.0, DataUtilities.createNumberArray2D(arr)[0][1]);
	}
	
	@Test
	public void testCreateNumberArray2D7OnBottomBoundary() {
		assertEquals("TC7 Failed. Incorrect Bottom Value - Expected 8", 8.0, DataUtilities.createNumberArray2D(arr)[2][1]);
	}
	
	@Test
	public void testCreateNumberArray2D8OnTopLeftBoundary() {
		assertEquals("TC8 Failed. Incorrect Top-Left Value - Expected 5", 1.0, DataUtilities.createNumberArray2D(arr)[0][0]);
	}
	
	@Test
	public void testCreateNumberArray2D9OnBottomLeftBoundary() {
		assertEquals("TC9 Failed. Incorrect Bottom-Left Value - Expected 7", 7.0, DataUtilities.createNumberArray2D(arr)[2][0]);
	}
	
	@Test
	public void testCreateNumberArray2D10OnTopRightBoundary() {
		assertEquals("TC10 Failed. Incorrect Top-Right Value - Expected 3", 3.0, DataUtilities.createNumberArray2D(arr)[0][2]);
	}
	
	@Test
	public void testCreateNumberArray2D11OnBottomRightBoundary() {
		assertEquals("TC11 Failed. Incorrect Bottom-Left Value - Expected 9", 9.0, DataUtilities.createNumberArray2D(arr)[2][2]);
	}
	
	@Test
	public void testCreateNumberArray2D12PastLeftBoundary() {
		try {
			Number pastLeft = DataUtilities.createNumberArray2D(arr)[1][-1];
			fail("TC12 Failed. No Exception was thrown for index past left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC12 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D13PastRightBoundary() {
		try {
			Number pastRight = DataUtilities.createNumberArray2D(arr)[1][3];
			fail("TC13 Failed. No Exception was thrown for index past right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC13 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D14PastTopBoundary() {
		try {
			Number pastTop = DataUtilities.createNumberArray2D(arr)[-1][1];
			fail("TC14 Failed. No Exception was thrown for index past top boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC14 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D15PastBottomBoundary() {
		try {
			Number pastBottom = DataUtilities.createNumberArray2D(arr)[3][1];
			fail("TC15 Failed. No Exception was thrown for index past bottom boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC15 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D16PastTopLeftBoundary() {
		try {
			Number pastTopLeft = DataUtilities.createNumberArray2D(arr)[-1][-1];
			fail("TC16 Failed. No Exception was thrown for index past top-left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC16 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D17PastBottomLeftBoundary() {
		try {
			Number paatBottomLeft = DataUtilities.createNumberArray2D(arr)[3][-1];
			fail("TC17 Failed. No Exception was thrown for index past bottom-left boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC17 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D18PastTopRightBoundary() {
		try {
			Number pastTopRight = DataUtilities.createNumberArray2D(arr)[-1][3];
			fail("TC18 Failed. No Exception was thrown for index past top-right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC18 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2D19PastBottomRightBoundary() {
		try {
			Number pastBottomRight = DataUtilities.createNumberArray2D(arr)[3][3];
			fail("TC19 Failed. No Exception was thrown for index past bottom-right boundary - Expected Outcome Was: A thrown exception of type: ArrayIndexOutOfBoundsException");
		} catch (Exception e) {
			assertTrue("TC19 Failed. Incorrect Exception Type Thrown", e.getClass().equals(ArrayIndexOutOfBoundsException.class));
		}
	}
}
