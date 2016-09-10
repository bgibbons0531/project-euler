
public class solver {
	public static void main(String[] args) {
		//Declaration
		final int limit = 100;
		int sum = 0;
		int sumOfSquares = 0;
		int squareOfSum = 0;
		
		//Find the sum of the squares
		for (int i = 1; i <= limit; i++) {
			sumOfSquares += i * i;
		}
		
		//Find the square of the sum
		for (int i = 1; i <= limit; i++) {
			sum += i;
		}
		squareOfSum = sum * sum;
		
		//Output the difference
		System.out.print(squareOfSum - sumOfSquares);
	}
}
