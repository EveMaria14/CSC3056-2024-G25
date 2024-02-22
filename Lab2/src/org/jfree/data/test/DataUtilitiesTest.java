package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.DataUtilities;

public class DataUtilitiesTest {
	private Values2D values2D;
	
	@Before
	public void setUp() {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}
	
	@After
	public void tearDown() {
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}
	
	@Test
	public void testValidDataAndColumnColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0",
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testNullDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown. The expected outcome was: a thrown exception of type: IllegalArgumentException");
		} 
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(IllegalArgumentException.class));
		}
	}
}

