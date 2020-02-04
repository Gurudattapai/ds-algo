package learn;

import java.util.Arrays;

public class BestTimeToBuyAndSell714 {

	public static int maxProfit(int[] prices, int fee) {
		
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int [] profits = new int [prices.length + 1];
		Arrays.fill(profits, Integer.MIN_VALUE);
		profits[0] = 0;
		profits[1] = 0;
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {
			for (int j = 0; j < i; j++) {
				int profit = prices[i] - prices[j] - fee;
				profits[i+1] = Math.max(profits[i+1], profit + profits[j]);
				max = Math.max(max, profits[i+1]);
			}
		}
		
		return max;

	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int [] {1, 3, 7, 5, 10, 3}, 3));
	}

}
