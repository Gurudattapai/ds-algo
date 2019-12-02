package learn;

public class PeakElement162 {

	public static int findPeakElement(int[] nums) {
		
		if (nums.length == 1) {
			return 0;
		}
		
		return find(nums, 0, nums.length - 1);
	}
	
	public static int find(int [] nums, int start, int end) {
		
		if (end < start) {
			return -1;
		}
		
		int mid = (start + end) / 2;
		
		if (mid == 0 && nums[mid] > nums[mid + 1]) {
			return mid;
		}
		
		if (mid == nums.length -1 && nums[mid] > nums[mid - 1]) {
			return mid;
		}
		
		if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return mid;
		}
		
		int newmid = find(nums, mid + 1, end);
		if (newmid != -1) {
			return newmid;
		} else {
			newmid = find(nums, start, mid - 1);
		}
		
		return newmid == -1 ? -1 : newmid;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {1,2,1,3,5,6,4};
		System.out.println(findPeakElement(arr));
	}

}
