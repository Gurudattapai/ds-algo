package learn;

import java.util.Arrays;

public class IntegerBreak343 {

	public static int integerBreak(int n) {
		
		int [] dp = new int [n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		int max = 0;
		for (int i = 1; i <= n/2; i++) {
			max =  Math.max(max, Math.max(i, getMax(i, dp)) * Math.max(n - i, getMax(n - i, dp)));
		}
		return max;
	}

	private static int getMax(int num, int[] dp) {
		if (num <= 0) {
			return 0;
		}
		if (dp[num] != -1) {
			return dp[num];
		}
		int max = 0;
		for (int i = 1; i <= num/2; i++) {
			max =  Math.max(max, Math.max(i, getMax(i, dp)) * Math.max(num - i, getMax(num - i, dp)));
		}
		dp[num] = max;
		return dp[num];
	}

	public static void main(String[] args) {
		System.out.println(integerBreak(6));
	}

}
