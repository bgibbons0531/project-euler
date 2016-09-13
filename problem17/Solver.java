/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the number of letters used to write out the numbers 1 to 1000 inclusive using British usage.
*/

public class Solver {
	public static void main(String[] args) {
		//Declaration
		Word myWord;
		final int limit = 1000;
		String numWord = "";
		long sum = 0;
		
		//Get numbers
		for (int i = 1; i <= limit; i++) {
			myWord = new Word(i + "");
			numWord = myWord.getWord();
			sum += numWord.length();
		}
		
		//Print solution
		System.out.print(sum);
	}
}
