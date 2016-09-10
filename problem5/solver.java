import java.util.*;
public class solver {
	public static void main(String[] args) {
		//Declaration
		final int limit = 20;
		List<Integer> primeList = new ArrayList<Integer>();
		int[] primeArray;
		int primeProduct = 1;
		int totalProduct = 1;
		
		//Populate list with prime numbers from 1 to the limit
		int result;
		for (int i = 2; i <= limit; i++) {
			//Check if factor is prime
			result = 0;
			int j = 2;
			while (result == 0 && j <= i / 2) {
				if (i % j == 0) {
					result = 1;
				}
				j++;
			}
			//If prime, add to list of prime factors
			if (result == 0) {
				primeList.add(i);
			}
		}
		
		//Convert to an array
		primeArray = new int[primeList.size()];
		for (int i = 0; i < primeList.size(); i++) {
			primeArray[i] = (int)primeList.get(i);
		}
		
		//Calculate largest multiple of each prime
		for (int i = 0; i < primeArray.length; i++) {
			primeProduct = 1;
			while (primeProduct <= limit) {
				primeProduct *= primeArray[i];
			}
			totalProduct *= primeProduct / primeArray[i];
		}
		
		System.out.print(totalProduct);
	}
}
