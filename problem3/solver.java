import java.util.*;
public class solver {
	public static void main(String[] args) {
		//Declaration
		final long num = 600851475143L;
		List<Integer> factorList = new ArrayList<Integer>();
		List<Integer> primeFactorList = new ArrayList<Integer>();
		int currentNum;
		
		//Find factors of the number
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				factorList.add(i);
			}
		}
		//Check if factors are prime
		int result;
		int j;
		for (int i = 0; i < factorList.size(); i++) {
			currentNum = factorList.get(i);
			//Check if factor is prime
			result = 0;
			j = 2;
			while (result == 0 && j < currentNum / 2) {
				if (currentNum % j == 0) {
					result = 1;
				}
				j++;
			}
			//If prime, add to list of prime factors
			if (result == 0) {
				primeFactorList.add(currentNum);
			}
		}
		
		//Print last prime factor in list
		System.out.print(primeFactorList.get(primeFactorList.size() - 1));
	}
}
