package org.jfree.data.test;

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

	@Before
	public void setUp() throws Exception {
		
		rangeObjectUnderTest = new Range(5, 10); 
		negativeRangeObjectUnderTest = new Range(-10, -5); 
	
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	// Test methods for intersects(double lower, double upper)
	
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
}
