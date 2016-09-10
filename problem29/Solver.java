import java.util.*;
import java.math.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 100;
		BigInteger base;
		BigInteger number;
		List<BigInteger> numberList = new ArrayList<BigInteger>();
		
		//Solve
		for (int a = 2; a <= LIMIT; a++) {
			for (int b = 2; b <= LIMIT; b++) {
				base = new BigInteger("" + a);
				number = new BigInteger("" + a);
				//Get the exponent
				for (int i = 1; i < b; i++) {
					number = number.multiply(base);
				}
				numberList.add(number);
			}
		}
		
		//Sort into ascending
		Collections.sort(numberList);
		
		//Remove duplicates
		boolean duplicate;
		boolean clean = false;
		while (clean == false) {
			duplicate = false;
			for (int i = 1; i < numberList.size(); i++) {
				if (numberList.get(i - 1).equals(numberList.get(i))) {
					numberList.remove(i);
					duplicate = true;
				}
			}
			if (duplicate == false) {
				clean = true;
			}
		}
		//Print solution
		System.out.print(numberList.size());
	}
}
