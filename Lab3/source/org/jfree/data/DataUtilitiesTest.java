package org.jfree.data;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {
	private Values2D values2D;
	
	@Before
	public void setUp() {
	    DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
	    values2D = testValues;
	    
	    // Valid data
	    testValues.addValue(1, 0, 0);
	    testValues.addValue(4, 1, 0);
	    testValues.addValue(7, 2, 0);
	}
	
	@After
	public void tearDown() {
		
	}
	
	// test method1 calculateColumnTotal(Values2D data, column)
	
	@Test //expected 12.0 with column index 0
	public void testValidDataAndValidColumnColumnTotal() {
		assertEquals("Incorrect. It should be 12.0",
				12.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test //expected 0 with valid data and negative column index
	public void testValidDataAndNegativeColumnColumnTotal() {
	    try {
	        double result = DataUtilities.calculateColumnTotal(values2D, -10);
	        assertEquals("Expected 0.0 for invalid column", 0.0, result, 0.0000001d);
	    } catch (Exception e) {
	        // If any exception other than IndexOutOfBoundsException is thrown, the test fails
	        fail("Unexpected exception: " + e.getClass().getSimpleName());
	    }
	}
	
	@Test //expected 0 with valid data and out of range (right) column index
	public void testValidDataAndOutofBoundRightColumnColumnTotal() {
		try {
	        double result = DataUtilities.calculateColumnTotal(values2D, 100);
	        assertEquals("Expected 0.0 for invalid column", 0.0, result, 0.0000001d);
		} catch (Exception e) {
	        // If any exception other than IndexOutOfBoundsException is thrown, the test fails
	        fail("Unexpected exception: " + e.getClass().getSimpleName());
	    }
	}
	
	@Test // Test Case1: Empty Data with Zero Row Count (lab3)
	public void testCase1CalulateColumnTotal() {
	    Values2D emptyData = new DefaultKeyedValues2D();
	    double result = DataUtilities.calculateColumnTotal(emptyData, 0);
	    assertEquals(0.0, result, 0.0001); // Ensure the result is 0.0
	}
	
	@Test // Test Case2: Data with Null Values (lab3)
	public void testCase2CalulateColumnTotal() {
		DefaultKeyedValues2D values = new DefaultKeyedValues2D();
	    values.addValue(null, 0, 0);
	    values.addValue(4, 1, 0);

	    try {
	    	DataUtilities.calculateColumnTotal(values, 0);
			fail("The expected outcome is IllegalArgumentException");
	    } catch (Exception e) {
	    	assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
	    }
	}

	@Test //expected IllegalArgumentException with null data and valid column
	public void testNullDataAndValidColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("The expected outcome is IllegalArgumentException");
		} 
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));		
		}
	}
	
	
	@Test //expected IllegalArgumentException with null data and negative column
	public void testNullDataAndNegativeColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, -100);
			fail("The expected outcome is IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));		}
	}
	
	@Test //expected IllegalArgumentException with null data and out of range (right) column
	public void testNullDataAndOutofRangeRightColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 1000);
			fail("The expected outcome is IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));		}
	}
	
	@Test //expected IllegalArgumentException with non-2D data and valid column index
	public void testInvalidDataAndValidColumnColumnTotal() {
	    DefaultKeyedValues2D non2DValues = new DefaultKeyedValues2D();
	    non2DValues.addValue(1, 0, 3);

	    try {
	        // Attempt to calculate the column total with non-2D data
	        DataUtilities.calculateColumnTotal(non2DValues, 0);
	        fail("The expected outcome is IllegalArgumentException");
	    } catch (Exception e) {
	    	assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));	    }
	}
	
	@Test //expected IllegalArgumentException with Invalid string data and Negative column index
	public void testInvalidDataAndNegativeColumnColumnTotal() {
	    DefaultKeyedValues2D invalidValues = new DefaultKeyedValues2D();
	    invalidValues.addValue(3, "Hello", 1);
	    invalidValues.addValue(1, 2, "Hi");
	    
		try {
	        DataUtilities.calculateColumnTotal(invalidValues, -3);
			fail("The expected outcome is IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test //expected IllegalArgumentException with Invalid boolean data and Negative column index
	public void testInvalidDataAndOutofRangeRightColumnColumnTotal() {
	    DefaultKeyedValues2D invalidValues = new DefaultKeyedValues2D();
	    invalidValues.addValue(3, true, 1);
	    invalidValues.addValue(1, 2, false);
	    invalidValues.addValue(0, false, false);

	    try {
	        DataUtilities.calculateColumnTotal(invalidValues, 108);
			fail("The expected outcome is IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	
	
	
	
	//test method2 calculateRowTotal(Values2D data, row)
	
	@Test //expected 1.0 in row index 0
	public void testValidDataAndValidRowTotal() {
	    double result = DataUtilities.calculateRowTotal(values2D, 0);
	    assertEquals("Expected 1.0", 1.0, result, 0.0000001d);
	}
	
	@Test //updated to remove error (lab 3)
	public void testValidDataAndNegativeRowTotal() {
		try {
		    double result = DataUtilities.calculateRowTotal(values2D, -2);
		    assertEquals("Expected 0.0 for invalid row index", 0.0, result, 0.0000001d);
		} catch (Exception e) {
	        fail("Expected 0.0 for invalid row index instead of an exception");
		}
	}
	
	@Test //updated to remove error (lab 3)
	public void testValidDataAndOutofRangeRightRowTotal() {	    
	    try {
	        double result = DataUtilities.calculateRowTotal(values2D, 102); //test out of bound row index
	        assertEquals("Expected 0.0 for invalid row index", 0.0, result, 0.0000001d);
	    } catch (Exception e) {
	        fail("Expected 0.0 for invalid row index instead of an exception");
	    }
	}
	
	@Test //expected IllegalArgumentException with null data and valid row
	public void testNullDataAndValidRowTotal() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("The expected outcome is IllegalArgumentException");
		} 
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));		
		}
	}
	
	@Test //expected IllegalArgumentException with null data and negative row
	public void testNullDataAndNegativeRowTotal() {
		try {
			DataUtilities.calculateRowTotal(null, -100);
			fail("The expected outcome is IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));		
		}
	}
	
	@Test //expected IllegalArgumentException with null data and out of range (right) row
	public void testNullDataAndOutofRangeRightRowTotal() {
		try {
			DataUtilities.calculateRowTotal(null, 1000);
			fail("The expected outcome is IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));		
		}
	}
	
	@Test // new test case 1: testValidRowWithNullValues (lab 3)
	public void testValidRowWithNullValueRowTotal() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();

		data.addValue(1, 0, 0);
		data.addValue(null, 0, 1);
		data.addValue(3, 0, 2);
		
		try {
			DataUtilities.calculateRowTotal(data, 1);
            assertTrue("Expected IllegalArgumentException was not thrown", false);
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test //expected 0.0 with invalid string data and valid row index
	public void testInvalidStringDataAndValidRowTotal() {
		DefaultKeyedValues2D invalidValues = new DefaultKeyedValues2D();
		//invalid data
		invalidValues.addValue(1, 0, 3); 
	    invalidValues.addValue(1, 3, "Hi");
	    invalidValues.addValue(0, "Hello", "Hi");

	    try {
	        DataUtilities.calculateRowTotal(invalidValues, 1);
			fail("The expected outcome is IllegalArgumentException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
	}
	
	@Test //expected 0.0 with invalid non-2D data and negative row index
	public void testInvalidNon2dDataAndNegativeRowTotal() {
		DefaultKeyedValues2D invalidValues = new DefaultKeyedValues2D();
		//invalid data (non-2D)
		invalidValues.addValue(1, 0, 3); 
		
		 try {
		        double result = DataUtilities.calculateRowTotal(invalidValues, -2);
			    assertEquals("Expected 0.0 for invalid data and row index", 0.0, result, 0.0000001d);
			} catch (Exception e) {
				assertTrue("Incorrect exception type thrown", 
						e.getClass().equals(IllegalArgumentException.class));
			}
	}
	
	@Test //expected 0.0 with invalid boolean data and out of range (right) row index
	public void testInvalidBooleanAndOutofRangeRightRowTotal() {
		DefaultKeyedValues2D invalidValues = new DefaultKeyedValues2D();
		//invalid data
		invalidValues.addValue(1, true, false); 
		invalidValues.addValue(2, 2, 3); 
		invalidValues.addValue(4, 5, -10); 

		
		 try {
			 DataUtilities.calculateRowTotal(invalidValues, 10);
			 fail("The expected outcome is IllegalArgumentException");
		 } catch (Exception e) {
			 assertTrue("Incorrect exception type thrown", 
					 e.getClass().equals(IllegalArgumentException.class));
		 }
	}
	
	
	
	
	
	//test method3 createNumberArray(double[] data)
	
	 @Test // Expected: {1.0, 2.0, 3.5, 10.0, -4.0}
	 public void testValidDataCreateNumberArray() {
		 double[] data = {1.0, 2.0, 3.5, 10.0, -4.0};
	     Number[] result = DataUtilities.createNumberArray(data);

	     Number[] expected = {1.0, 2.0, 3.5, 10.0, -4.0};
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //(lab3) test case 1: test with valid values and check if the
	 	   //expected and result data share the same array length
	 	   //and also checks for the values accuracy
	 public void testCase1CreateNumberArray() {
		 double[] data = {1.0, 2.0, 3.0};
	     Number[] result = DataUtilities.createNumberArray(data);
	     assertEquals("Array length should match", data.length, result.length);
	     for (int i = 0; i < data.length; i++) {
	    	 assertEquals("Values should match", data[i], result[i].doubleValue(), 0.0);
	     }
	 }
	 
	 @Test //Expected: {4.9E-324,4.9E-324,4.9E-324}
	 public void testMininumValueDataCreateNumberArray() {
	     double[] data = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};
	     Number[] result = DataUtilities.createNumberArray(data);

	     Number[] expected = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: {1.7976931348623157E308, 1.7976931348623157E308}
	 public void testMaximumValueDataCreateNumberArray() {
	     double[] data = {Double.MAX_VALUE, Double.MAX_VALUE};
	     Number[] result = DataUtilities.createNumberArray(data);

	     Number[] expected = {Double.MAX_VALUE, Double.MAX_VALUE};
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: {-1.7976931348623157E308, -1.7976931348623157E308}
	 public void testOutsideRangeLeftDataCreateNumberArray() {
	     double[] data = {-Double.MAX_VALUE, -Double.MAX_VALUE};
	     Number[] result = DataUtilities.createNumberArray(data);

	     Number[] expected = {-Double.MAX_VALUE, -Double.MAX_VALUE};
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: {}
	 public void testOutsideRangeRightDataCreateNumberArray() {
	     double[] infinityData = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
	     Number[] result = DataUtilities.createNumberArray(infinityData);

	     Number[] expected = {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY};
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: IllegalArgumentException
	 public void testNullDataCreateNumberArray() {
		 double[] data = null;

	     try {
	    	 Number[] result = DataUtilities.createNumberArray(data);
	         fail("Expected IllegalArgumentException");
	     } catch (IllegalArgumentException e) {
	    	 // This is the expected behavior, so the test passes.
	     }
	 }
	 
	 @Test //Expected: {}
	 public void testEmptyDataCreateNumberArray() {
		 double[] data = {}; //empty data 
	     Number[] result = DataUtilities.createNumberArray(data);

		 Number[] expected = {};
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: IllegalArgumentException
	 public void testNonDoubleDataCreateNumberArray() {
		 double[] data = {1, -3, -4, 4};  //invalid non-double values

	     try {
	    	 Number[] result = DataUtilities.createNumberArray(data);
	         fail("Expected IllegalArgumentException");
	     } catch (IllegalArgumentException e) {
	    	 // This is the expected behavior, so the test passes.
	     }
	 }
	 
	 
	 
	 
	 //test method4 createNumberArray2D(double[][] data)
	 
	 @Test //expected the same as validData
	 public void testValidDataCreateNumberArray2D() {
		 double[][] validData = {
				 {1.0, 2.0, 3.0},
				 {4.0, 5.0, 6.0},
				 {7.0, 8.0, 9.0}
				 };

	     Number[][] result = DataUtilities.createNumberArray2D(validData);

	     Number[][] expected = {
	            {1.0, 2.0, 3.0},
	            {4.0, 5.0, 6.0},
	            {7.0, 8.0, 9.0}
	        	};

	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //(lab 3) test case 1: this test if the expected data.length 
	 	   //matches with the result.length and also checks for the values accuracy
	 public void testCase1CreateNumberArray2D() {
		 double[][] data = {
				 {1.0, 2.0, 3.0}, 
				 {4.0, 5.0, 6.0}
				 };
	     Number[][] result = DataUtilities.createNumberArray2D(data);
	     assertEquals("Number of rows should match", data.length, result.length);
	     for (int i = 0; i < data.length; i++) {
	    	 assertEquals("Number of columns should match", data[i].length, result[i].length);
	    	 for (int j = 0; j < data[i].length; j++) {
	    		 assertEquals("Values should match", data[i][j], result[i][j].doubleValue(), 0.0);
	    	 }
	     }
	 }
	 
	 @Test //Expected: {{4.9E-324,4.9E-324,4.9E-324},{4.9E-324,4.9E-324,4.9E-324},{4.9E-324,4.9E-324,4.9E-324}}
	 public void testMininumValueDataCreateNumberArray2D() {
	     double[][] data = {
	    		 {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
	    		 {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
	    		 {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}
	     		 };
	     
	     Number[][] result = DataUtilities.createNumberArray2D(data);

	     Number[][] expected = {
	    		 {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
	    		 {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE},
	    		 {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE}
	     		 };
	     
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: {{1.7976931348623157E308, 1.7976931348623157E308},{1.7976931348623157E308, 1.7976931348623157E308}}
	 public void testMaximumValueDataCreateNumberArray2D() {
	     double[][] maxData = {
	    		 {Double.MAX_VALUE, Double.MAX_VALUE},
	    		 {Double.MAX_VALUE, Double.MAX_VALUE}
	     		 };
	     
	     Number[][] result = DataUtilities.createNumberArray2D(maxData);

	     Number[][] expected = {
	    		 {Double.MAX_VALUE, Double.MAX_VALUE},
	    		 {Double.MAX_VALUE, Double.MAX_VALUE}
	     		 };
	     
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: {{-1.7976931348623157E308, -1.7976931348623157E308}, {-1.7976931348623157E308, -1.7976931348623157E308}}
	 public void testOutsideRangeLeftDataCreateNumberArray2D() {
	     double[][] data = {
	    		 {-Double.MAX_VALUE, -Double.MAX_VALUE},
	    		 {-Double.MAX_VALUE, -Double.MAX_VALUE}
	     		 };
	     
	     Number[][] result = DataUtilities.createNumberArray2D(data);

	     Number[][] expected = {
	    		 {-Double.MAX_VALUE, -Double.MAX_VALUE},
	    		 {-Double.MAX_VALUE, -Double.MAX_VALUE}
	     		 };
	   
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: {{infinity, infinity}, {infinity, infinity}}
	 public void testOutsideRangeRightDataCreateNumberArray2D() {
	     double[][] infinityData = {
	    		 {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
	    		 {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}
	     		 };
	     
	     Number[][] result = DataUtilities.createNumberArray2D(infinityData);

	     Number[][] expected = {
	    		 {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
	    		 {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}
	     		 };
	   
	     assertArrayEquals(expected, result);
	 } 
	 
	 @Test //Expected: {{},{}}
	 public void testEmptyDataCreateNumberArray2D() {
		 double[][] emptyData = {{},{}}; //empty data 
	     Number[][] result = DataUtilities.createNumberArray2D(emptyData);

		 Number[][] expected = {{},{}};
	     assertArrayEquals(expected, result);
	 }
	 
	 @Test //Expected: IllegalArgumentException
	 public void testNullDataCreateNumberArray2D() {
		 double[][] data = null;

	     try {
	    	 Number[][] result = DataUtilities.createNumberArray2D(data);
	         fail("Expected IllegalArgumentException");
	     } catch (IllegalArgumentException e) {
	    	 // This is the expected behavior, so the test passes.
	     }
	 }
	 
	 @Test //Expected: IllegalArgumentException
	 public void testNon2dDataCreateNumberArray2D() {
		 double[][] non2dData = {
				 {1.0, 2.0, 3.0},
				 {1.0, 2.0},
				 {1.0}
		 		 };
		 
		 try {
			 DataUtilities.createNumberArray2D(non2dData);
		     fail("Expected IllegalArgumentException");
		 } catch (IllegalArgumentException e) {
			 // This is the expected behavior, so the test passes.
		 }
	 }
	 
	 @Test //Expected: IllegalArgumentException
	 public void testNonDoubleDataCreateNumberArray2D() {
		 double[][] nonDoubleData = {
				 {1, 2, 3, 4},
				 {5, 6, 7, 8},
				 {9, 10, 11, 12}
		 		 };

	     try {
	    	 Number[][] result = DataUtilities.createNumberArray2D(nonDoubleData);
	         fail("Expected IllegalArgumentException");
	     } catch (IllegalArgumentException e) {
	    	 // This is the expected behavior, so the test passes.
	     }
	 }
	 
	 
	 
	 
	 //test method5 getCumulativePercentages(KeyedValues data)
	 @Test //expected: 1.0
	 public void testValidCumulativePercentages() {
		 DefaultKeyedValues keyvalues = new DefaultKeyedValues();
		 keyvalues.addValue((Comparable) 0.0, 6.0);
		 keyvalues.addValue((Comparable) 1.0, 11.0);
		 keyvalues.addValue((Comparable) 2.0, 3.0);
		 KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		 
		 assertEquals(1.0, (double) object_under_test.getValue(2), 0.000000001d);
	 }
	 
	 @Test //expected NaN
	 public void testMinimumValueCumulativePercentages() {
		 DefaultKeyedValues keyvalues = new DefaultKeyedValues();
		 keyvalues.addValue((Comparable) 0.0, 0.0);
		 keyvalues.addValue((Comparable) 1.0, 0.0);
		 keyvalues.addValue((Comparable) 2.0, 0.0);
		 KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		 
		 double result = (double) object_under_test.getValue(2);
		 
		 if(Double.isNaN(result)) {
			 assertTrue(true); //pass the test, since 0 / 0 is undefined NaN
		 } else {
			 assertEquals(0.0, result, 0.000000001d);
		 }
	 }
	 
	 @Test //expected 0.0
	 public void testNegativeDataCumulativePercentages() {
		 DefaultKeyedValues keyvalues = new DefaultKeyedValues();
		 keyvalues.addValue((Comparable) 0.0, -10);
		 keyvalues.addValue((Comparable) 1.0, -9);
		 keyvalues.addValue((Comparable) 2.0, -2);
		 KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		 
		 assertEquals(0.4, (double) object_under_test.getValue(0), 0.05);
	 }
	 
	 @Test //expected 0.0
	 public void testOutofRangeLeftDataCumulativePercentages() {
		 DefaultKeyedValues keyvalues = new DefaultKeyedValues();
		 keyvalues.addValue((Comparable) 0.0, Double.MIN_VALUE);
		 keyvalues.addValue((Comparable) 1.0, Double.MIN_VALUE);
		 keyvalues.addValue((Comparable) 2.0, Double.MIN_VALUE);
		 KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		 
		 assertEquals(0.0, (double) object_under_test.getValue(1), 0.000000001d);
	 }
	 
	 @Test //expected; NaN
	 public void testOutofRangeRightDataCumulativePercentages() {
		 DefaultKeyedValues keyvalues = new DefaultKeyedValues();
		 keyvalues.addValue((Comparable) 0.0, Double.POSITIVE_INFINITY);
		 keyvalues.addValue((Comparable) 1.0, Double.POSITIVE_INFINITY);
		 keyvalues.addValue((Comparable) 2.0, Double.POSITIVE_INFINITY);
		 KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		 
		 double result = (double) object_under_test.getValue(0);
		 
		 if(Double.isNaN(result)) {
			 assertTrue(true); //pass the test, since 0 / 0 is undefined NaN
		 } else {
			 assertEquals(0.0, result, 0.000000001d);
		 }
	 }
	 
	 @Test //expected NaN
	 public void testMaximumDataCumulativePercentages() {
		 DefaultKeyedValues keyvalues = new DefaultKeyedValues();
		 keyvalues.addValue((Comparable) 0.0, Double.MAX_VALUE);
		 keyvalues.addValue((Comparable) 1.0, Double.MAX_VALUE);
		 keyvalues.addValue((Comparable) 2.0, Double.MAX_VALUE);
		 KeyedValues object_under_test = DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
		 
		 double result = (double) object_under_test.getValue(0);
		 
		 if(Double.isNaN(result)) {
			 assertTrue(true); //pass the test, since 0 / 0 is undefined NaN
		 } else {
			 assertEquals(0.0, result, 0.000000001d);
		 }
	 }
	 
	 @Test //expected: IllegalArgumentException
	 public void testNullCumulativePercentages() {
		 try {
			 DataUtilities.getCumulativePercentages(null);
	         fail("Expected IllegalArgumentException");
	     } catch (IllegalArgumentException e) {
	    	 // This is the expected behavior, so the test passes.
	     }
	 }
	 
	 
	   @Test // test case 1: testDataWithNullValues (lab 3)
	    public void testCase1CumulativePercentages() {
	        DefaultKeyedValues keyvalues = new DefaultKeyedValues();
	        keyvalues.addValue((Comparable) 0.0, null);
	        keyvalues.addValue((Comparable) 1.0, 10);
	        keyvalues.addValue((Comparable) 2.0, null);
	        
	        try {
		        DataUtilities.getCumulativePercentages((KeyedValues) keyvalues);
	            fail("Expected IllegalArgument to be thrown");
	        } catch (IllegalArgumentException e) {
	            
	        }
	    }
}

