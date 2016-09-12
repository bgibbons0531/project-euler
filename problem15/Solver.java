/**
*	@file: Solver.java
* 	@author: Brad Gibbons
* 	@date: 2016.09.12
* 	Description: Calculate the number of paths through a 20x20 grid being able to only move down and right.
*/

public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int size = 20;
		Long[][] grid = new Long[size][size];

		//Find solution
		for (int row = 0; row < size; row++) {
			for (int column = 0; column < size; column++) {
				if (row == 0 && column == 0) {
					grid[row][column] = 2L;
				}
				else if (row == 0) {
					grid[row][column] = grid[row][column - 1] + 1;
				}
				else if (column == 0) {
					grid[row][column] = grid[row - 1][column] + 1;
				}
				else grid[row][column] = grid[row - 1][column] + grid[row][column - 1];
			}
		}
		//Print solution
		System.out.print(grid[size - 1][size - 1]);
	}
}
