/**
*	@file: solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the sum of all multiples of 3 and 5 below 1000.
*/
public class solver {
	public static void main(String[] args) {
		//Declaration
		final int limit = 1000;
		int sum = 0;
		
		//Calculate sum of all multiples of 3 or 5 below the limit
		for (int i = 0; i < limit; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		
		//Print solution
		System.out.print(sum);
	}
}
