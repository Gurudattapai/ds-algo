package learn;

public class ContinuousSubarraySum523 {

	public static boolean checkSubarraySum(int[] nums, int k) {
		int len = nums.length;
		//int [][] dp = new int [len][len];
		/*for (int i = 0; i < len; i++) {
			dp [i][i] = nums[i];
		}*/
		for (int i = 0; i < len; i++) {
			int prev = nums[i];
			for (int j = i + 1; j < len; j++) {
				//if (j <= i) {
				//	continue;
				//}
				//dp[i][j] = dp[i][j-1] + nums[j];
				prev += nums[j]; 
				if (k == 0 && prev == 0) {
					return true;
				} else if (k != 0 && prev % k == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkSubarraySum(new int [] {5,6,2,5,7,0,7,4,1,6,9,5,0,8,2,1,2,0,9,8,1,7,8,5,2,0,1,8,4,4,3,9,6,9,2,1,3,6,3,2,0,9,6,0,4,0,8,5,2,9,0,5,1,3,7,3,7,3,8,0,3,5,1,2,8,4,2,1,6,8,7,1,0,5,7,4,0,7,5,8,0,9,9,8,5,7,6,0,3,8,1,8,1,6,9,4,7,9,5,9,1,6,3,8,4,2,5,3,4,3,6,1,8,2,3,4,7,1,8,5,6,1,4,1,8,1,0,4,3,1,7,8,3,5,8,8,7,6,5,3,1,9,9,4,1,3,7,6,8,1,3,2,6,4,5,1,6,5,3,7,7,2,1,0,1,9,5,4,5,1,7,9,2,6,2,1,0,1,2,8,2,1,8,4,5,1,7,8,6,7,2,9,9,1,9,3,1,5,2,0,7,2,3,1,3,2,3,4,6,6,3,6,7,2,6,4,5,8,6,8,1,3,5,9,7,5,6,8,8,8,3,0,8,9,2,5,6,4,5,3,3,3,3,6,6,6,7,3,4,8,9,9,4,7,2,7,7,8,2,7,6,3,5,5,2,2,1,5,3,1,3,1,3,9,4,0,8,1,2,2,9,1,9,6,5,1,3,4,3,4,7,1,7,7,2,2,1,5,6,9,7,8,7,4,3,8,7,6,5,3,9,3,2,1,4,0,8,2,9,7,3,3,7,5,1,7,0,9,2,1,4,6,1,2,7,5,8,7,1,7,1,2,9,4,2,8,3,4,0,0,0,4,7,7,9,4,5,7,0,3,1,0,1,7,8,8,2,9,7,3,6,0,1,1,9,2,2,1,1,0,1,6,8,4,0,7,8,8,4,2,6,8,4,4,6,1,7,0,7,3,5,7,7,3,8,5,8,6,8,8,4,2,8,5,5,9,3,3,3,9,5,0,7,6,2,5,2,9,5,4,0,1,5,9,6,3,6,7,4,5,2,6,8,4,9,2,3,2,7,4,0,4,2,5,9,6,9,1,4,8,1,9,5,5,9,0,4,5,8,4,0,2,5,5,8,9,4,3,0,2,9,8,3,9,8,5,4,6,5,6,7,5,9,0,3,2,4,3,1,0}, 3092));
	}

}