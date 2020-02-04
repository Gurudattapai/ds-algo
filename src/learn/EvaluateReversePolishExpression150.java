package learn;

import java.util.Stack;

public class EvaluateReversePolishExpression150 {

	public static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String current = tokens[i];
			if (!(current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/"))) {
				stack.push(Integer.parseInt(current));
			} else {
				int second = stack.pop();
				int first = stack.pop();
				if (current.equals("+")) {
					stack.push(first + second);
				} else if (current.equals("-")) {
					stack.push(first - second);
				} else if (current.equals("*")) {
					stack.push(first * second);
				} else if (current.equals("/")) {
					stack.push(first / second);
				}
			}
		}
		
		return stack.isEmpty() ? 0 : stack.peek();

	}

	public static void main(String[] args) {
		System.out.println(evalRPN(new String [] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}

}
