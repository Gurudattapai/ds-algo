package learn;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {

	public static List<String> summaryRanges(int[] nums) {
		
		List<String> list = new ArrayList<>();
		
		if (nums == null || nums.length == 0) {
			return list;
		}
		
		int startIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i-1] != nums[i] - 1) {
				String s = "";
				if (startIndex < i-1) {
					s = nums[startIndex] + "->" + nums[i-1];
				} else {
					s += nums[startIndex]; 
				}
				startIndex = i;
				list.add(s);
			}
		}
		if (startIndex < nums.length - 1) {
			list.add(nums[startIndex] + "->" + nums[nums.length-1]);
		} else {
			list.add(""+nums[nums.length-1]);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(summaryRanges(new int [] {0,2,3,4,6,8,9}));
	}

}
