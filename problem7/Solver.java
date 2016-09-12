/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the 10,001st prime number.
*/

import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int limit = 10001;
		int currentNum;
		List<Integer> primeList = new ArrayList<Integer>();
		
		//Generate prime numbers
		currentNum = 2;
		while (primeList.size() <= limit) {
			if (isPrime(currentNum) == true) {
				primeList.add(currentNum);
			}
			currentNum++;
		}
		System.out.print(primeList.get(primeList.size() - 1));
	}
	
	//Check if prime
	private static boolean isPrime(int x) {
		//Check if factor is prime
		int result = 0;
		int j = 2;
		while (result == 0 && j < x / 2) {
			if (x % j == 0) {
				result = 1;
			}
			j++;
		}
		if (result == 0) {
			return(true);
		}
		else {
			return(false);
		}
	}
}

