package learn;

import java.util.Arrays;

public class CoinChange322 {

	public static int coinChange(int[] coins, int amount) {
		
		if (coins.length == 1 && amount % coins[0] != 0) {
			return -1;
		}
		Arrays.sort(coins);
		
		int [][] dp = new int [coins.length][amount+1];
		
		for (int j = 0; j < amount+1; j++) {
			if (coins[0] > j) {
				dp[0][j] = 0;
			} else {
				dp[0][j] = j / coins[0];
			}
		}
		
		for (int i = 1; i < coins.length; i++) {
			for (int j = 1; j < amount + 1; j++) {
				if (coins[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i]]);
				}
			}
		}
		return dp[coins.length-1][amount];
	}

	public static void main(String[] args) {
		System.out.println(coinChange(new int [] {2}, 3));
	}

}
