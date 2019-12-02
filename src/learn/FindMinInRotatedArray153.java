package learn;

public class FindMinInRotatedArray153 {

	public static int findMin(int[] nums) {
		return findMin(nums, 0, nums.length - 1);
	}
	
	public static int findMin(int [] nums, int start, int end) {
		if (start == end) {
			return nums[start];
		}
		int mid = (start + end) / 2;
		if (mid == start && nums[start] <= nums[end]) {
			return nums[start];
		} 
		if (mid == end && nums[end] <= nums[start]) {
			return nums[end];
		}
		if (mid > 0 && mid < end && nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
			return nums[mid];
		}
		if (nums[end] > nums[mid]) {
			return findMin(nums, start, mid-1);
		}
		if (nums[end] == nums[mid]) {
			/*if (nums[mid+1] < nums[mid]) {
				return findMin(nums, mid+1, end);
			}
			if (nums[mid-1] < nums[mid]){
				return findMin(nums, start, mid-1);
			}
			if (nums[mid+1] == nums[mid]) {
				return findMin(nums, mid+1, end);
			}
			if (nums[mid-1] == nums[mid]) {
				return findMin(nums, start, mid-1);
			}*/
			return Math.min(findMin(nums, start, mid-1), findMin(nums, mid+1, end));
		}
		return findMin(nums, mid+1, end);
	}

	public static void main(String[] args) {
		int [] arr = new int [] {2,2,0,0,1,1};
		System.out.println(findMin(arr));
	}

}
