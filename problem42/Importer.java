/**
*	@file: Importer.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.13
* 	Description: Import the words in words.txt into a list of strings.
*/

import java.io.*;
import java.util.*;
public class Importer {
	//Declaration
	String filename = "words.txt";
	String words = null;
	FileReader myFileReader = null;
	BufferedReader myBufferedReader = null;
	List<String> wordList = new ArrayList<String>();
	
	//Constructor
	public Importer() {
		words = importWords(filename);
		fillList();
	}
	
	//Private Methods
	private String importWords(String file) {
		String tmp_str = "";
		try {
			//Assign reader
			myFileReader = new FileReader(file);
			myBufferedReader = new BufferedReader(myFileReader);
			
			//Read line
			tmp_str = myBufferedReader.readLine();
			return(tmp_str);
		}
		catch (Exception e) {
			return(null);
		}
	}
	private void fillList() {
		String tmp_str = "";
		int charCount = 0;
		while (charCount < words.length()) { //Go through all words
			while (words.charAt(charCount) != ',' && charCount < words.length() - 1) { //Go through word
				if (words.charAt(charCount) != '"') {
					tmp_str += words.charAt(charCount);
				}
				charCount++;
			}
			//Add name and reset
			wordList.add(tmp_str);
			tmp_str = "";
			charCount++;
		}
	}
	
	//Public Methods
	public List<String> getWords() {
		return(wordList);
	}
}