
public class Solver {
	public static void main(String[] args) {
		//Declaration
		final int total = 1000;
		int aFinal = 0;
		int bFinal = 0;
		int cFinal = 0;
		
		for (int c = 0; c < total; c++) {
			for (int b = 0; b < c; b++) {
				for (int a = 0; a < b; a++) {
					if (a + b + c == total && a * a + b * b == c * c) {
						aFinal = a;
						bFinal = b;
						cFinal = c;
					}
				}
			}
		}
		
		//Multiply together
		System.out.print(aFinal * bFinal * cFinal);
	}
}
