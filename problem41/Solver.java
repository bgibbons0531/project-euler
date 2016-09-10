import java.util.*;
public class Solver {	
	public static void main(String[] args) {
		//Declaration
		int number = 987654321;
		boolean[] primes = new boolean[number];
		
		//Solve
		double startTime = System.nanoTime();
		
		//Find primes up the number
		primes = fillSieve(number+1);
		
		//Check if prime
		boolean found = false;
		while (!found) {
			if (primes[number] && isPandigital(number)) {
				found = true;
				System.out.println("Solution: " + number);
			}
			number-=2;
		}
		
		double endTime = System.nanoTime();
		System.out.print("Time: " + ((endTime-startTime)/1000000000));
		
	}
	private static boolean isPandigital(int num) {
		String num_str = "" + num;
		if (num_str.contains("0")) {
			return(false);
		}
		String digit_str = "123456789";
		boolean solution = true;
		for (int i=0;i<num_str.length();i++) {
			if (num_str.indexOf(digit_str.charAt(i)) == -1) {
				return(false);
			}
			if (num_str.indexOf(digit_str.charAt(i)) != num_str.lastIndexOf(digit_str.charAt(i))) {
				return(false);
			}
		}
		return(solution);
	}
	public static boolean[] fillSieve(int n) {
		boolean[] primes = new boolean[n];
	    Arrays.fill(primes,true);        // assume all integers are prime.
	    primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
	    for (int i=2;i<primes.length;i++) {
	        //if the number is prime, 
	        //then go through all its multiples and make their values false.
	        if(primes[i]) {
	            for (int j=2;i*j<primes.length;j++) {
	                primes[i*j]=false;
	            }
	        }
	    }
	    return(primes);
	}
}
