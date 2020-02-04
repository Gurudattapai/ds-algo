package learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumberIII260 {

	public static int[] singleNumber(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return new int [0];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		int [] arr = new int [2];
		int index = 0;
		for (int i : map.keySet()) {
			if (map.get(i) == 1) {
				arr[index++] = i;
			}
		}
		return arr;

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(singleNumber(new int [] {1,2,1,3,2,5})));
	}

}
