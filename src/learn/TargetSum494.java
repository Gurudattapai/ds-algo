package learn;

import java.util.HashMap;
import java.util.Map;

public class TargetSum494 {

	public static int findTargetSumWays(int[] nums, int S) {
		if (nums.length == 1) {
			if (Math.abs(S) == Math.abs(nums[0])) {
				return S == 0 ? 2 : 1;
			}
			return 0;
		}
		Map<SizeAndTarget, Integer> map = new HashMap<>();
		int waysWithPlus = find(nums, S-nums[0], 1, map);
		int waysWithMinus = find(nums, S+nums[0], 1, map);
		int ways = waysWithPlus + waysWithMinus;
		return ways;
	}
	
	public static int find(int [] nums, int s, int start, Map<SizeAndTarget, Integer> map) {
		SizeAndTarget target = new SizeAndTarget((nums.length - 1) - start + 1, s);
		if (map.containsKey(target)) {
			return map.get(target);
		}
		if (start == nums.length - 1) {
			int numOfWays = 0;
			if (Math.abs(nums[start]) == Math.abs(s)) {
				numOfWays = s == 0 ? 2 : 1;
			}
			map.put(target, numOfWays);
			return numOfWays;
		}
		int waysWithPlus = find(nums, s-nums[start], start+1, map);
		int waysWithMinus = find(nums, s+nums[start], start+1, map);
		int ways = waysWithPlus + waysWithMinus;
		map.put(target, ways);
		return ways;
	}

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int [] {1000}, -1000));
	}

}

class SizeAndTarget {
	int size;
	
	int target;

	public SizeAndTarget(int size, int target) {
		super();
		this.size = size;
		this.target = target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + size;
		result = prime * result + target;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeAndTarget other = (SizeAndTarget) obj;
		if (size != other.size)
			return false;
		if (target != other.target)
			return false;
		return true;
	}
}
