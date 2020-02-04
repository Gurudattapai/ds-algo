package learn;

import java.util.Stack;

public class MaximalRectangle85 {

	public static int maximalRectangle(char[][] matrix) {
		
		if(matrix == null) {
			return 0;
		}
		
		int [] arr = new int [matrix[0].length];
		int maxArea = -1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] - '0' == 0) {
					arr[j] = 0;
				} else {
					arr[j] = arr[j] + matrix[i][j] - '0';
				}
			}
			maxArea = Math.max(maxArea, checkMaxAreaForCurrent(arr));
		}
		return maxArea;
	}

	private static int checkMaxAreaForCurrent(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			if (!stack.isEmpty()) {
				int peek = stack.peek();
				if(arr[peek] <= arr[i]) {
					stack.push(i);
				} else {
					while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
						int top = stack.pop();
						if (stack.isEmpty()) {
							max = Math.max(max, arr[top] * i);
						} else {
							max = Math.max(max, arr[top] * (i - stack.peek() - 1));
						}
					}
					stack.push(i);
				}
			} else {
				stack.push(i);
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (stack.isEmpty()) {
				max = Math.max(max, arr[top] * arr.length);
			} else {
				max = Math.max(max, arr[top] * (arr.length - stack.peek() - 1));
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		System.out.println(checkMaxAreaForCurrent(new int [] {2,3,1,5,1,8}));
	}

}
