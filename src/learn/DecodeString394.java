package learn;

import java.util.Stack;

public class DecodeString394 {

	public static String decodeString(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if ((!stack.isEmpty() || Character.isDigit(s.charAt(i))) && s.charAt(i) != ']') {
				if (Character.isDigit(s.charAt(i))) {
					int bracketIndex = s.indexOf('[', i);
					stack.push(s.substring(i, bracketIndex));
					i = bracketIndex - 1;
				} else {
					stack.push(s.charAt(i) + "");
				}
				continue;
			}
			if (s.charAt(i) == ']') {
				String tempString = "";
				while(!stack.peek().equals("[")) {
					tempString = stack.pop() + tempString;
				}
				stack.pop();
				int digit = Integer.parseInt(stack.pop());
				String currentString = "";
				for (int k = 0; k < digit; k++) {
					currentString += tempString;
				}
				if (stack.isEmpty()) {
					sb.append(currentString);
				} else {
					stack.push(currentString);
				}
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(decodeString("100[leetcode]"));
	}

}
