package learn;

public class BasicCalculator224 {
	
	public static int calculate(String s) {
		
		int total = 0;
		if (s == null || s.length() == 0) {
			return total;
		}
		boolean foundMinus = false;
		boolean foundPlus = false;
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (Character.isSpace(current) || current == '(' || current == ')') {
				continue;
			}
			if (current == '-') {
				foundMinus = true;
			}
			if (current == '+') {
				foundPlus = true;
			}
			if (Character.isDigit(current)) {
				if (foundMinus) {
					total -= current - '0';
					foundMinus = false;
				} else {
					total += current - '0';
					foundPlus = false;
				}
			}
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

}
