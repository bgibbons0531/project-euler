
public class Word {
	//Declaration
	String currentNum;
	String numWord;
	int digitCount;
	char oneDigit;
	char tenDigit;
	char hundredDigit;
	
	public Word(String num) {
		//Set word
		numWord = "";
		currentNum = num;
		digitCount = num.length();
		//Set digits
		if (digitCount == 3) {
			hundredDigit = currentNum.charAt(0);
			tenDigit = currentNum.charAt(1);
			oneDigit = currentNum.charAt(2);
		}
		else if (digitCount == 2) {
			hundredDigit = '0';
			tenDigit = currentNum.charAt(0);
			oneDigit = currentNum.charAt(1);
		}
		else if (digitCount == 1) {
			hundredDigit = '0';
			tenDigit = '0';
			oneDigit = currentNum.charAt(0);
		}
		//Four digit case
		if (digitCount == 4) {
			numWord = "onethousand";
		}
		//Set hundred digit
		else if (hundredDigit != '0') {
			numWord = toLetters(hundredDigit) + "hundred"; //Add number and the hundred
			//Check if there are any more
			if (tenDigit != '0' || oneDigit != '0') {
				numWord += "and";
			}
		}
		//Set tens digit
		if (tenDigit != '1') {
			if (tenDigit != '0') {
				if (tenDigit == '9') {
					numWord += "ninety";
				}
				else if (tenDigit == '8') {
					numWord += "eighty";
				}
				else if (tenDigit == '7') {
					numWord += "seventy";
				}
				else if (tenDigit == '6') {
					numWord += "sixty";
				}
				else if (tenDigit == '5') {
					numWord += "fifty";
				}
				else if (tenDigit == '4') {
					numWord += "forty";
				}
				else if (tenDigit == '3') {
					numWord += "thirty";
				}
				else if (tenDigit == '2') {
					numWord += "twenty";
				}
			}
			//Set ones digit
			numWord += toLetters(oneDigit);
		}
		//Set rest if number 10 through 19
		else if (tenDigit == '1') {
			if (oneDigit == '0') {
				numWord += "ten";
			}
			else if (oneDigit == '1') {
				numWord += "eleven";
			}
			else if (oneDigit == '2') {
				numWord += "twleve";
			}
			else if (oneDigit == '3') {
				numWord += "thirteen";
			}
			else if (oneDigit == '4') {
				numWord += "fourteen";
			}
			else if (oneDigit == '5') {
				numWord += "fifteen";
			}
			else if (oneDigit == '6') {
				numWord += "sixteen";
			}
			else if (oneDigit == '7') {
				numWord += "seventeen";
			}
			else if (oneDigit == '8') {
				numWord += "eighteen";
			}
			else if (oneDigit == '9'){
				numWord += "nineteen";
			}
		}
	}
	
	//Get methods
	public String getWord() {
		return(numWord);
	}
	
	//Private methods
	private String toLetters(char c) {
		if (c == '1') { return("one"); }
		else if (c == '2') { return("two"); }
		else if (c == '3') { return("three"); }
		else if (c == '4') { return("four"); }
		else if (c == '5') { return("five"); }
		else if (c == '6') { return("six"); }
		else if (c == '7') { return("seven"); }
		else if (c == '8') { return("eight"); }
		else if (c == '9') { return("nine"); }
		else { return(""); }
	}
}
