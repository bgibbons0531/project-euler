
public class Solver {
	public static void main(String[] args) {
		//Declaration
		int yearInitial = 1900;
		int yearFinal = 2000;
		int daysInMonth;
		int dayOfWeek = 1;
		int counter = 0;
		
		//Solve
		for (int year = yearInitial; year <= yearFinal; year++) {
			for (int month = 1; month <= 12; month++) {
				daysInMonth = getDaysInMonth(month, year); //Set days in month
				for (int day = 1; day <= daysInMonth; day++) {
					if (dayOfWeek == 7 && day == 1 && year > yearInitial) { //Check if Sunday is on the first
						counter++;
					}
					if (dayOfWeek < 7) {  //Add a day if not Sunday
						dayOfWeek++;
					}
					else { //Reset to Monday
						dayOfWeek = 1;
					}
				}
			}
		}
		System.out.print(counter);
	}
	
	private static int getDaysInMonth(int month, int year) {
		if (month == 2) { //February
			if (year == 1900) {
				return(28);
			}
			if (year % 4 == 0) {
				return(29);
			}
			else {
				return(28);
			}
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return(31);
		}
		else {
			return(30);
		}
	}
}
