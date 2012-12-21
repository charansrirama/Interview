package th.c.Leetcode.DP;

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int N = prices.length;
		int min = prices[0];
		int[] left = new int[N];
		for(int i = 1; i < N; i++) {
			if(prices[i] < min) min = prices[i];
			left[i] = Math.max(left[i-1], prices[i]-min);
		}
		int max = prices[N-1];
		int[] right = new int[N];
		for(int i = N-2; i >= 0; i--) {
			if(prices[i] > max) max = prices[i];
			right[i] = Math.max(right[i-1], max-prices[i]);
		}
		int res = 0;
		for(int i = 0; i < N; i++) {
			res = Math.max(res, left[i]+right[i]);
		}
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
