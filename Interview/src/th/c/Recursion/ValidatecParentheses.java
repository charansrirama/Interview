package th.c.Recursion;

import java.util.*;

public class ValidatecParentheses {
	
	public static ArrayList<String> generateParentheses(int n) {
		ArrayList<String> results = new ArrayList<String>();
		if(n <= 0) return results;
		helper(results, 0,0,n,"");
		return results;
	}
	
	private static void helper(ArrayList<String> results, int open, int close, int n, String par) {
		if(open < close) return;
		if(open == n && close == n) {
			results.add(par);
			return;
		}
		if(open < n) {
			helper(results, open+1, close, n, par+"(");
		} 
		if(close < n) {
			helper(results, open, close+1, n, par+")");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> re = generateParentheses(3);
		for(String s : re) {
			System.out.println(s);
		}
	}

}
