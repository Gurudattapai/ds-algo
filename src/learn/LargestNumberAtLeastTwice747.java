package learn;

public class LargestNumberAtLeastTwice747 {

	public static int dominantIndex(int[] nums) {
		
		if (nums == null || nums.length < 2) {
			return -1;
		}
		
		int currentMax = nums[0];
		int curMaxIndex = 0;
		int largestIndex = -1;
		for (int i = 1; i < nums.length; i++) {
			if (currentMax < nums[i]) {
				if (nums[i] >= 2* currentMax) {
					largestIndex = i;
				} else {
					largestIndex = -1;
				}
				currentMax = nums[i];
				curMaxIndex = i;
			} else {
				if (currentMax >= 2 * nums[i]) {
					largestIndex = curMaxIndex;
				} else {
					largestIndex = -1;
				}
			}
		}
		return largestIndex;
	}

	public static void main(String[] args) {
		System.out.println(dominantIndex(new int [] {0,2,3,0}));
	}

}
