
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 7; //How many digits according to powers of 10
		int di = 1; //digit index
		int product = 1;
		
		//Solve
		for (int i=0;i<LIMIT;i++) {
			//Set the digit to find
			di = (int)Math.pow(10, i);
			//Find out indices
			int startLocation = 0, endLocation = 0, digitsInvolved = 0;
			while (endLocation < di) {
				startLocation = endLocation + 1;
				endLocation += 9 * (int)Math.pow(10, (digitsInvolved)) * (digitsInvolved + 1);
				digitsInvolved++;
			}
			//Get number
			int relativeIndex = di - startLocation; //Get the relative index
			int relativeNumber = relativeIndex / digitsInvolved; //Get the relative number
			int digitLocation = relativeIndex % digitsInvolved; //Get what digit of that number
			String number = "" + getNumber(digitsInvolved, relativeNumber); //Get the actual number and convert to a string
			product *= (int)number.charAt(digitLocation) - 48; //Multiply the product by the digit of that number
		}
		
		//Print Solution
		System.out.print("Product: " + product);
	}
	
	private static int getNumber(int digitsInvolved, int relativeNumber) {
		int start = (int)Math.pow(10, digitsInvolved-1);
		int count = 0;
		while (count < relativeNumber) {
			count++;
		}
		return (start + count);
	}
}
