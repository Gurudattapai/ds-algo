package learn;

public class MaxProductSubArray152 {

	public static int maxProduct(int[] nums) {
		int prev = nums[0];
		int cur = nums[0];
		int all = nums[0];
		int total = nums[0];
		for (int i = 1; i < nums.length; i++) {
			cur = nums[i];
			total *= cur;
			if (prev != 0) {
				cur = Math.max(cur, cur * prev);
			}
			all = Math.max(cur, Math.max(all, total));
			prev = cur;
		}
		return all;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {2,-5,-2,-4,3};
		System.out.println(maxProduct(arr));
	}

}

