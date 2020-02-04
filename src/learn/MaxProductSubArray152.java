package learn;

public class MaxProductSubArray152 {

	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = nums[0];
		int cur_max = nums[0];
		int cur_min = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int temp = cur_max;
			cur_max = Math.max(Math.max(temp * nums[i], cur_min * nums[i]), nums[i]);
			cur_min = Math.min(Math.min(temp * nums[i], cur_min * nums[i]), nums[i]);
			if (max < cur_max) {
				max = cur_max;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {2,-5,-2,-4,3};
		System.out.println(maxProduct(arr));
	}

}

