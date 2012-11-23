package th.c.Leetcode.DP;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int[] dp = new int[prices.length];
		dp[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			dp[i] = (prices[i] - min) > dp[i - 1] ? (prices[i] - min)
					: dp[i - 1];
			min = prices[i] < min ? prices[i] : min;
		}
		return dp[prices.length - 1];
	}
}
