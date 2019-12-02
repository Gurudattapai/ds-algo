package learn;

import java.util.Arrays;

public class PerfectSquare279 {

	public static int numSquares(int n) {
		int [] dp = new int [n+1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		return go(n, dp);
	}
	
	public static int go(int n, int [] dp) {
		if (dp[n] != -1) {
			return dp[n];
		}
		
		if (isPerfectQuare(n)) {
			dp[n] = 1;
			return dp[n];
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= n/2; i++) {
			min = Math.min(go(i, dp) + go(n-i, dp), min);
		}
		dp[n] = min;
		return dp[n];
	}
	
	public static boolean isPerfectQuare(int n) {
		double sq = Math.sqrt(n); 
		return ((sq - Math.floor(sq)) == 0); 
	}

	public static void main(String[] args) {

		System.out.println(numSquares(10));
	}
}
