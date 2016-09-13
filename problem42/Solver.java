/**
*	@file: Solver.java
*	@author: Brad Gibbons
*	@date: 2016.09.13
*	Purpose: Calculate the number of triangle words in words.txt.
*/

import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int count = 0;
		Importer myImporter = new Importer();
		List<String> wordList = new ArrayList<String>();
		List<Integer> wordScoreList = new ArrayList<Integer>();
		List<Integer> triangleNumberList = new ArrayList<Integer>();

		//Get list of words
		wordList = myImporter.getWords();

		//Create a list of the score of each word and sort
		String currentWord = "";
		int currentSum = 0;
		for (int i=0; i<wordList.size(); i++) {
			currentWord = wordList.get(i); //Set currentWord
			currentSum = 0;
			for (int j=0; j<currentWord.length(); j++) {
				currentSum += getLetterScore(currentWord.charAt(j));
			}
			wordScoreList.add(currentSum);
		}
		Collections.sort(wordScoreList);

		//Create a list of triangle numbers up to the max of wordScoreList
		int limit = wordScoreList.get(wordScoreList.size()-1); //Highest word score
		int x = 1;
		int currentTriangle = 1;
		while (currentTriangle <= limit) {
			triangleNumberList.add(currentTriangle); //Add the current triangle number to the list
			x++; //Increment x
			currentTriangle = x*(x+1)/2; //Get the next triangle number
		}

		//Count how many words are triangle numbers
		for (int i=0; i<wordScoreList.size(); i++) {
			if (triangleNumberList.contains(wordScoreList.get(i))) {
				count++;
			}
		}

		//Print the solution
		System.out.println(count);
	}

	//Private methods
	private static int getLetterScore(char c) {
		return((int)c - 64);
	} 
}
