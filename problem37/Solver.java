
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 750000;
		int count = 0;
		int sum = 0;
		boolean prime = false;
		String numberFront = "";
		String numberBack = "";
		
		//Solve
		for (int i = 11; i <= LIMIT; i += 2) {
			numberFront = "" + i;
			numberBack = "" + i;
			
			//Cycle through each side
			while (numberFront.length() > 0) {
				if (isPrime(toNumber(numberFront)) && isPrime(toNumber(numberBack))) {
					prime = true;
					numberFront = removeFront(numberFront);
					numberBack = removeBack(numberBack);
				}
				else {
					prime = false;
					break;
				}
			}
			if (prime == true) {
				sum += i;
				count++;
			}
			if (count == 11) {
				break;
			}
		}
		System.out.println(sum);
	}
	
	private static String removeFront(String str) {
		String tmp_str = "";
		for (int i = 1; i < str.length(); i++) {
			tmp_str += str.charAt(i);
		}
		return(tmp_str);
	}
	
	private static String removeBack(String str) {
		String tmp_str = "";
		for (int i = 0; i < str.length() - 1; i++) {
			tmp_str += str.charAt(i);
		}
		return(tmp_str);
	}
	
	private static boolean isPrime(int x) {
		//Check if factor is prime
		if (x == 1 || x == 4) {
			return(false);
		}
		int result = 0;
		int j = 2;
		while (result == 0 && j < x / 2) {
			if (x % j == 0) {
				result = 1;
			}
			j++;
		}
		if (result == 0) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	private static int toInt(char c) {
		if (c == '0') { return(0); }
		else if (c == '1') { return(1); }
		else if (c == '2') { return(2); }
		else if (c == '3') { return(3); }
		else if (c == '4') { return(4); }
		else if (c == '5') { return(5); }
		else if (c == '6') { return(6); }
		else if (c == '7') { return(7); }
		else if (c == '8') { return(8); }
		else { return(9); }
	}
	
	private static int toNumber(String str) {
		int number = 0;
		int multiplier = 1;
		int digit = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			number += toInt(str.charAt(digit)) * multiplier;
			multiplier *= 10;
			digit--;
		}
		return(number);
	}
}
