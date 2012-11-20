package th.c.Leetcode.backtrack;

import java.util.*;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

public class RestoreIPAddress {
	
	// AC
	public static ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> results = new ArrayList<String>();
		if(s.length() > 12 || s.length() < 4) return results;
		helper(s, 0, "", 1, results);
		return results;
    }
	
	public static void helper(String s, int step, String re, int part, ArrayList<String> results) {
		if(step == s.length() && part == 5) {
			results.add(re);
			return;
		}
		
		int x = 0;
		for(int i = step; i < s.length(); i++) {
			x = x*10 + s.charAt(i) - '0';
			if(x < 0 || x > 255) break;
			
			if(re.length() == 0) {
				helper(s, i+1, re+x, part+1, results);
			} else {
				helper(s, i+1, re+"."+x, part+1, results);
			}
			
			if(x == 0) break;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "25525511135";
		System.out.println(restoreIpAddresses(ip));
	}

}
