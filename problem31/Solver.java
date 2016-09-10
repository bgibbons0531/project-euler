
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int p1;
		int p2;
		int p5;
		int p10;
		int p20;
		int p50;
		int p100;
		int p200;
		int total;
		int counter = 0;
		
		//Solve
		for (p200 = 1; p200 >= 0; p200--) {
			p100 = 200 - (p200 * 200);
			while (p100 >= 0) {
				p50 = 200 - (p200 * 200) - (p100 * 100);
				while (p50 >= 0) {
					p20 = 200 - (p200 * 200) - (p100 * 100) - (p50 * 50);
					while (p20 >= 0) {
						p10 = 200 - (p200 * 200) - (p100 * 100) - (p50 * 50) - (p20 * 20);
						while (p10 >= 0) {
							p5 = 200 - (p200 * 200) - (p100 * 100) - (p50 * 50) - (p20 * 20) - (p10 * 10);
							while (p5 >= 0) {
								p2 = 200 - (p200 * 200) - (p100 * 100) - (p50 * 50) - (p20 * 20) - (p10 * 10) - (p5 * 5);
								while (p2 >= 0) {
									p1 = 200 - (p200 * 200) - (p100 * 100) - (p50 * 50) - (p20 * 20) - (p10 * 10) - (p5 * 5) - (p2 * 2);
									while (p1 >= 0) {
										total = getTotal(p200, p100, p50, p20, p10, p5, p2, p1);
										if (total == 200) {
											counter++;
										}
										else if (total > 200) {
											break;
										}
										p1--;
									}
									p2--;
								}
								p5--;
							}
							p10--;
						}
						p20--;
					}
					p50--;
				}
				p100--;
			}
		}
		
		System.out.print(counter);
	}
	
	private static int getTotal(int p200, int p100, int p50, int p20, int p10, int p5, int p2, int p1) {
		int sum = 0;
		sum += p200 * 200;
		sum += p100 * 100;
		sum += p50 * 50;
		sum += p20 * 20;
		sum += p10 * 10;
		sum += p5 * 5;
		sum += p2 * 2;
		sum += p1 * 1;		
		return(sum);
	}
}
