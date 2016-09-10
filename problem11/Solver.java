import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int[][] grid = new int[20][20];
		GridImporter myGrid = new GridImporter();
		List<Long> productList = new ArrayList<Long>();
		long horizontalProduct;
		long verticalProduct;
		long diagonalProduct;
		long otherProduct;
		
		//Import grid
		grid = myGrid.getArray();
		
		//Find product horizontal, vertical, and diagonal down and right
		for (int row = 0; row < 17; row++) { //Move down column
			for (int column = 0; column < 17; column++) { //Move along row
				//Reset products
				horizontalProduct = 1;
				verticalProduct = 1;
				diagonalProduct = 1;
				//Find possible products from that spot
				for (int i = 0; i < 4; i++) {
					horizontalProduct *= grid[row][column + i];
					verticalProduct *= grid[row + i][column];
					diagonalProduct *= grid [row + i][column + i];
				}
				//Add products to list
				productList.add(horizontalProduct);
				productList.add(verticalProduct);
				productList.add(diagonalProduct);
			}
		}
		//Find product diagonal up and right
		for (int row = 19; row > 2; row--) { //Move up column starting with final row
			for (int column = 0; column < 17; column++) { //Move along row
				//Reset product
				otherProduct = 1;
				//Find other product from that spot
				for (int i = 0; i < 4; i++) {
					otherProduct *= grid[row - i][column + i];
				}
				//Add product to list
				productList.add(otherProduct);
			}
		}
		//Sort list in ascending order and print final integer in list
		Collections.sort(productList);
		System.out.print(productList.get(productList.size() - 1));
	}
}
