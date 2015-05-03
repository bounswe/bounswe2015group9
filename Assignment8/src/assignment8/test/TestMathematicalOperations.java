package assignment8.test;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment8.MathematicalOperations;

/**
 * 
 */

/**
 *Test for MathematicalOperations Class
 */
public class TestMathematicalOperations {
	
	/**
	 * to test dividing by zero throw arithmetic exception
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivideByZero() {
		MathematicalOperations tester = new MathematicalOperations();
		tester.division(1000, 0);
	}
	
	/**
	 * to test general attitude of division
	 */
	@Test
	public void testDivide() {
		MathematicalOperations tester = new MathematicalOperations();
		assertEquals("10 / 5 must be 2", 2, tester.division(10, 5));
	}
}
