import java.io.*;
import java.util.*;
public class Importer {
	//Declaration
	String filename = "names.txt";
	String names = null;
	FileReader myFileReader = null;
	BufferedReader myBufferedReader = null;
	List<String> namesList = new ArrayList<String>();
	
	//Constructor
	public Importer() {
		names = importNames(filename);
		fillList();
	}
	
	//Private Methods
	private String importNames(String file) {
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
		while (charCount < names.length()) { //Go through all names
			while (names.charAt(charCount) != ',' && charCount < names.length() - 1) { //Go through word
				if (names.charAt(charCount) != '"') {
					tmp_str += names.charAt(charCount);
				}
				charCount++;
			}
			//Add name and reset
			namesList.add(tmp_str);
			tmp_str = "";
			charCount++;
		}
	}
	
	//Public Methods
	public List<String> getNames() {
		return(namesList);
	}
}
