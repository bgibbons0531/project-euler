/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the sum of all positive integers which cannot be written as the sum of two abundant numbers.
*/

import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 28123;
		boolean[] isSumOfAbundant = new boolean[LIMIT + 1];
		List<Integer> abundantNumbers = new ArrayList<Integer>();
		
		//Find abundant numbers
		int currentSum;
		for (int num = 0; num <= LIMIT; num++) {
			currentSum = 1; //Add 1 for first factor
			if (num % 2 == 0) { //If number is even
				for (int i = 2; i <= Math.sqrt(num); i++) {
					if (num % i == 0) { //Checks if a factor
						if (i * i != num) {
							currentSum += i + (num / i); //Add factor and it's counter part
						}
						else {
							currentSum += i; //Add square root of number
						}
					}
				}
			}
			else { //If number is odd
				for (int i = 3; i <= Math.sqrt(num); i += 2) {
					if (num % i == 0) { //Checks if a factor
						if (i * i != num) {
							currentSum += i + (num / i); //Add factor and it's counter part
						}
						else {
							currentSum += i; //Add square root of number
						}
					}
				}
			}
			//Check if abundant and add to abundant numbers list
			if (currentSum > num && num != 0) {
				abundantNumbers.add(num);
			}
		}
		
		//Create an array of true and false
		int abundantSum;
		for (int i = 0; i < abundantNumbers.size();i ++) {
			for (int j = i; j < abundantNumbers.size(); j++) {
				abundantSum = abundantNumbers.get(i) + abundantNumbers.get(j);
				if (abundantSum <= LIMIT) {
					isSumOfAbundant[abundantSum] = true;
				}
				else {
					break;
				}
			}
		}
		
		//Sum the non abundant sums
		int solution = 0;
		for (int i = 0; i < isSumOfAbundant.length; i++) {
			if (!isSumOfAbundant[i]) {
				solution += i;
			}
		}
		
		//Print solution
		System.out.print(solution);
	}
}
