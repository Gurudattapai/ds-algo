package learn;

public class BestTimeToBuyAndSellStockWithCooldown309 {

	public static int maxProfit(int[] prices) {
		
		if (prices.length < 2) {
			return 0;
		}
		
		int len = prices.length;
		int [] sell = new int [len];
		int [] noSell = new int [len];
		
		sell[0] = 0;
		noSell[0] = 0;
		noSell[1] = 0;
		sell[1] = prices[1] - prices[0];
		
		for (int i = 2; i < len; i++) {
			noSell[i] = Math.max(sell[i-1], noSell[i-1]);
			sell[i] = Math.max(noSell[i-2] + prices[i] - prices[i-1] , sell[i-1] + prices[i] - prices[i-1]);
		}
		return Math.max(noSell[len-1], sell[len-1]);
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int [] {1,2,3,0,2}));
	}

}
