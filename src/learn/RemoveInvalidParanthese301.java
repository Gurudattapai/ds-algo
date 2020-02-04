package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class RemoveInvalidParanthese301 {

	public static List<String> removeInvalidParentheses(String s) {

		if (s == null || s.length() == 0) {
			return null;
		}

		if (isValid(s)) {
			return Arrays.asList(new String[] { s });
		}

		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		Set<String> set = new HashSet<>();
		q.add(s);
		visited.add(s);
		q.add(null);
		while (!q.isEmpty()) {
			String current = q.poll();
			if (current == null) {
				if (!set.isEmpty()) {
					break;
				}
				if (q.isEmpty()) {
					break;
				}
				q.add(null);
				continue;
			}
			visited.add(current);
			StringBuilder sb = new StringBuilder(current);
			for (int i = 0; i < sb.length(); i++) {
				String newString = sb.substring(0, i) + sb.substring(i + 1);
				if (isValid(newString)) {
					set.add(newString);
				} else {
					q.add(newString);
					visited.add(newString);
				}
			}
		}
		return new ArrayList<>(set);
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '}') {
				stack.push(s.charAt(i));
			} else if ((s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
				if (!stack.isEmpty()) {
					if (s.charAt(i) == ')') {
						if (stack.peek() != '(') {
							return false;
						}
					} else if (s.charAt(i) == ']') {
						if (stack.peek() != '[') {
							return false;
						}
					} else if (s.charAt(i) == '}') {
						if (stack.peek() != '{') {
							return false;
						}
					}
				} else {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();

	}

	public static void main(String[] args) {
		List<String> list = removeInvalidParentheses("()((((((()l(");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
