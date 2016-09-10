
public class solver {
	public static void main(String[] args) {
		//Declaration
		final int limit = 4000000;
		int sum = 0;
		int num1 = 1;
		int num2 = 2;
		int numCheck;
		
		//Calculate sum
		numCheck = num2;
		while (num1 < limit && num2 < limit) {
			//Check if current number is even and add to list
			if (numCheck % 2 == 0) {
				sum += numCheck;
			}
			//Find next number
			numCheck = num1 + num2;
			//Change two previous numbers
			num1 = num2;
			num2 = numCheck;	
		}
		
		//Print solution
		System.out.print(sum);
	}
}
