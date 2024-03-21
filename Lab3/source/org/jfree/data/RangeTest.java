package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
	
	private Range rangeObjectUnderTest;
	private Range negativeRangeObjectUnderTest;
	private Range customRangeObjectUnderTest;
	private Range range1;
	private Range range2;
	private Range expectedRange;


	@Before
	public void setUp() throws Exception {
		
		rangeObjectUnderTest = new Range(5, 10); 
		negativeRangeObjectUnderTest = new Range(-10, -5); 
	
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	// Test methods for intersects(double lower, double upper)
	
	@Test
	public void testIntersectsLowerGreaterThanUpper() { 
		customRangeObjectUnderTest = new Range(1,10);
		assertFalse("Should return false", customRangeObjectUnderTest.intersects(15, 9));
	}
	
	@Test
	public void testIntersectsBothRightOfRangeAndEqual() { 
		customRangeObjectUnderTest = new Range(1,10);
		assertFalse("Should return false", customRangeObjectUnderTest.intersects(15, 15));
	}
	
	// with positives (5, 10)
	@Test
	public void testIntersectsBothLeftOfRangeReturnsFalse() { 
		assertFalse("Should return false", rangeObjectUnderTest.intersects(0, 3));
	}
	
	@Test
	public void testIntersectsLowerLeftOfRangeUpperLeftBoundaryReturnsTrue() { 
		// Boundary Assumption
		assertTrue("Should return true", rangeObjectUnderTest.intersects(1, 5));
	}
	
	@Test
	public void testIntersectsLowerLeftOfRangeUpperInRangeReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(1, 7));
	}

	@Test
	public void testIntersectsLowerLeftOfRangeUpperRightBoundaryReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(1, 10));
	}
	
	@Test
	public void testIntersectsLowerLeftOfRangeUpperRightOfRangeReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(1, 12));
	}
	
	@Test
	public void testIntersectsBothLowerBoundaryReturnsTrue() { 
		// Boundary Assumption
		assertTrue("Should return true", rangeObjectUnderTest.intersects(5, 5));
	}
	
	@Test
	public void testIntersectsLowerLeftBoundaryUpperInRangeReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(5, 7));
	}
	
	@Test
	public void testIntersectsLowerLeftBoundaryUpperRightBoundaryReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(5, 10));
	}
	
	@Test
	public void testIntersectsLowerLeftBoundaryUpperRightOfRangeReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(5, 13));
	}
	
	@Test
	public void testIntersectsBothInRangeReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(7, 9));
	}
	
	@Test
	public void testIntersectsLowerInRangeUpperRightBoundaryReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(7, 10));
	}
	
	@Test
	public void testIntersectsLowerInRangeUpperRightOfRangeReturnsTrue() { 
		assertTrue("Should return true", rangeObjectUnderTest.intersects(7, 13));
	}
	
	@Test
	public void testIntersectsBothRightBoundaryReturnsTrue() { 
		// Boundary Assumption
		assertTrue("Should return true", rangeObjectUnderTest.intersects(10, 10));
	}
	
	@Test
	public void testIntersectsLowerRightBoundaryUpperRightOfRangeReturnsTrue() { 
		// Boundary Assumption
		assertTrue("Should return true", rangeObjectUnderTest.intersects(10, 14));
	}
	
	@Test
	public void testIntersectsBothRightOfRangeReturnsFalse() { 
		assertFalse("Should return false", rangeObjectUnderTest.intersects(13, 15));
	}
	
	// with negatives (-10, -5)
	@Test
	public void testIntersectsBothLeftOfRangeNegativesReturnsFalse() { 
		assertFalse("Should return false", negativeRangeObjectUnderTest.intersects(-15, -13));
	}
	
	@Test
	public void testIntersectsLowerLeftOfRangeUpperInRangeNegativesReturnsTrue() { 
		assertTrue("Should return true", negativeRangeObjectUnderTest.intersects(-15, -7));
	}
	
	@Test
	public void testIntersectsBothInRangeNegativesReturnsTrue() { 
		assertTrue("Should return true", negativeRangeObjectUnderTest.intersects(-9, -6));
	}

	@Test
	public void testIntersectsLowerInRangeUpperRightOfRangeNegativesReturnsTrue() { 
		assertTrue("Should return true", negativeRangeObjectUnderTest.intersects(-9, -3));
	}
	
	@Test
	public void testIntersectsBothRightOfRangeNegativesReturnsFalse() { 
		assertFalse("Should return false", negativeRangeObjectUnderTest.intersects(-4, -2));
	}
		
	
	// Test methods for getLowerBound()
	
	@Test
	public void testLowerBoundTwoNegatives() { 
		customRangeObjectUnderTest = new Range(-5,-1);
		assertEquals("The lower bound should be -5",
				-5, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundOneNegativeOneZero() { 
		customRangeObjectUnderTest = new Range(-5,0);
		assertEquals("The lower bound should be -5",
				-5, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundOneNegativeOnePositive() { 
		customRangeObjectUnderTest = new Range(-5,1);
		assertEquals("The lower bound should be -5",
				-5, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundTwoZeros() { 
		customRangeObjectUnderTest = new Range(0,0);
		assertEquals("The lower bound should be 0",
				0, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundOneZeroOnePositive() { 
		customRangeObjectUnderTest = new Range(0,5);
		assertEquals("The lower bound should be 0",
				0, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundTwoPositives() { 
		customRangeObjectUnderTest = new Range(5,15);
		assertEquals("The lower bound should be 5",
				5, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundEqualPositives() { 
		customRangeObjectUnderTest = new Range(5,5);
		assertEquals("The lower bound should be 5",
				5, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	@Test
	public void testLowerBoundEqualNegatives() { 
		customRangeObjectUnderTest = new Range(-5,-5);
		assertEquals("The lower bound should be -5",
				-5, customRangeObjectUnderTest.getLowerBound(), 0.000000001d);
	}
	
	
	// Test methods for getUpperBound()
	
	@Test
	public void testUpperBoundTwoNegatives() { 
		customRangeObjectUnderTest = new Range(-5,-1);
		assertEquals("The upper bound should be -1",
				-1, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundOneNegativeOneZero() { 
		customRangeObjectUnderTest = new Range(-5,0);
		assertEquals("The upper bound should be 0",
				0, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundOneNegativeOnePositive() { 
		customRangeObjectUnderTest = new Range(-5,1);
		assertEquals("The upper bound should be 1",
				1, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundTwoZeros() { 
		customRangeObjectUnderTest = new Range(0,0);
		assertEquals("The upper bound should be 0",
				0, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundOneZeroOnePositive() { 
		customRangeObjectUnderTest = new Range(0,5);
		assertEquals("The upper bound should be 5",
				5, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundTwoPositives() { 
		customRangeObjectUnderTest = new Range(5,15);
		assertEquals("The upper bound should be 15",
				15, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundEqualPositives() { 
		customRangeObjectUnderTest = new Range(5,5);
		assertEquals("The upper bound should be 5",
				5, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	@Test
	public void testUpperBoundEqualNegatives() { 
		customRangeObjectUnderTest = new Range(-5,-5);
		assertEquals("The upper bound should be -5",
				-5, customRangeObjectUnderTest.getUpperBound(), 0.000000001d);
	}
	
	
	// Test methods for getCentralValues()
	
	@Test
	public void testCentralValueShouldBeZero() { 
		customRangeObjectUnderTest = new Range(-1,1);
		assertEquals("The central value of -1 and 1 should be 0",
				0, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueEqualValues() { 
		customRangeObjectUnderTest = new Range(3,3);
		assertEquals("The central value of 3 and 3 should be 3",
				3, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueTwoPositives() { 
		customRangeObjectUnderTest = new Range(3,5);
		assertEquals("The central value of 3 and 5 should be 4",
				4, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueNegativeValues() { 
		customRangeObjectUnderTest = new Range(-5,-3);
		assertEquals("The central value of -5 and -3 should be -4",
				-4, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueOneNegativeOneZero() { 
		customRangeObjectUnderTest = new Range(-5,0);
		assertEquals("The central value of -5 and 0 should be -2.5",
				-2.5, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueOneNegativeOnePositive() { 
		customRangeObjectUnderTest = new Range(-5,2);
		assertEquals("The central value of -5 and 2 should be -1.5",
				-1.5, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueBothZero() { 
		customRangeObjectUnderTest = new Range(0,0);
		assertEquals("The central value of 0 and 0 should be 0",
				0, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueOneZeroOnePositive() { 
		customRangeObjectUnderTest = new Range(0,5);
		assertEquals("The central value of 0 and 5 should be 2.5",
				2.5, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	@Test
	public void testCentralValueEqualNegativeValues() { 
		customRangeObjectUnderTest = new Range(-3,-3);
		assertEquals("The central value of -3 and -3 should be -3",
				-3, customRangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
	
	
	// Test methods for constrain(double value)
	
	// Using (5, 10) by default
	@Test
	public void testConstrainMatchesLowerRange() { 
		assertEquals("The constrain value should be 5",
				5, rangeObjectUnderTest.constrain(4), 0.000000001d);
	}
	
	@Test
	public void testConstrainMatchesUpperRange() { 
		assertEquals("The constrain value should be 10",
				10, rangeObjectUnderTest.constrain(12), 0.000000001d);
	}
	
	@Test
	public void testConstrainWithinRange() { 
		assertEquals("Should return input value (7)",
				7, rangeObjectUnderTest.constrain(7), 0.000000001d);
	}
	
	
	@Test
	public void testConstrainLowerBoundary() { 
		assertEquals("The constrain value should be 5",
				5, rangeObjectUnderTest.constrain(5), 0.000000001d);
	}
	
	@Test
	public void testConstrainUpperBoundary() { 
		assertEquals("The constrain value should be 10",
				10, rangeObjectUnderTest.constrain(10), 0.000000001d);
	}
	
	// Negatives using (-10, -5)
	@Test
	public void testConstrainMatchesLowerRangeNegative() { 
		assertEquals("The constrain value should be -10",
				-10, negativeRangeObjectUnderTest.constrain(-11), 0.000000001d);
	}
	
	@Test
	public void testConstrainMatchesUpperRangeNegative() { 
		assertEquals("The constrain value should be -5",
				-5, negativeRangeObjectUnderTest.constrain(-4), 0.000000001d);
	}
	
	@Test
	public void testConstrainWithinRangeNegative() { 
		assertEquals("Should return input value (-7)",
				-7, negativeRangeObjectUnderTest.constrain(-7), 0.000000001d);
	}
	
	@Test
	public void testConstrainNegativeLowerBoundary() { 
		assertEquals("The constrain value should be -10",
				-10, negativeRangeObjectUnderTest.constrain(-10), 0.000000001d);
	}
	
	@Test
	public void testConstrainNegativeUpperBoundary() { 
		assertEquals("The constrain value should be -5",
				-5, negativeRangeObjectUnderTest.constrain(-5), 0.000000001d);
	}
	

	// Test methods for combine(Range range1, Range range2)
	
	@Test
	public void testCombineBothValidRanges() { 
		range1 = new Range(10,20);
		range2 = new Range(30,40);
		expectedRange = new Range(10,40);


		assertEquals("The combined range of (10,20) and (30,40) should be (10,40)",
				expectedRange, Range.combine(range1, range2));
	}
	
	@Test
	public void testCombineRange1Null() { 
		range1 = null;
		range2 = new Range(30,40);
		expectedRange = new Range(10,40);


		assertEquals("The combined range of null and (30,40) should be (30,40)",
				range2, Range.combine(range1, range2));
	}
	
	@Test
	public void testCombineRange2Null() { 
		range1 = new Range(30,40);
		range2 = null;
		expectedRange = new Range(10,40);


		assertEquals("The combined range of (30,40) and null should be (30,40)",
				range1, Range.combine(range1, range2));
	}
	
	
	// Test methods for expand(Range range, double lowerMargin, double upperMargin)
	
	@Test
	public void testExpandValidRange() { 
		range1 = new Range(12,20);
		double lowerMargin = 0.25;
		double upperMargin = 0.5;
		expectedRange = new Range(10,24);


		assertEquals("The range of (12,20) with lower and upper margins 0.25 and 0.5 should return (10,24)",
				expectedRange, Range.expand(range1, lowerMargin, upperMargin));
	}
	
	@Test
	public void testExpandNullRange() { 
		range1 = null;
		double lowerMargin = 0.25;
		double upperMargin = 0.5;
		expectedRange = new Range(10,24);
		 
		try {
			Range.expand(range1, lowerMargin, upperMargin);
			fail("Should throw an IllegalArgumentException");
		} 
		catch (IllegalArgumentException e) {
			assertTrue("Exception thrown", 
					e.getClass().equals(IllegalArgumentException.class));		}
	}
	
	
	// Test methods for expandToInclude(Range range, double value)

	@Test
	public void testExpandToIncludeNullRange() { 
		range1 = null;
		double value = 1;
		expectedRange = new Range(1,1);


		assertEquals("The range null with with value 1 returns the range (1,1)",
				expectedRange, Range.expandToInclude(range1, value));
	}
	
	@Test
	public void testExpandToIncludeValueLessThanLowerBound() { 
		range1 = new Range(10,20);
		double value = 1;
		expectedRange = new Range(1,20);


		assertEquals("The range (10,20) with with value 1 returns the range (1,20)",
				expectedRange, Range.expandToInclude(range1, value));
	}
	
	@Test
	public void testExpandToIncludeValueMoreThanUpperBound() { 
		range1 = new Range(10,20);
		double value = 21;
		expectedRange = new Range(10,21);


		assertEquals("The range (10,20) with with value 21 returns the range (10,21)",
				expectedRange, Range.expandToInclude(range1, value));
	}
	
	@Test
	public void testExpandToIncludeValueInRange() { 
		range1 = new Range(10,20);
		double value = 15;
		expectedRange = new Range(10,20);


		assertEquals("The range (10,20) with with value 15 returns the range (10,20)",
				expectedRange, Range.expandToInclude(range1, value));
	}
	
	// Test methods for Range(double lower, double upper)

	@Test
	public void testRangeLowerMoreThanUpper() { 
		double lower = 10;
		double upper = 5;
		 
		try {
			range1 = new Range(lower, upper);
			fail("Should throw an IllegalArgumentException");
		} 
		catch (IllegalArgumentException e) {
			assertTrue("Exception thrown", 
					e.getClass().equals(IllegalArgumentException.class));		}
	}
	
	
	// Test methods for shift(Range base, double delta, boolean allowZeroCrossing)
	
	@Test
	public void testShiftAllowZeroCrossingTrue() { 
		range1 = new Range(10,20);
		double delta = 5;
		boolean allowZeroCrossing = true;
		expectedRange = new Range(15,25);


		assertEquals("The range (10,20) with with delta 5 returns the range (15,25)",
				expectedRange, Range.shift(range1, delta, allowZeroCrossing));
	}
	
	@Test
	public void testShiftAllowZeroCrossingFalse() { 
		range1 = new Range(10,20);
		double delta = 5;
		boolean allowZeroCrossing = false;
		expectedRange = new Range(15,25);


		assertEquals("The range (10,20) with with value 5 returns the range (15,25)",
				expectedRange, Range.shift(range1, delta, allowZeroCrossing));
	}
	
	
	// Test methods for shiftWithNoZeroCrossing(double value, double delta)
	// Doing this through use of the shift method as shiftWithNoZeroCrossing is private

	// This one tests 2 branches of the shiftWithNoZeroCrossing method at once
	@Test
	public void testShiftWithNoZeroCrossingWithNegativeAndZeroValues() { 
		range1 = new Range(-2,0);
		double delta = 5;
		expectedRange = new Range(0,0);

		// Not specifying the allowZeroCrossing boolean to trigger line coverage of the 
		// shift(Range base, double delta) method
		// Will be false by default
		assertEquals("The range (-2,0) with delta 5 returns the range (0,0)",
				expectedRange, Range.shift(range1, delta));
	}
	
	
	// Test methods for equals(Object obj)

	@Test
	public void testEqualsDifferentLowerValues() { 
        range1 = new Range(1, 5);
        range2 = new Range(2, 5);


		assertFalse("A non Range object returns false", range1.equals(range2));
	}
	

	
	
	// test method for range.combine() (lab 3 - mutation testing) by Ho Yan Chew
	
		@Test //expected (0,8)
		public void testCombineBothValidRange() {
		    Range range1 = new Range(0, 5);
		    Range range2 = new Range(3, 8);
		    try {
			    Range combinedRange = Range.combine(range1, range2);
			    assertEquals(0, combinedRange.getLowerBound(), 0.0001);
			    assertEquals(8, combinedRange.getUpperBound(), 0.0001);
		    } catch (Exception e) {
		    	fail("Expected to return (0,8)");
		    }
		}
		
		@Test  //expected (-40, 13)
		public void testCombineRange1NegativeRange() {
		    Range range1 = new Range(-40, -15);
		    Range range2 = new Range(1,13);
		    try {
			    Range combinedRange = Range.combine(range1, range2);
			    assertEquals(-40, combinedRange.getLowerBound(), 0.0001);
			    assertEquals(13, combinedRange.getUpperBound(), 0.0001);
		    } catch (Exception e) {
		    	fail("Expected to return (-40,13)");
		    }
		}
		
		@Test //expected (-10, 15)
		public void testCombineRange2NegativeRange() {
		    Range range1 = new Range(1, 15);
		    Range range2 = new Range(-10,-2);
		    try {
			    Range combinedRange = Range.combine(range1, range2);
			    assertEquals(-10, combinedRange.getLowerBound(), 0.0001);
			    assertEquals(15, combinedRange.getUpperBound(), 0.0001);
		    } catch (Exception e) {
		    	fail("Expected to return (-10,15)");
		    }
		}
		
		@Test //expected (-10, -1)
		public void testCombineBothNegativeRange() {
		    Range range1 = new Range(-10, -2);
		    Range range2 = new Range(-5,-1);
		    try {
			    Range combinedRange = Range.combine(range1, range2);
			    assertEquals(-10, combinedRange.getLowerBound(), 0.0001);
			    assertEquals(-1, combinedRange.getUpperBound(), 0.0001);
		    } catch (Exception e) {
		    	fail("Expected to return (-10,-1)");
		    }
		}
		
		@Test //expected (2, 12)
		public void testCombineSameRange() {
		    Range range1 = new Range(2, 12);
		    Range range2 = new Range(2,12);
		    try {
		    	Range combinedRange = Range.combine(range1, range2);
			    assertEquals(2, combinedRange.getLowerBound(), 0.0001);
			    assertEquals(12, combinedRange.getUpperBound(), 0.0001);
		    } catch (Exception e) {
		    	fail("Expected to return (2, 12)");
		    }
		}
		
		@Test //the second range should return
		public void testCombineFirstRangeIsNull() {
		    Range range1 = null;
		    Range range2 = new Range(3, 8);
		    try {
			    Range combinedRange = Range.combine(range1, range2);
			    assertEquals(3, combinedRange.getLowerBound(), 0.0001);
			    assertEquals(8, combinedRange.getUpperBound(), 0.0001);
		    } catch (Exception e) {
		    	fail("Expected to return range2");
		    }
		}
		
		// this test case will be commented out for mutation testing due to failure
		@Test //the first range should return (hold... has error in source code)
		public void testCombineSecondRangeIsNull() {
		    Range range1 = new Range(2, 5);
		    Range range2 = null;
		    
		    try {
		        Range combinedRange = Range.combine(range1, range2);
		        assertEquals(2, combinedRange.getLowerBound(), 0.0001);
			    assertEquals(5, combinedRange.getUpperBound(), 0.0001);
		    } catch (Exception e) {
		    	fail("Exception should not be thrown, expected to return range1");
		    }
		}
		
		@Test //expected to return null
		public void testCombineBothNull() {
			 Range range1 = null;
			 Range range2 = null;
			 Range combinedRange = Range.combine(range1, range2);
			 
			 assertEquals(null, combinedRange);
		}
}