package th.c.Leetcode.DP;

public class BestTimeToBuyAndSellStockII {
	public int maxProfitGreedy(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int max = 0;
        for(int i = 1; i < prices.length; i++) 
            max = prices[i] < prices[i-1] ? max : max+prices[i]-prices[i-1];
        return max;
    }
	
	// Fail at large test case. :)
	public int maxProfitDP(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            int t = dp[i-1];
            for(int j = i-1; j >= 0; j--) {
                int base = j-1 < 0 ? 0 : dp[j-1];
                if(base+prices[i]-prices[j] > t) 
                    t = base+prices[i]-prices[j];
            }
            dp[i] = t;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
