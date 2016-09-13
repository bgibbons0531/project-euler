/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the sum of all numbers that are equal to the sum of the factorial of their digits.
*/

public class Solver {
	public static void main(String[] args) {
		//Declaration
		int sum = 0;
		String numString;
		
		//Solve
		for (int num = 3; num < 100000; num++) {
			numString = "" + num;
			if (factorialSum(numString) == num) {
				sum += num;
			}
		}
		System.out.print(sum);
	}
	
	//Find the sum of the factorial of the digits
	public static int factorialSum(String str) {
		int count;
		int digit;
		int factorial;
		int sum = 0;
		//Go through each number
		for (int i = 0; i < str.length(); i++) {
			factorial = 1; //Reset factorial
			digit = toInt(str.charAt(i));
			count = 0;
			for (int j = digit; j > 0; j--) {
				factorial *= digit - count;
				count++;
			}
			sum += factorial;
		}
		return(sum);
	}
	
	//Convert character to integer
	public static int toInt(char c) {
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
}
