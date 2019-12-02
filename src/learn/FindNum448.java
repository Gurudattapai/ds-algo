package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNum448 {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		/*int replaced = 0;
		int len = nums.length;
		int num = nums[0];
		//int temp = nums[0];
		while (replaced < len) {
			int temp = nums[num-1];
			nums[num-1] = num;
			num = temp;
			replaced++;
		}*/
		
		//System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			int foundIndex = Math.abs(nums[i]);
			nums[foundIndex-1] = nums[foundIndex-1] < 0 ? nums[foundIndex-1] : nums[foundIndex-1] * -1;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i+1);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(arr));
	}
}
