/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the starting number under 1 million that produces the longets Collatz sequence.
*/

public class Solver {
	public static void main(String[] args) {
		//Declaration
		long n;
		int iterations;
		final int LIMIT = 1000000;
		int currentWinner = 1;
		int solution = 0;
		
		//Solve
		for (int i = 1; i < LIMIT; i += 2) {
			n = i;
			iterations = 0;
			while (n != 1) {
				if (n % 2 == 0) { //If even
					n = n /2;
					iterations++;
				}
				else { //If odd
					n = 3 * n + 1;
					iterations++;
				}
			}
			iterations++; //Add 1 for the final number
			//Checks if numbers has more iterations than previous
			if (iterations > currentWinner) {
				currentWinner = iterations;
				solution = i;
			}
		}
		
		//Print solution
		System.out.print(solution);
	}
}
