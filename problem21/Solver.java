/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the sum of all amicable numbers under 10,000.
*/

public class Solver {
	public static void main(String[] args) {
		//Declaration
		int solution = 0;
		final int limit = 10000;
		int[] sums = new int[limit - 1];
		
		//Find the sum of the divisors of numbers under 1000
		int sum;
		for (int num = 1; num < limit; num++) {
			sum = 1; //Add 1 for first factor
			if (num % 2 == 0) { //If number is even
				for (int i = 2; i <= Math.sqrt(num); i++) {
					if (num % i == 0) { //Checks if a factor
						if (i * i != num) {
							sum += i + (num / i); //Add factor and it's counter part
						}
						else {
							sum+= i; //Add square root of number
						}
					}
				}
			}
			else { //If number is odd
				for (int i = 3; i <= Math.sqrt(num); i += 2) {
					if (num % i == 0) { //Checks if a factor
						if (i * i != num) {
							sum += i + (num / i); //Add factor and it's counter part
						}
						else {
							sum += i; //Add square root of number
						}
					}
				}
			}
			sums[num - 1] = sum; //Set the sum
		}
		
		//Find amicable numbers
		for (int i = 0; i < sums.length; i++) {
			for (int j = 0; j < sums.length; j++) {
				if (sums[i] == j + 1 && sums[j] == i + 1 && i != j) {
					solution += i + 1;
				}
			}
		}
		
		//Print solution
		System.out.print(solution);
	}
}
