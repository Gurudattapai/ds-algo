package learn;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

	public static int[] dailyTemperatures(int[] T) {
		
		if (T == null || T.length == 0) {
			return new int [0];
		}
		
		int [] arr = new int [T.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < T.length; i++) {
			if (stack.isEmpty() || T[stack.peek()] >= T[i]) {
				stack.push(i);
			} else {
				while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
					int top = stack.pop();
					arr[top] = i - top;
				}
				stack.push(i);
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(dailyTemperatures(new int [] {73, 74, 75, 71, 69, 72, 76, 73})));
	}

}
