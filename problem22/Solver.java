import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int finalSum = 0;
		Importer myImporter = new Importer();
		List<String> namesList = new ArrayList<String>();
		
		//Get list of names and sorts them
		namesList = myImporter.getNames();
		Collections.sort(namesList);
		
		//Find the score of each names and add to previous sum
		String currentName;
		int currentSum;
		for (int i = 0; i < namesList.size(); i++) {
			currentName = namesList.get(i); //Set current name
			currentSum = 0; //reset current sum
			for (int j = 0; j < currentName.length(); j++) {
				currentSum += getLetterScore(currentName.charAt(j));
			}
			finalSum += currentSum * (i + 1);
		}
		
		//Print solution
		System.out.print(finalSum);
	}
	
	//Private methods
	private static int getLetterScore(char c) {
		return((int)c - 64);
	} 
}