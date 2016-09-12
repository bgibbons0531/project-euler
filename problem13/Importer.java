/**
*	@file: Importer.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Import 100 50-digit numbers into an array of strings. 
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class Importer {
	//Declaration
	String filename = "numbers.txt";
	FileReader myFileReader = null;
	BufferedReader myBufferedReader = null;
	String[] numbers = new String[100];
	
	//Constructor
	public Importer() {
		try {
			//Assign readers
			myFileReader = new FileReader(filename);
			myBufferedReader = new BufferedReader(myFileReader);
			
			//Read each line
			int lineCounter = 0;
			String line;
			line = myBufferedReader.readLine(); //Read first line
			while (line != null) {
				//Store line
				numbers[lineCounter] = line;
				//Go to next line
				line = myBufferedReader.readLine();
				lineCounter++;
			}
			myBufferedReader.close(); //Close reader
		}
		catch (Exception e) {
			System.out.print(e);
		}
	}
	
	//Get method
	public String[] getNumbers() {
		return(numbers);
	}
}
