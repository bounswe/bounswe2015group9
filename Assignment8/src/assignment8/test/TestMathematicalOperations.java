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

	@Test

	public void testAdd() {

		MathematicalOperations tester = new MathematicalOperations();
		assertEquals("3 + 5 must be 8", 8, tester.addition(3, 5));

		MathematicalOperations tester1 = new MathematicalOperations();
		assertEquals("0 + 4 must be 4", 4, tester1.addition(0, 4));

	}
}
