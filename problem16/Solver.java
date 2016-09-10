import java.math.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int limit = 1000;
		int sum = 0;
		String numString;
		BigInteger num = new BigInteger("1");
		BigInteger base = new BigInteger("2");
		
		//Find number
		for (int i = 0; i < limit; i++) {
			num = num.multiply(base);
		}
		
		//Convert to string
		numString = num.toString();
		
		//Add digits
		for (int i = 0; i < numString.length(); i++) {
			sum += toInt(numString.charAt(i));
		}
		
		//Print sum
		System.out.print(sum);
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
}
