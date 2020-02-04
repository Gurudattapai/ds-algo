package learn;

public class MinCostClimbingStairs746 {
	
	public static int minCostClimbingStairs(int[] cost) {
		
		if (cost == null || cost.length < 2) {
			return 0;
		}
		
		int [] dp = new int [cost.length + 1];
		dp [0] = cost[0];
		dp [1] = cost[1];
		
		for (int i = 2; i < cost.length; i++) {
			dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
		}
		
		dp [dp.length - 1] = Math.min(dp[dp.length - 2], dp[dp.length - 3]);
		return dp [dp.length - 1];
		
	}

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int [] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

}
