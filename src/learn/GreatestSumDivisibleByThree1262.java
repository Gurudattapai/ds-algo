package learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreatestSumDivisibleByThree1262 {

	public static int maxSumDivThree(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int sum = 0;
		Set<Integer> seenIndex = new HashSet<>();
		Map<Integer, Integer> dp = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 3 == 0) {
				sum += nums[i];
				seenIndex.add(i);
			}
		}
		
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (seenIndex.contains(i)) {
				continue;
			}
			int total = go(nums, i+1, seenIndex, dp);
			if ((total + nums[i]) % 3 == 0) {
				max = Math.max(max, total + nums[i]);
			}
		}
		sum += max;
		return sum;
	}

	private static int go(int[] nums, int index, Set<Integer> seenIndex, Map<Integer, Integer> dp) {
		if (index >= nums.length) {
			return 0;
		}
		
		if (index == nums.length - 1) {
			dp.put(index, nums[index]);
			return nums[index];
		}
		
		if (dp.containsKey(index)) {
			return dp.get(index);
		}
		
		for (int i = index + 1; i < nums.length; i++) {
			if (seenIndex.contains(i)) {
				continue;
			}
			int total = go(nums, i+1, seenIndex, dp) + nums[index];
			dp.put(index, total);
		}
		return dp.get(index);
	}

	public static void main(String[] args) {
		System.out.println(maxSumDivThree(new int [] {1,2,3,4,4}));
	}

}
