package learn;

import java.util.Stack;

public class RemoveAdjDuplicate1047 {

	public static String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
				stack.pop();
			} else {
				stack.push(S.charAt(i));
			}
		}
		StringBuilder str = new StringBuilder();
		while(!stack.isEmpty()) {
			str.insert(0, stack.pop());
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbaca"));
	}

}
