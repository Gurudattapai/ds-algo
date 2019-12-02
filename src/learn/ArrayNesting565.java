package learn;

import java.util.HashSet;
import java.util.Set;

public class ArrayNesting565 {
	
	public static int arrayNesting(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				continue;
			}
			Set<Integer> child = new HashSet<>();
			int num = nums[i];
			while (child.add(num)) {
				set.add(num);
				num = nums[num];
			}
			max = Math.max(max, child.size());
		}
		return max;
	}
	
	public static void main(String[] args) {
		int [] arr = new int [] {5,4,0,3,1,6,2};
		System.out.println(arrayNesting(arr));
	}
}
