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
	
	@Test
	public void testSubtract() {

		MathematicalOperations test = new MathematicalOperations();
		assertEquals("15 - 4  must be 11", 11, test.subtraction(15, 4));

		MathematicalOperations test2 = new MathematicalOperations();
		assertEquals("0 - 3 must be -3", -3, test2.subtraction(0, 3));
		
		MathematicalOperations test3 = new MathematicalOperations();
		assertEquals("2 - (-8) must be 10", 10, test3.subtraction(2, -8));
		
		

	}

	@Test
	public void testMultiply() {

		MathematicalOperations test = new MathematicalOperations();
		assertEquals("15 * 4  must be 60", 60, test.multiplication(15, 4));

		MathematicalOperations test2 = new MathematicalOperations();
		assertEquals("0 * 3 must be 0", 0, test2.multiplication(0, 3));
		
		MathematicalOperations test3 = new MathematicalOperations();
		assertEquals("2 * (-8) must be minus 16", -16, test3.multiplication(2, -8));

	}
	@Test
	public void testRemainder(){

		MathematicalOperations test = new MathematicalOperations();
		assertEquals("7 % 9 must be 7", 7, test.remainder(7,9));

		MathematicalOperations test = new MathematicalOperations();
		assertEquals("-4 % 5 must be -4", -4, test2.remainder(-4,5));

		MathematicalOperations test = new MathematicalOperations();
		assertEquals("0 % 4 must be 0", 0, test3.remainder(0,4));

	}

	@Test
	public void testPower(){

		MathematicalOperations mockObject = new MathematicalOperations();
		assertEquals("0 ^ 5 must be 0", 0, test.power(0,5));
		
		assertEquals("0 ^ 0 must be 1", 1, test.power(0,0));

		assertEquals("9 ^ 0 must be 0", 1, test.power(9,0));

		assertEquals("9 ^ 1 must be 9", 9, test.power(9,1));

		assertEquals("2 ^ 2 must be 4", 4, test.power(2,2));

	}	
	@Test
	public void testNegation(){

		MathematicalOperations test = new MathematicalOperations();
		assertEquals("negation of true must be false", false, test.negation(true));
		assertEquals("negation of false must be true", true, test.negation(false));
		
	}

}
