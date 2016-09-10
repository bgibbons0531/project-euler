import java.math.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		Importer myImporter = new Importer();
		String[] numbers = myImporter.getNumbers();
		BigInteger number;
		BigInteger sum = new BigInteger("0");
		
		//Adds all 100 numbers together
		for (int i = 0; i < numbers.length; i++) {
			number = new BigInteger(numbers[i]);
			sum = sum.add(number);
		}
		
		//Print solution
		for (int i = 0; i < 10; i++) {
			System.out.print(sum.toString().charAt(i));
		}
	}
}
