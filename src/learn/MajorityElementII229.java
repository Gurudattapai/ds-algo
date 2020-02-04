package learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MajorityElementII229 {

	public static List<Integer> majorityElement(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		
		int majorityCount = nums.length/3;
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int count = countMap.getOrDefault(nums[i], 0);
			countMap.put(nums[i], count + 1);
			if (count >= majorityCount) {
				set.add(nums[i]);
			}
		}
		return new ArrayList<Integer>(set);
	}

	public static void main(String[] args) {

	}

}
