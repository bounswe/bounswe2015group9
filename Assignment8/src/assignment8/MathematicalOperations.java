package assignment8;

/**
 *
 * \author Atalay Furkan YIRIK
 * \author Umut UZ
 * \author Melce HUSUNBEYI
 * \author Emrah KUCUK
 * \author Buse BUZ
 * \author Omer Mucahit TEMEL
 * \author Basri YILMAZTURK
 *
 */

/**
 * \details Provides several Mathematical Operations in order to make an efficient test
 * \version 1.0
 */
public class MathematicalOperations {

	/**
	 * takes yth power of x
	 * @param x is the base
	 * @param y is the power
	 * @return X yth power of x
	 */
	public int power(int x, int y) {

		int powx = 1;

		for(int i = 0; i < y; i++) {
			powx *= x;
		}

		return powx;
	}

	/**
	 * divide two numbers
	 * @param x is the dividend
	 * @param y is the divisor
	 * @return X divided by y
	 */
	public int division(int x, int y) {

		return x / y;
	}

	/**
	 * add two numbers
	 * @param x is the number1
	 * @param y is the number2
	 * @return X plus y
	 */

	public int addition(int x, int y) {
		return x + y;
	}
	
	/**
	 * subtract two numbers
	 * @param x is the number1
	 * @param y is the number2
	 * @return X minus y
	 */

	public int subtraction(int x, int y) {
		return x - y;
	}

	/**
	 * Multiply two numbers
	 * @param x is the number1
	 * @param y is the number2
	 * @return X minus y
	 */

	public int multiplication(int x, int y) {
		return x * y;
	}	
	/**
	 * Remainder of two numbers
	 * @param x is the dividend
	 * @param y is the divisor
	 * @return X mod y
	 */

	public int remainder(int x, int y) {
		return x % y;
	}	
	/**
	 * Inverse of the parameter's boolean value
	 * @param x is to be negated
	 */
	public boolean negation(boolean x) {
		return !x;
	}	
	

}