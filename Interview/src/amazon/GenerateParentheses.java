package amazon;

import java.util.*;

// AC
public class GenerateParentheses {

	public static ArrayList<String> results = new ArrayList<String>();
	public static ArrayList<String> generateParenthesis(int n) {
		results.clear();
		solve(n, 0, "");
		return results;
	}
	
	private static void solve(int openStock, int closeStock, String s) {
		if(openStock == 0 && closeStock == 0) {
			System.out.println(s);
			results.add(s);
		} 
		if(openStock > 0) {
			solve(openStock-1, closeStock+1, s + "(");
		}
		if(closeStock > 0) {
			solve(openStock, closeStock-1, s + ")");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = generateParenthesis(2);
		System.out.println();
		for(String s : list) {
			System.out.println(s);
		}
	}

}
