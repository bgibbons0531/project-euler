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
		Importer myImporter = new Importer();
		List<String> wordList = new ArrayList<String>();
		List<Integer> wordScoreList = new ArrayList<Integer>();

		//Get list of words
		wordList = myImporter.getWords();

		//Create a list of the score of each word
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
	}

	//Private methods
	private static int getLetterScore(char c) {
		return((int)c - 64);
	} 
}
