package th.c.DP;

public class CoinExchange {

	public static int coinExchange(int T) {
		int[] money = {25, 10, 5, 1}; // DESC ORDER
		int moneyKinds = money.length;
		int[] dp = new int[T+1];
		for(int i = 1; i <= T; i++) {
			int minCoins = i;
			for(int kind = 0; kind < moneyKinds; kind++) {
				if(money[kind] <= i) {
					minCoins = (dp[i - money[kind]] + 1) < minCoins ? (dp[i - money[kind]] + 1) : minCoins;
				}
			}
			dp[i] = minCoins;
		}
		return dp[T];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coinExchange(63));
	}

}
