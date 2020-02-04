package learn;

import java.util.Stack;

public class MinRemoveForValidParanthesis1249 {

	public static String minRemoveToMakeValid(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int notAddedChars = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i - notAddedChars);
				sb.append(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					notAddedChars++;
					continue;
				} else {
					sb.append(s.charAt(i));
					stack.pop();
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		while (!stack.isEmpty()) {
			int index = stack.pop();
			sb.delete(index, index + 1);
		}
		return sb.length() == 0 ? "" : sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("))(("));
	}

}
