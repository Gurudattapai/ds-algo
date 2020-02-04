package learn;

import java.util.Stack;

public class LongestValidParenthesis32 {

	public static int longestValidParentheses(String s) {
		
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int count = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			int current = s.charAt(i);
			if (current == ')') {
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
					count += 2;
				}
			} else {
				stack.push('(');
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(()"));

	}

}
