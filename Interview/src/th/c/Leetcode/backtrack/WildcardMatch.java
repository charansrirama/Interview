package th.c.Leetcode.backtrack;

import java.util.Arrays;

public class WildcardMatch {

	public boolean isMatch2(String s, String p) {
		if (s == null || s.equals("")) {
			int i = 0;
			while (i < p.length() && p.charAt(i) == '*') {
				i++;
			}
			if (i == p.length())
				return true;
			else
				return false;
		}
		if (p == null || p.equals(""))
			return false;
		boolean hasAsterisk = false;
		int i = 0;
		int j = 0;
		while ((j < p.length() && p.charAt(j) != '*') && i < s.length()) {
			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
				i++;
				j++;
			} else
				return false;
		}
		while (j < p.length()) {
			if (p.charAt(j) == '*') {
				hasAsterisk = true;
				j++;
				continue;
			}
			int ii = i;
			int jj = j;
			while (i < s.length() && (j < p.length() && p.charAt(j) != '*')) {
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
					i++;
					j++;
				} else {
					i = ii++;
					j = jj;
				}
			}
			if (i == s.length()) {
				int k = j;
				while (k < p.length() && p.charAt(k) == '*') {
					k++;
				}
				if (k == p.length())
					return true;
				else
					return false;
			}
		}
		if (i < s.length()) {
			if (!hasAsterisk)
				return false;
			if (p.charAt(j - 1) == '*')
				return true;
			while (i + 1 < s.length())
				i++;
			while (p.charAt(j - 1) != '*'
					&& (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
				i--;
				j--;
			}
			if (p.charAt(j - 1) == '*')
				return true;
			else
				return false;
		}
		return true;
	}

	public boolean isMatch(String s, String p) {
		return helper(s, p, 0, 0);
	}

	private boolean helper(String s, String p, int si, int pi) {
		if (pi == p.length())
			return si == s.length();
		if (si == s.length()) {
			while (pi < p.length() && p.charAt(pi) == '*')
				pi++;
			return pi == p.length();
		}

		if (p.charAt(pi) == '?')
			return helper(s, p, si + 1, pi + 1);
		else if (p.charAt(pi) == '*') {
			return helper(s, p, si + 1, pi) || helper(s, p, si, pi + 1)
					|| helper(s, p, si + 1, pi + 1);
		} else {
			return s.charAt(si) == p.charAt(pi) && helper(s, p, si + 1, pi + 1);
		}
	}

	public static void main(String[] args) {
		String a = "abcede";
		String b = "abc*d";
	}
}
