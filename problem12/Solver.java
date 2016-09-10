public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int limit = 500;
		int factors;
		int count;
		int num;
		
		//Instantiation
		count = 0;
		num = 0;
		factors = 0;
		
		//Go through triangular numbers until enough divisors are found
		while (factors <= limit) {
			count++; //Gets current nth triangular number
			factors = 0; //Clear previous factors
			num += count; //Find next triangular number
			//find factors
			factors++; //Adds 1 as a factor
			if (num % 2 == 0) { //If number is even
				for (int i = 2; i <= Math.sqrt(num); i++) {
					if (num % i == 0) { //Checks if a factor
						if (i * i != num) {
							factors += 2; //Add i and n/i to number of factors
						}
						else {
							factors += 1; //Add square root of number
						}
					}
				}
			}
			else { //If number is odd
				for (int i = 3; i <= Math.sqrt(num); i += 2) {
					if (num % i == 0) { //Checks if a factor
						if (i * i != num) {
							factors += 2; //Add i and n/i to number of factors
						}
						else {
							factors += 1; //Add square root of number
						}
					}
				}
			}
			if (num != 1) {
				factors++; //Adds the number as factor if number is not 1
			}
		}
		
		//Print solution
		System.out.print(num);
	}
}
