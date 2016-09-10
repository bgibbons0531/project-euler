public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 1000;
		int currentNumber;
		int n;
		int counter;
		int aMax = 0;
		int bMax = 0;
		int counterMax = 0;
		
		//Solve
		for (int a = 1 -  LIMIT; a < LIMIT; a++) {
			for (int b = a; b < LIMIT; b++) {
				if (isPrime(Math.abs(a)) && isPrime(Math.abs(b))) {
					//Reset
					counter = 0;
					n = 0;
					//Check if prime
					currentNumber = (n * n) + (a * n) + b;
					while (isPrime(currentNumber) && currentNumber > 0) {
						counter++;
						n++;
						currentNumber = (n * n) + (a * n) + b;
					}
					if (counter > counterMax) {
						counterMax = counter;
						aMax = a;
						bMax = b;
					}
				}
			}
		}
		System.out.print(aMax * bMax);
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
