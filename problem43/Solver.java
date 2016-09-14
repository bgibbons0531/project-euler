/**
*	@file Solver.java
*	@author Brad Gibbons
*	@version 1.0, 13 Sep 2016
*	Purpose: To find the sum of all 0 through 9 pandigital numbers with the following property:
*		d2d3d4 is divisible by 2
*		d3d4d5 is divisible by 3
*		d4d5d6 is divisible by 5
*		d5d6d7 is divisible by 7
*		d6d7d8 is divisible by 11
*		d7d8d9 is divisible by 13
*		d8d9d10 is divisible by 17
*/

public class Solver {
	/**
	 *	Main method to solve the problem.
	 *	@param args 	List of arguments passed into the program
	 */
	public static void main(String[] args) {
		//Declaration
		int sum = 0; //Counter to keep track of the sum
		char[] digits = {'0','1','2','3','4','5','6','7','8','9'}; //List of digits to be used in the number
		char[][] triplets = getTriplets(digits);
	}

	/**
	 *	Creates a list of all possible triplets for the given list.
	 *	@param	list 	A list of characters.
	 *	@return	An array of all triplets possible for the given list
	 */
	private static char[][] getTriplets(char[] list) {
		//Determine how many triplets there will be
		int n = list.length;
		int r = 3;
		int numCombinations = factorial(n)/factorial(n-r);
		char[][] triplets = new char[numCombinations][3];

		//Get triples
		int counter = 0;
		for (int digit1=0; digit1<list.length; digit1++) {
			for (int digit2=0; digit2<list.length; digit2++) {
				for (int digit3=0; digit3<list.length; digit3++) {
					if (digit1 != digit2 && digit2 != digit3 && digit3 != digit1) {
						triplets[counter][0] = list[digit1];
						triplets[counter][1] = list[digit2];
						triplets[counter][2] = list[digit3];
						counter++;
					}
				}
			}
		}
		return(triplets);
	}

	/**
	 *	Find the factorial of a number
	 *	@param	x	An integer to find the factorial
	 *	@return	An integer that is a factorial of x
	 */
	private static int factorial(int x) {
		int product = 1;
		int i = 1;
		while (i <= x) {
			product *= i;
			i++;
		}
		return(product);
	}

	/**
	 *	Convert a character to an int.
	 *	@param	c 	A character to be converted into an integer
	 *	@return	The integer conversion of character c
	 */
	private static int toInt(char c) {
		if (c == '0') { return(0); }
		else if (c == '1') { return(1); }
		else if (c == '2') { return(2); }
		else if (c == '3') { return(3); }
		else if (c == '4') { return(4); }
		else if (c == '5') { return(5); }
		else if (c == '6') { return(6); }
		else if (c == '7') { return(7); }
		else if (c == '8') { return(8); }
		else { return(9); }
	}

	/**
	 *	Convert a string into a number
	 *	@param	str 	A string representing a number
	 *	@return	An int representation of the number passed in.
	 */
	private static int toNumber(String str) {
		int number = 0;
		int multiplier = 1;
		int digit = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			number += toInt(str.charAt(digit)) * multiplier;
			multiplier *= 10;
			digit--;
		}
		return(number);
	}
}