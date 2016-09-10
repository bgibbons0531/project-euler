import java.util.*;
public class Solver {
	public static void main(String[] args) {
		//Declaration
		String str = "";
		int n = 0;
		List<String> list = new ArrayList<String>();
		
		//Fill list
		for (int i=1;i<10000;i++) {
			//Reset
			n=1;
			str = "";
			//Run
			while (str.length()<9) {
				str += i * n;
				n++;
			}
			if (isPandigital(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		
		System.out.print(list.get(list.size()-1));
	}
	
	private static boolean isPandigital(String str) {
		if (str.length() != 9) {
			return (false);
		}
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
