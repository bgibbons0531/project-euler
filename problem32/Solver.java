import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int multiplicand;
		int multiplier;
		int product;
		int productSum;
		String digits;
		List<Integer> productList = new ArrayList<Integer>();
		
		//Get pandigital equations
		for (multiplicand = 1; multiplicand <= 10000; multiplicand++) {
			for (multiplier = multiplicand; multiplier <= 10000; multiplier++) {
				product = multiplicand * multiplier;
				digits = "" + multiplicand + multiplier + product;
				if (digits.length() == 9) {
					if (isPandigital(digits)) {
						productList.add(product);
					}
				}
			}
		}
		
		//Sort
		Collections.sort(productList);
		
		//Remove duplicates
		boolean duplicate;
		boolean clean = false;
		while (clean == false) {
			duplicate = false;
			for (int i = 1; i < productList.size(); i++) {
				if (productList.get(i - 1).equals(productList.get(i))) {
					productList.remove(i);
					duplicate = true;
				}
			}
			if (duplicate == false) {
				clean = true;
			}
		}
		
		//Sum the products
		productSum = 0;
		for (int i = 0; i < productList.size(); i++) {
			productSum += productList.get(i);
		}
		
		//Print solution
		System.out.print(productSum);
	}
	
	private static boolean isPandigital(String str) {
		boolean one = false;
		boolean two = false;
		boolean three = false;
		boolean four = false;
		boolean five = false;
		boolean six = false;
		boolean seven = false;
		boolean eight = false;
		boolean nine = false;
		for (int i = 0; i < 9; i++) {
			if (str.charAt(i) == '1') {
				one = true;
			}
			else if (str.charAt(i) == '2') {
				two = true;
			}
			else if (str.charAt(i) == '3') {
				three = true;
			}
			else if (str.charAt(i) == '4') {
				four = true;
			}
			else if (str.charAt(i) == '5') {
				five = true;
			}
			else if (str.charAt(i) == '6') {
				six = true;
			}
			else if (str.charAt(i) == '7') {
				seven = true;
			}
			else if (str.charAt(i) == '8') {
				eight = true;
			}
			else if (str.charAt(i) == '9') {
				nine = true;
			}
			else {
				return(false);
			}
		}
		if (one == true && two == true && three == true && four == true && five == true && six == true && seven == true && eight == true && nine == true) {
			return(true);
		}
		else {
			return(false);
		}
	}
}
