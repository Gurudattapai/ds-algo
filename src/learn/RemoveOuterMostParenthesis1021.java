package learn;

import java.util.Stack;

public class RemoveOuterMostParenthesis1021 {

	public static String removeOuterParentheses(String S) {
		
		if (S == null || S.length() == 0) {
			return "";
		}
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (stack.isEmpty() || S.charAt(i) == '(') {
				stack.push(S.charAt(i));
				if (stack.size() > 1) {
					sb.append(S.charAt(i));
				}
			} else if (S.charAt(i) == ')') {
				char c = stack.pop();
				if (!stack.isEmpty()) {
					sb.append(S.charAt(i));
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("()()"));
	}

}
