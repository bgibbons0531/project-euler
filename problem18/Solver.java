
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int numberOfRows;
		int[][] triangle;
		Importer myImporter = new Importer();
		
		//Get triangle
		numberOfRows = myImporter.getNumberOfRows();
		triangle = new int[numberOfRows][numberOfRows];
		triangle = myImporter.getTriangle();
		
		//Solve
		int sumA = 0;
		int sumB = 0;
		for (int row = numberOfRows - 1; row > 0; row--) { //Change rows
			for (int column = 0; column < numberOfRows - 1; column++) { //Change columns
				sumA = triangle[row - 1][column] + triangle[row][column];
				sumB = triangle[row - 1][column] + triangle[row][column + 1];
				if (sumA > sumB) {
					triangle[row - 1][column] = sumA;
				}
				else {
					triangle[row - 1][column] = sumB;
				}
			}
		}
		//Print solution
		System.out.print(triangle[0][0]);
	}
}
