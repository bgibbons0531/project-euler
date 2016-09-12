/**
*	@file: solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the largest palindrome formed by a product of 3 digit numbers
*/

import java.util.*;
public class solver {
	public static void main(String[] args) {
		//Declaration
		final int start = 100;
		final int finish = 999;
		List<String> productList = new ArrayList<String>();
		List<String> palindromeProductList = new ArrayList<String>();
		String currentNum;
		Boolean palindrome;
		String largestNum;
		
		//Populate list with products
		for (int i = start; i <= finish; i++) {
			for (int j = start; j <= finish; j++) {
				productList.add("" + i * j);
			}
		}
		
		//Check if product is a palindrome
		for (int i = 0; i < productList.size(); i++) {
			currentNum = productList.get(i);
			//Check if palindrome
			palindrome = true;
			for (int j = 0; j < currentNum.length() / 2; j++) {
				if (currentNum.charAt(j) != currentNum.charAt(currentNum.length() - j - 1)) {
					palindrome = false;
				}
			}
			//Add to list
			if (palindrome == true) {
				palindromeProductList.add(currentNum);
			}			
		}
		
		//Find the largest palindrome
		largestNum = "";
		for (int i = 0; i < palindromeProductList.size(); i++) { //Go through entire list
			currentNum = palindromeProductList.get(i); //Set current number
			if (currentNum.length() > largestNum.length()) { //If currentNum is longer
				largestNum = currentNum;
			}
			else if (currentNum.length() == largestNum.length()) { //If currentNum is same length
				for (int j = 0; j < currentNum.length(); j++) {
					if ((int)currentNum.charAt(0) > (int)largestNum.charAt(0)) {
						largestNum = currentNum;
					}
				}
			}
		}
		
		//Print Solution
		System.out.print(largestNum);
	}
}
