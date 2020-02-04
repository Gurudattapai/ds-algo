package learn;

import java.util.Stack;

public class ScoreOfParenthesis856 {

	public static int scoreOfParentheses(String S) {
		
		if (S == null || S.length() == 0) {
			return 0;
		}
		
		int max = 0;
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(') {
				stack.push(S.charAt(i) + "");
			} else {
				int total = 0;
				boolean isPresent = false;
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					isPresent = true;
					total += Integer.parseInt(stack.pop());
				}
				total = total == 0 ? 1 : total;
				total = isPresent ? total * 2 : total;
				stack.pop();
				stack.push(total+"");
			}
		}
		while (!stack.isEmpty()) {
			max += Integer.parseInt(stack.pop());
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(scoreOfParentheses("(()(()))"));
	}

}
