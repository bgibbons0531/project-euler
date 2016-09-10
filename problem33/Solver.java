import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int LIMIT = 100;
		boolean cancelable = false;
		int numProduct = 1;
		int denomProduct = 1;
		String numString;
		String denomString;
		List<Integer> numList = new ArrayList<Integer>();
		List<Integer> denomList = new ArrayList<Integer>();
		List<Integer> numListCanceled = new ArrayList<Integer>();
		List<Integer> denomListCanceled = new ArrayList<Integer>();
		
		//Fill the list with cancelable fractions
		for (int num = 10; num < LIMIT; num++) {
			for (int denom = num + 1; denom < LIMIT; denom++) {
				//Convert to a String
				numString = "" + num;
				denomString = "" + denom;
				//Check if cancelable
				cancelable = false;
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						if (numString.charAt(i) == denomString.charAt(j) && numString.charAt(1) != '0') {
							cancelable = true;
						}
					}
				}		
				//Add if cancelable
				if (cancelable == true) {
					numList.add(num);
					denomList.add(denom);
				}
			}
		}
		
		//Cancel out the number
		for (int i = 0; i < numList.size(); i++) {
			numString = "" + numList.get(i);
			denomString = "" + denomList.get(i);
			if (numString.charAt(0) == denomString.charAt(0)) {
				numListCanceled.add(toInt(numString.charAt(1)));
				denomListCanceled.add(toInt(denomString.charAt(1)));
			}
			else if (numString.charAt(0) == denomString.charAt(1)) {
				numListCanceled.add(toInt(numString.charAt(1)));
				denomListCanceled.add(toInt(denomString.charAt(0)));
			}
			else if (numString.charAt(1) == denomString.charAt(0)) {
				numListCanceled.add(toInt(numString.charAt(0)));
				denomListCanceled.add(toInt(denomString.charAt(1)));
			}
			else {
				numListCanceled.add(toInt(numString.charAt(0)));
				denomListCanceled.add(toInt(denomString.charAt(0)));
			}
		}
		
		//Get the fractions that can be canceled
		for (int i = 0; i < numList.size(); i++) {
			if ((double)numList.get(i) / (double)denomList.get(i) == (double)numListCanceled.get(i) / (double)denomListCanceled.get(i)) {
				numProduct *= numListCanceled.get(i);
				denomProduct *= denomListCanceled.get(i);
			}
		}
		
		//Print solution
		System.out.print(denomProduct / numProduct);
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
