/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the millionth lexicographic permutation of the digits 0,1,2,3,4,5,6,7,8,9.
*/

import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int DIGITS = 10;
		final int n = 1000000;
		String number = "";
		List<Integer> possibleDigits = new ArrayList<Integer>();
		List<Integer> availableDigits = new ArrayList<Integer>();
		
		//Generate possible digits
		for (int i = 0; i < DIGITS; i++) {
			possibleDigits.add(i);
		}
		
		
		//Find nth permutation
		int currentBlockSize; //Finds the block size based on the number of digits remaining
		int currentBlock; //Determines the current block the number is in
		int currentLocation = n; //Used for finding the location based on the current block
		availableDigits = possibleDigits;
		while(availableDigits.size() > 0) {
			Collections.sort(availableDigits); //Sort remaining digits
			currentBlockSize = findPossibleCombinations(availableDigits.size()) / availableDigits.size(); //Get current block size for the remaining choices
			if (currentLocation % currentBlockSize != 0) { //If not an evenly divisible number
				currentBlock = currentLocation / currentBlockSize;
			}
			else { //If an evenly divisible number
				currentBlock = (currentLocation / currentBlockSize) - 1;
			}
			number += availableDigits.get(currentBlock); //Add the digits
			availableDigits.remove(currentBlock); //Remove from available digits
			currentLocation -= currentBlockSize * currentBlock; //Move current location based on the current block
		}
		
		//Print solution
		System.out.print(number);
	}
	
	//Find number of permutations
	private static int findPossibleCombinations(int x) {
		int currentProduct = 1;
		for (int i = 1; i <= x; i++) {
			currentProduct *= i;
		}
		return(currentProduct);
	}
}
