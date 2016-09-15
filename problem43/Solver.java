/**
 * Purpose: To find the sum of all 0 through 9 pandigital numbers with the following property:
 *  d2d3d4 is divisible by 2
 *  d3d4d5 is divisible by 3
 *  d4d5d6 is divisible by 5
 *  d5d6d7 is divisible by 7
 *  d6d7d8 is divisible by 11
 *  d7d8d9 is divisible by 13
 *  d8d9d10 is divisible by 17.
 */

import java.math.*;
import java.util.*;

/**
 * Solver object used to find the solution.
 * @author Brad Gibbons
 * @version 1.0, 15 Sep 2016
 */
public class Solver {
	/**
	 * Main method to solve the problem.
	 * @param args List of arguments passed into the program.
	 */
	public static void main(String[] args) {
		//Declaration
		BigInteger sum = new BigInteger("0"); //Counter to keep track of the sum
		List<char[]> numList = new ArrayList<char[]>();
		int index1 = 0; //Integer to be used for index of arrays in the solver
		int index2 = 0; //Integer to be used for the index of array in the solver
		String temp = ""; //Temp string

		//Get the numbers that fit the requirement

		//Get remaining digits
		char[] digits1 = {'0','1','2','3','4','5','6','7','8','9'}; //List of digits to be used in the number

		//Get triplets
		char[][] triplets1 = getTriplets(digits1);
		for (int d2d3d4=0; d2d3d4<triplets1.length; d2d3d4++) { //Cycle through d2d3d4 block

			//Check triplet
			char[] triplet1 = triplets1[d2d3d4];
			temp = triplet1[0] + "" + triplet1[1] + "" + triplet1[2];
			if (toNumber(temp) % 2 == 0) { //If divisible by 2

				//Get remaining digits minus the first thre
				char[] digits2 = getDigits(triplet1, digits1);

				//Get triplets
				char[][] triplets2 = getTriplets(triplet1[1],triplet1[2], digits2);
				for (int d3d4d5=0; d3d4d5<digits2.length; d3d4d5++) { //Cycle through d3d4d5 block

					//Check triplet
					char[] triplet2 = triplets2[d3d4d5];
					temp = triplet2[0] + "" + triplet2[1] + "" + triplet2[2];
					if (toNumber(temp) % 3 == 0) { //If divisible by 3

						//Get remaining digits
						char[] digits3 = getDigits(triplet2, digits2);

						//Get triplets
						char[][] triplets3 = getTriplets(triplet2[1],triplet2[2], digits3);
						for (int d4d5d6=0; d4d5d6<digits3.length; d4d5d6++) { //Cycle through d4d5d6 block

							//Check triplet
							char[] triplet3 = triplets3[d4d5d6];
							temp = triplet3[0] + "" + triplet3[1] + "" + triplet3[2];
							if (toNumber(temp) % 5 == 0) { //If divisible by 5
								
								//Get remaining digits
								char[] digits4 = getDigits(triplet3, digits3);

								//Get triplets
								char[][] triplets4 = getTriplets(triplet3[1],triplet3[2],digits4);
								for (int d5d6d7=0; d5d6d7<digits4.length; d5d6d7++) { //Cycle through d5d6d7 block

									//Check triplet
									char[] triplet4 = triplets4[d5d6d7];
									temp = triplet4[0] + "" + triplet4[1] + "" + triplet4[2];
									if (toNumber(temp) % 7 == 0) { //If divisible by 7

										//Get remaining digits
										char[] digits5 = getDigits(triplet4, digits4);

										//Get triplets
										char[][] triplets5 = getTriplets(triplet4[1],triplet4[2],digits5);
										for (int d6d7d8=0; d6d7d8<digits5.length; d6d7d8++) {

											//Check triplet
											char[] triplet5 = triplets5[d6d7d8];
											temp = triplet5[0] + "" + triplet5[1] + "" + triplet5[2];
											if (toNumber(temp) % 11 == 0) { //If divisible by 11
												
												//Get remaining digits
												char[] digits6 = getDigits(triplet5, digits5);

												//Get triplets
												char[][] triplets6 = getTriplets(triplet5[1],triplet5[2],digits6);
												for (int d7d8d9=0; d7d8d9<digits6.length; d7d8d9++) { //Cycle through d7d8d9 block

													//Check triplet
													char[] triplet6 = triplets6[d7d8d9];
													temp = triplet6[0] + "" + triplet6[1] + "" + triplet6[2];
													if (toNumber(temp) % 13 == 0) { //If divisible by 13

														//Get remaining digits
														char[] digits7 = getDigits(triplet6, digits6);

														//Get triplets
														char[][] triplets7 = getTriplets(triplet6[1],triplet6[2],digits7);
														for (int d8d9d10=0; d8d9d10<digits7.length; d8d9d10++) { //Cycle through d8d9d10 block

															//Check triplet
															char[] triplet7 = triplets7[d8d9d10];
															temp = triplet7[0] + "" + triplet7[1] + "" + triplet7[2];
															if (toNumber(temp) % 17 == 0) { //If divisible by 17
																//Add number to list as a character array
																char[] num = new char[10];
																num[1] = triplet1[0];
																num[2] = triplet2[0];
																num[3] = triplet3[0];
																num[4] = triplet4[0];
																num[5] = triplet5[0];
																num[6] = triplet6[0];
																num[7] = triplet7[0];
																num[8] = triplet7[1];
																num[9] = triplet7[2];
																numList.add(num);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		//Determine the first digit of each num
		for (int i=0; i<numList.size(); i++) { //Cycle through each num
			char[] currentNum = numList.get(i);
			boolean isFound = false;
			for (int j=0; j<digits1.length; j++) { //Cycle through possible digits
				isFound = false;
				for (int k=1; k<currentNum.length; k++) { //Cycle through current num
					if (digits1[j] == currentNum[k]) { //If digit is in the number already
						isFound = true;
					}
				}
				if (!isFound) {
					currentNum[0] = digits1[j];
				}
			}
		}

		//Convert each char arr to a string and then to number and add to the sum
		for (int i=0; i<numList.size(); i++) {
			char[] currentNum = numList.get(i);
			String currentNumString = "";
			for (int j=0; j<10; j++) {
				currentNumString += currentNum[j];
			}
			BigInteger additive = new BigInteger(currentNumString);
			sum = sum.add(additive);
		}

		//Print solution
		System.out.println(sum);
	}
	
	/**
	 * Remove the characters that appear in the triplet from the list of digits.
	 * @param triplet      A triplet of three characters to be removed from digits_in.
	 * @param digits_in    An array of characters to be altered.
	 * @return An array of the characters of digits_in without the characters that appear in triplet.
	 */
	private static char[] getDigits(char[] triplet, char[] digits_in) {
		char[] digits_out = {};
		if (digits_in.length!=10) {
			digits_out = new char[digits_in.length-1];
		} else {
			digits_out = new char[digits_in.length-3];
		}
		int index1 = 0;
		int index2 = 0;
		while (index1<digits_in.length && index2 < digits_out.length) {
			if (digits_in[index1] != triplet[0] && digits_in[index1] != triplet[1] && digits_in[index1] !=  triplet[2]) {
				digits_out[index2] = digits_in[index1];
				index2++;
			}
			index1++;
		}
		return(digits_out);
	}

	/**
	 * Return a list of triplets based on the inputs.
	 * @param a     A character to be the first entry of the triplet.
	 * @param b     A character to be the second entry of the triplet.
	 * @param list  A list of characters to be the third entry in each list.
	 * @return An array of triplets of size three with characters.
	 */
	private static char[][] getTriplets(char a, char b, char[] list) {
		int n = list.length;
		char[][] triplets = new char[n][3];
		for (int i=0; i<n; i++) {
			triplets[i][0] = a;
			triplets[i][1] = b;
			triplets[i][2] = list[i];
		}
		return (triplets);
	}

	/**
	 * Creates a list of all possible triplets for the given list.
	 * @param list A list of characters.
	 * @return An array of all triplets possible for the given list.
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
	 * Find the factorial of a number.
	 * @param x    An integer to find the factorial.
	 * @return An integer that is a factorial of x.
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
	 * Convert a character to an int.
	 * @param c    A character to be converted into an integer.
	 * @return The integer conversion of character c.
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
	 * Convert a string into a number.
	 * @param str  A string representing a number.
	 * @return An int representation of the number passed in.
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
