package learn;

import java.util.Stack;

public class LargestRectangleInHistogram84 {

	public static int largestRectangleArea(int[] heights) {
		
		int largestArea = 0;
		if (heights == null || heights.length == 0) {
			return largestArea;
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < heights.length; i++) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
					int topHeight = heights[stack.pop()];
					if (stack.isEmpty()) {
						largestArea = Math.max(largestArea, (topHeight * i));
					} else {
						largestArea = Math.max(largestArea, (topHeight * (i - stack.peek() - 1)));
					}
				}
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int topHeight = heights[stack.pop()];
			if (stack.isEmpty()) {
				largestArea = Math.max(largestArea, (topHeight * heights.length));
			} else {
				largestArea = Math.max(largestArea, (topHeight * (heights.length - stack.peek() - 1)));
			}
		}
		return largestArea;
	}

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int [] {2,1,5,6,2,3}));
	}

}
