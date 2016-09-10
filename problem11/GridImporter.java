import java.io.*;
public class GridImporter {
	//Declaration
	String filename = "grid.txt";
	FileReader myFileReader = null;
	BufferedReader myBufferedReader = null;
	int[][] grid = new int[20][20];
	
	//Constructor
	public GridImporter() {
		try {
			//Assign readers
			myFileReader = new FileReader(filename);
			myBufferedReader = new BufferedReader(myFileReader);
			
			//Read each line
			String line;
			int rowCounter = 0;
			int columnCounter = 0;
			line = myBufferedReader.readLine();
			while (line != null) {
				columnCounter = 0; //Reset column
				for (int i = 0; i < 60; i += 3) { //Go through each number
					int sum = 0;
					for (int j = 0; j < 2; j++) { //Get the 2 digit number
						if (j == 0) { //Gets first digit
							sum += toInt(line.charAt(i+j)) * 10;
						}
						else { //Gets second digit
							sum += toInt(line.charAt(i+j));
						}
					}
					grid[rowCounter][columnCounter] = sum;
					columnCounter++;
				}
				line = myBufferedReader.readLine(); // Read new line
				rowCounter++;
			}
			myBufferedReader.close();
		}
		catch (Exception e) {
			System.out.print(e);
		}
	}
	
	//Get method
	public int[][] getArray() {
		return(grid);
	}
	
	//Private method
	private int toInt(char c) { //converts the digit character to it's integer
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
