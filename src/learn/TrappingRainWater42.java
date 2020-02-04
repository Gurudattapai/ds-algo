package learn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TrappingRainWater42 {

	public static int trap(int[] height) {

		if (height == null || height.length == 0) {
			return 0;
		}

		int index = 0;
		while (index < height.length && height[index] == 0) {
			index++;
		}

		int totalWater = 0;
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> done = new HashMap<>();
		stack.push(index);
		for (int i = index + 1; i < height.length; i++) {
			if (stack.isEmpty() || height[stack.peek()] > height[i]) {
				stack.push(i);
			} else {
				int current = stack.peek();
				while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
					current = stack.pop();
				}
				int total = 0;
				if (!stack.isEmpty()) {
					int minHeight = Math.min(height[i], height[stack.peek()]);
					total += (i - stack.peek() - 1) * minHeight;
					int curIndex = stack.peek() + 1;
					while (curIndex < i) {
						total -= (done.get(curIndex) == null ? height[curIndex] : done.get(curIndex));
						done.put(curIndex, minHeight);
						curIndex++;
					}
				} else {
					int minHeight = Math.min(height[i], height[current]);
					total += (i - current - 1) * minHeight;
					int curIndex = current + 1;
					while (curIndex < i) {
						total -= (done.get(curIndex) == null ? height[curIndex] : done.get(curIndex));
						curIndex++;
					}
				}
				stack.push(i);
				totalWater += total;
			}
		}
		return totalWater;
	}

	public static void main(String[] args) {
		System.out.println(trap(new int[] {4,2,0,3,2,5}));
	}

}
