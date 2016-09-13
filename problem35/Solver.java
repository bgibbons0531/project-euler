/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the number of circular primes below 1 million.
*/

import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final double LIMIT = 1000000;
		final int DIGIT_TOTAL = (int)Math.log10(LIMIT);
		boolean allPrime = true;
		boolean containsZero;
		int counter = 0;
		int digitCount = 0;
		int[] digit = new int[DIGIT_TOTAL];
		String currentVariant;
		String currentVariantNoZeros;
		String[] variant = new String[DIGIT_TOTAL];
		String[] variantNoZeros = new String [DIGIT_TOTAL];
		String currentNumberString;
		List<Integer> primeNumberList = new ArrayList<Integer>();
		
		//Fill list with prime numbers
		for (int i = 2; i < LIMIT; i++) {
			if (isPrime(i)) {
				primeNumberList.add(i);
			}
		}
		
		//Solve
		for (int num = 0; num < primeNumberList.size(); num++) { //Go through all primes
			//Reset for current prime
			containsZero = false;
			currentNumberString = "" + primeNumberList.get(num);
			//Check if number contains zero
			for (int i = 0; i < currentNumberString.length(); i++) {
				if (currentNumberString.charAt(i) == '0') {
					containsZero = true;
				}
			}
			//If no zero, continue, else stop for this prime number
			if (!containsZero) {
				//Set digits
				digitCount = 0;
				for (int i = 0; i < DIGIT_TOTAL; i++) {
					if (i < DIGIT_TOTAL - currentNumberString.length()) {
						digit[i] = 0;
					}
					else {
						digit[i] = toInt(currentNumberString.charAt(digitCount));
						digitCount++;
					}
				}
				//Create variants
				for (int variantNumber = 0; variantNumber < DIGIT_TOTAL; variantNumber++) { //Go through each variant
					currentVariant = "";
					for (int i = 0; i < DIGIT_TOTAL; i++) {
							if (i + variantNumber < DIGIT_TOTAL) {
								currentVariant += digit[i + variantNumber];
							}
							else {
								currentVariant += digit[i + variantNumber - DIGIT_TOTAL];
							}
					}
					variant[variantNumber] = currentVariant;
				}
				//Remove zeros
				for (int i = 0; i < DIGIT_TOTAL; i++) {
					currentVariant = variant[i];
					currentVariantNoZeros = "";
					for (int j = 0; j < DIGIT_TOTAL; j ++) {
						if (currentVariant.charAt(j) != '0') {
							currentVariantNoZeros += currentVariant.charAt(j);
						}
					}
					variantNoZeros[i] = currentVariantNoZeros;
				}
				//Check if all variants are in the primeNumberList
				allPrime = true;
				for (int i = 0; i < DIGIT_TOTAL; i++) {
					if (!primeNumberList.contains(toNumber(variantNoZeros[i]))) {
						allPrime = false;
					}
				}
				if (allPrime) {
					counter++;
				}
			}
		}
		
		//Print solution
		System.out.print(counter);
	}
	
	private static boolean isPrime(int x) {
		//Check if factor is prime
		if (x % 2 == 0) {
			if (x == 2) {
				return(true);
			}
			else {
				return(false);
			}
		}
		int i = 3;
		while (i <= Math.sqrt(x)) {
			if (x % i == 0) {
				return(false);
			}
			i += 2;
		}
		return(true);
	}
	
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
