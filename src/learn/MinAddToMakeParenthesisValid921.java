package learn;

public class MinAddToMakeParenthesisValid921 {

	public static int minAddToMakeValid(String S) {
		if (S == null || S.length() == 0) {
			return 0;
		}
		
		int total = 0;
		int needed = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				total += 1;
			} else if (S.charAt(i) == ')') {
				total += -1;
			}
			if (total < 0) {
				needed++;
				total = 0;
			}
		}
		needed += Math.abs(0 - total);
		return needed;
	}

	public static void main(String[] args) {
		System.out.println(minAddToMakeValid("()))(("));
	}

}
