/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the value of d<1000 
* 		such that 1/d contains the longest recurring cycle in its decimal fraction part.
*/

import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 1000;
		List<Integer> primeList = new ArrayList<Integer>();
		int num;
		int rem;
		int counter;
		int digitLimit;
		int maxPeriod = 0;
		int maxInt = 0;
		
		//Get primes under limit
		for (int i = 2; i < LIMIT; i++) {
			if (isPrime(i)) {
				primeList.add(i);
			}
		}
		
		//Solve
		for (int i = 0; i < primeList.size(); i++) {
			num = primeList.get(i);
			counter = 0;
			digitLimit = 1000;
			rem = 10 % num;
			//Perform long division keeping track of how many times it has occurred
			while (rem != 1 && digitLimit > 0) {
				rem = rem * 10; //Multiply remainder by 10
				rem = rem % num; //Find new remainder
				counter++;
				digitLimit--;
			}
			//Check if the new period is greater, and set that period and the current denominator
			if (counter > maxPeriod && digitLimit > 1) {
				maxPeriod = counter;
				maxInt = num;
			}
		}
		System.out.print(maxInt);
	}
	
	private static boolean isPrime(int x) {
		//Check if factor is prime
		int i = 2;
		while (i <= Math.sqrt(x)) {
			if (x % i == 0) {
				return(false);
			}
			i++;
		}
		return(true);
	}
}
