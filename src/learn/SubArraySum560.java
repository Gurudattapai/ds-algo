package learn;

public class SubArraySum560 {

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		int index = 0;
		int currentSum = nums[index];
		if (nums[0] == k) {
			count++;
		}
		for(int i = 1; i < nums.length; i++) {
			if (nums[i] == k) {
				count++;
			}
			currentSum += nums[i];
			if (currentSum == k) {
				count++;
			} else if (currentSum > k) {
				while (currentSum >= k && index < i - 1) {
					currentSum -= nums[index];
					index++;
					if (currentSum == k) {
						count++;
					}
				}
			}
		}
		if (currentSum < k) {
			while (index < nums.length - 2) {
				currentSum -= nums[index];
				index++;
				if (currentSum == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {1,2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2};
		System.out.println(subarraySum(arr, 12));
	}

}
