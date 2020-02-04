package learn;

import java.util.Stack;

public class BaseballGame682 {

	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for (int i = 0; i < ops.length; i++) {
			String s = ops[i];
			if (s.equals("+")) {
				if (!stack.isEmpty()) {
					if (stack.size() >= 2) {
						int last = stack.pop();
						int lastToLast = stack.pop();
						int cur = last + lastToLast;
						sum += cur;
						stack.push(lastToLast);
						stack.push(last);
						stack.push(cur);
					} else {
						int last = stack.peek();
						sum += last;
						stack.push(last);
					}
				}
			} else if (s.equals("D")) {
				if (!stack.isEmpty()) {
					int top = stack.peek();
					stack.push(top * 2);
					sum += top * 2;
				}
			} else if (s.equals("C")) {
				if (!stack.isEmpty()) {
					int top = stack.pop();
					sum -= top;
				}
			} else {
				int num = Integer.parseInt(s);
				stack.push(num);
				sum += num;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(calPoints(new String [] {"57","D","-3","-58","D","77","+","C","+","+","38","78","-6","24","-46","+","31","20","D","-81"}));

	}

}
