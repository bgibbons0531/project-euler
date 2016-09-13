/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the sum of all the numbers that can be written as the sum of fifth powers of their digits.
*/

import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int number;
		String numberString;
		int digit1;
		int digit2;
		int digit3;
		int digit4;
		int digit5;
		int digit6;
		int digitPower1 = 1;
		int digitPower2 = 1;
		int digitPower3 = 1;
		int digitPower4 = 1;
		int digitPower5 = 1;
		int digitPower6 = 1;
		int digitPowerSum;
		int sum = 0;
		List<String> numberList = new ArrayList<String>();
		
		//Solve
		for (digit1 = 0; digit1 < 10; digit1++) {
			digit2 = 0;
			while (digit2 < 10) {
				digit3 = 0;
				while (digit3 < 10) {
					digit4 = 0;
					while (digit4 < 10) {
						digit5 = 0;
						while (digit5 < 10) {
							digit6 = 0;
							while (digit6 < 10) {
								//Set number
								numberString = "" + digit1 + digit2 + digit3 + digit4 + digit5 + digit6;
								number = toNumber(numberString);
								//Find digit power sum
								digitPower1 = 1;
								digitPower2 = 1;
								digitPower3 = 1;
								digitPower4 = 1;
								digitPower5 = 1;
								digitPower6 = 1;
								for (int i = 0; i < 5; i++) {
									digitPower1 *= digit1;
									digitPower2 *= digit2;
									digitPower3 *= digit3;
									digitPower4 *= digit4;
									digitPower5 *= digit5;
									digitPower6 *= digit6;
								}
								digitPowerSum = digitPower1 + digitPower2 + digitPower3 + digitPower4 + digitPower5 + digitPower6;
								if (digitPowerSum == number && !numberList.contains(numberString) && number > 1) {
									numberList.add(numberString);
								}
								else if (digitPowerSum > number) {
									break;
								}
								digit6++;
							}
							digit5++;
						}
						digit4++;
					}
					digit3++;
				}
				digit2++;
			}
		}
		
		//Remove duplicates
		boolean duplicate;
		boolean clean = false;
		while (clean == false) {
			duplicate = false;
			for (int i = 1; i < numberList.size(); i++) {
				if (numberList.get(i - 1).equals(numberList.get(i))) {
					numberList.remove(i);
					duplicate = true;
				}
			}
			if (duplicate == false) {
				clean = true;
			}
		}
		
		//Find the sum
		for (int i = 0; i < numberList.size(); i++) {
			sum += toNumber(numberList.get(i));
		}
		
		//Print solution
		System.out.print(sum);
	}
	
	public static int toNumber(String str) {
		int number = 0;
		int multiplier = 1;
		int digit = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			number += toInt(str.charAt(digit)) * multiplier;
			multiplier *= 10;
			digit--;
		}
		return(number);
	}
	
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
