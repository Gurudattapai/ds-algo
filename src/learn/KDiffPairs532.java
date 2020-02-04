package learn;

import java.util.HashSet;
import java.util.Set;

public class KDiffPairs532 {

	public static int findPairs(int[] nums, int k) {
		
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		Set<Integer> seen = new HashSet<>();
		Set<Integer> pair = new HashSet<>();
		int count = 0;
		for (int  i = 0; i < nums.length ; i++) {
			int plus = k + nums[i];
			int minus = -k + nums[i];
			if (seen.contains(plus)) {
				if (!(pair.contains(nums[i]) && pair.contains(plus))) {
					count++;
					pair.add(plus);
					pair.add(nums[i]);
				}
			}
			if (seen.contains(minus)) {
				if (!(pair.contains(nums[i]) && pair.contains(minus))) {
					count++;
					pair.add(minus);
					pair.add(nums[i]);
				}
			}
			seen.add(nums[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findPairs(new int [] {2,9,0,8,9,6,5,9,8,1,9,6,9,2,8,8,7,5,7,8,8,3,7,4,1,1,6,2,9,9,3,9,2,4,6,5,6,5,1,5,9,9,8,1,4,3,2,8,5,3,5,4,5,7,0,0,7,6,4,7,2,4,9,3,6,6,5,0,0,0,8,9,9,6,5,4,6,2,1,3,2,5,0,1,4,2,6,9,5,4,9,6,0,8,3,8,0,0,2,1}, 1));
	}

}
