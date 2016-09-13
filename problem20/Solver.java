/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Find the sum of the digits in the number 100!
*/

import java.math.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int sum = 0;
		BigInteger currentProduct = new BigInteger("1");
		BigInteger currentFactor;
		String product;
		
		//Find 100!
		for (int i = 1; i <= 100; i++) {
			currentFactor = new BigInteger(i + "");
			currentProduct = currentProduct.multiply(currentFactor);
		}
		product = currentProduct.toString(); //Convert to a string
		//Add digits
		for (int i = 0; i < product.length(); i++) {
			sum += toInt(product.charAt(i));
		}
		//Print solution
		System.out.print(sum);
	}
	
	//Private method
	private static int toInt(char c) { //converts the digit character to it's integer
		if (c == '0' || c == ' ') { return(0); }
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
}
