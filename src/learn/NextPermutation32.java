package learn;

import java.util.Arrays;

public class NextPermutation32 {

	public static void nextPermutation(int[] nums) {
		int index = nums.length - 1;
		while (index > 0) {
			if (nums[index] <= nums [index - 1]) {
				index--;
			} else {
				break;
			}
		}
		if (index > 0) {
			int pos = findElementGreater(nums, index, nums[index-1]);
			swap(nums, pos, index-1);
		}
		reverse(nums, index);
	}

	private static void swap(int[] nums, int index, int i) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums [i] = temp;
	}
	
	private static void reverse(int [] nums, int index) {
		int i = index;
		int j = nums.length - 1;
		while (i <= j) {
			swap(nums, i, j);
			j--;
			i++;
		}
	}
	
	private static int findElementGreater(int nums [], int index, int num) {
		int minIndex = index;
		int minElement = nums[index];
		for (int i = index + 1; i < nums.length; i++) {
			if (nums [i] <= minElement && nums[i] > num) {
				minIndex = i;
				minElement = nums [i];
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {1, 3, 3, 2};
		nextPermutation(arr);
		System.out.print(Arrays.toString(arr));
	}

}
