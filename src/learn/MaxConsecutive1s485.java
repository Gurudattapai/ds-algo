package learn;

public class MaxConsecutive1s485 {

	public static int findMaxConsecutiveOnes(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int max = 0;
		int cur = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				cur++;
			} else {
				max = Math.max(max, cur);
				cur = 0;
			}
		}
		return Math.max(cur, max);
	}

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int [] {1,1,0,1,1,1}));
	}

}
