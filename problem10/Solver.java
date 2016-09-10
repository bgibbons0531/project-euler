
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 2000000;
		long sum = 2;
		
		//Go through primes below limit
		for (int i = 3; i < LIMIT; i += 2) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		
		//Print solution
		System.out.print(sum);
	}
	
	private static boolean isPrime(int x) {
		//Check if factor is prime
		int i = 2;
		while (i <= Math.sqrt(x)) {
			if (x % i == 0) {
				return(false);
			}
			i++;
		}
		return(true);
	}
	
}
