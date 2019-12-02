package learn;

public class RemoveDupFromSortedArray26 {

	public static int removeDuplicates(int[] nums) {
		int index = -1;
		boolean flag = false;
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i+1]) {
				count++;
				flag = true;
				if (index == -1) {
					index = i+1;
					i++;
				} else {
					continue;
				}
			} else {
				if (index != -1 && flag) {
					swap(nums, index, i);
					index++;
					flag = false;
				}
			}
		}
		if (index != -1) {
			swap(nums, index, nums.length - 1);
			flag = false;
		}
		return nums.length - count;
	}

	private static void swap(int[] nums, int index, int i) {
		int temp = nums[i];
		nums[i] = nums[index];
		nums[index] = temp;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {1,1,2};
		System.out.print(removeDuplicates(arr));
	}

}
