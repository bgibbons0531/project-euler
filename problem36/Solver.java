public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 1000000;
		int sum = 0;
		String stringNumber;
		String binaryNumber = "";
		
		//Solve
		for (int i = 1; i <= LIMIT; i++) {
			stringNumber = "" + i;
			binaryNumber = toBinary(i);
			if (isPalindrome(stringNumber)) {
				if (isPalindrome(binaryNumber)) {
					sum += i;
				}
			}
		}
		
		//Print solution
		System.out.print(sum);
	}
	
	//Private methods
	private static String toBinary(int x) {
		int currentNumber = x;
		String reverseBinaryNumber = "";
		String binaryNumber = "";
		while (currentNumber > 0) {
			reverseBinaryNumber += currentNumber % 2;
			currentNumber /= 2;
		}
		for (int i = reverseBinaryNumber.length() - 1; i >= 0; i--) {
			binaryNumber += reverseBinaryNumber.charAt(i);
		}
		return(binaryNumber);
	}
	
	private static boolean isPalindrome(String str) {
		int str_len = str.length();
		for (int i = 0; i < str.length() / 2; i++) {
			if (!(str.charAt(i) == str.charAt(str_len - 1 - i))) {
				return(false);
			}
		}
		return(true);
	}
}
