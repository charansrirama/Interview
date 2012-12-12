package th.c.company.storm8;

import java.util.*;

public class CoinExchange {

	public static int exchange(int T) {
		if(T < 0) return -1;
		int[] money = {25, 10, 5, 1};
		int[] exc = new int[T+1];
		for(int i = 1; i <= T; i++) {
			int min = i;
			for(int j = 0; j < money.length; j++) {
				if(money[j] <= i) {
					min = (exc[i - money[j]]+1 < min) ? exc[i - money[j]]+1 : min;
				}
			}
			exc[i] = min;
		}
		return exc[T];
	}
	
	public static ArrayList<Integer> coinExchange(int T) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int s = Integer.MAX_VALUE;
		if(T < 0) return result;
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		int[] index = new int[T+1];
		Arrays.fill(index, -1);
		index[0] = 0;
		int[] candicates = {25, 10, 5, 1};
		help(candicates, index, T, 0, candicates.length, 0, results);
		for(int i = 0; i < results.size(); i++) 
			if(results.get(i).size() < s) {
				result = results.get(i);
				s = results.get(i).size();
			}
		return result;
	}
	
	public static void help(int[] candicates, int[] index, int T, int sum, int len, int step, ArrayList<ArrayList<Integer>> results) {
		if(sum == T) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i = 1; i <= step; i++) {
				result.add(candicates[index[i]]);
			}
			results.add(result);
		}
		if(sum >= T) return;
		for(int i = index[step]; i < len; i++) {
			index[step+1] = i;
			help(candicates, index, T, sum+candicates[i], len, step+1, results);
			index[step+1] = -1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> r = coinExchange(100);
		System.out.println(r);
	}

}
