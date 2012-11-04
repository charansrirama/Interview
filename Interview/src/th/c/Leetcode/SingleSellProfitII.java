package th.c.Leetcode;

public class SingleSellProfitII {

	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int profit = 0;
        int min = 0; 
        int max = 0;
        int i = 0;
        while(i < prices.length-1) {
            while(i < prices.length-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            min = prices[i];
            //max = prices[i];
            while(i < prices.length-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            max = prices[i];
            profit += max - min;
        }
        return profit;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
