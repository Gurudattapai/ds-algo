package learn;

import java.util.Stack;

public class ValidateStackSequence946 {

	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		stack.push(pushed[0]);

		int popIndex = 0;
		int pushIndex = 1;
		while (true) {
			if (!stack.isEmpty() && popIndex < popped.length && popped[popIndex] == stack.peek()) {
				stack.pop();
				popIndex++;
				continue;
			}
			if (pushIndex == pushed.length && popIndex < popped.length) {
				break;
			}
			if (pushIndex == pushed.length && popIndex == popped.length) {
				break;
			}
			if (pushIndex < pushed.length) {
				stack.push(pushed[pushIndex]);
				pushIndex++;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(validateStackSequences(new int [] {1,2,3,4,5}, new int [] {5,4,3,2,1}));

	}

}
