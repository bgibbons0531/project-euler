
import java.math.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		BigInteger x = new BigInteger("1");
		BigInteger y = new BigInteger("1");
		BigInteger z = new BigInteger("1");
		int count;
		
		//Find index of term with 1000 digits
		count = 2;
		while (z.toString().length() < 1000) {
			z = y.add(x);
			x = y;
			y = z;
			count++;
		}
		
		//Print solution
		System.out.print(count);
	}
}
