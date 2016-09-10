
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 1001;
		int sum = 1;
		
		//Solve
		int currentNumber = 1;
		int currentAdder = 2;
		for (int i = 0; i < (LIMIT - 1) / 2; i++) {
			for (int j = 0; j < 4; j++) {
				currentNumber += currentAdder;
				sum += currentNumber;
			}
			currentAdder += 2;
		}
		System.out.print(sum);
	}
}
