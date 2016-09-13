/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the first term in the Fibonacci sequence to contain 1000 digits.
*/

import java.math.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		BigInteger x = new BigInteger("1");
		BigInteger y = new BigInteger("1");
		BigInteger z = new BigInteger("1");
		int count;
		
		//Find index of term with 1000 digits
		count = 2;
		while (z.toString().length() < 1000) {
			z = y.add(x);
			x = y;
			y = z;
			count++;
		}
		
		//Print solution
		System.out.print(count);
	}
}
