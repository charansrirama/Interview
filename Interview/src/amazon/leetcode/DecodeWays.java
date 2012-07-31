package amazon.leetcode;

import java.util.*;

public class DecodeWays {
	
	public int numDecodings(String s) {
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		if(s.length() != 0)
			recursion(s, solutions);
		return solutions.size();
	}
	
	private void recursion(String s, ArrayList<Integer> solutions) {
		if(s.length() == 0) {
			solutions.add(1);
		} else {
			int value = Character.getNumericValue(s.charAt(0));
			if(value >= 0 && value <= 9) {
				recursion(s.substring(1), solutions);
			}
			if(s.length() >= 2) {
				int value1 = Character.getNumericValue(s.charAt(0));
				int value2 = Character.getNumericValue(s.charAt(1));
				if(value1 == 1 && value2 >= 0 && value2 <= 9) {
					recursion(s.substring(2), solutions);
				} else if(value1 == 2 && value2 >= 0 && value2 <= 6) {
					recursion(s.substring(2), solutions);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
