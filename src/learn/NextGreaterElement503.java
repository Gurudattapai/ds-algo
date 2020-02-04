package learn;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement503 {

	public static int[] nextGreaterElements(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}

		int[] arr = new int[nums.length];
		Arrays.fill(arr, -1);
		Stack<Integer> s = new Stack<>();
		s.push(0);
		for (int i = 1; i < nums.length; i++) {
			int current = nums[i];
			while (!s.isEmpty() && current > nums[s.peek()]) {
				int peek = s.pop();
				arr[peek] = current;
			}
			s.push(i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int current = nums[i];
			while (!s.isEmpty() && current > nums[s.peek()]) {
				int peek = s.pop();
				arr[peek] = current;
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElements(new int [] {1,2,1})));
	}

}
