package learn;

public class PredictWinner486 {

	public static boolean PredictTheWinner(int[] nums) {
		int[] arr1 = new int[2];
		int[] arr2 = new int[2];
		
		update(nums, 1, nums.length-1, arr1, 1);
		update(nums, 0, nums.length-2, arr2, 1);
		return (nums[0] + arr1[0] > arr1[1] || nums[nums.length-1] + arr2[0] > arr2[1]);
	}

	public static int update(int[] nums, int start, int end, int[] arr, int player) {
		if (start > end) {
			return 0;
		}

		if (end - start == 1) {
			if (nums[start] > nums[end]) {
				arr[player] = arr[player] + nums[start];
				arr[(player + 1) % 2] = arr[(player + 1) % 2] + nums[end];
				return arr[player];
			} else {
				arr[player] = arr[player] + nums[end];
				arr[(player + 1) % 2] = arr[(player + 1) % 2] + nums[start];
				return arr[player];
			}

		}
		int[] arr1 = new int[2];
		int[] arr2 = new int[2];
		update(nums, start + 1, end, arr1, player == 0 ? 1 : 0);
		update(nums, start, end - 1, arr2, player == 0 ? 1 : 0);
		if (nums[start] + arr1[player] > nums[end] + arr2[player]) {
			arr[player] = arr[player] + nums[start] + arr1[player];
			arr[(player + 1) % 2] = arr1[(player + 1) % 2];
		} else {
			arr[player] = arr[player] + nums[start] + arr2[player];
			arr[(player + 1) % 2] = arr2[(player + 1) % 2];
		}
		return arr[player];
	}

	public static void main(String[] args) {
		int [] nums = new int [] {1, 5, 233, 7};
		System.out.println(PredictTheWinner(nums));
	}

}
