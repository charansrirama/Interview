package th.c.Leetcode;

public class RegularExpression {

	public static boolean isMatch(String s, String p) {
		return helper(s, 0, p, 0);
	}

	public static boolean helper(String s, int sp, String p, int pp) {
		if (pp == p.length())
			return sp == s.length();

		if (pp == p.length() - 1 || p.charAt(pp + 1) != '*') {
			if (sp < s.length()
					&& (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.')) {
				return helper(s, sp + 1, p, pp + 1);
			} else {
				return false;
			}
		}

		while (sp < s.length()
				&& (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '.')) {
			if (helper(s, sp, p, pp + 2))
				return true;
			sp++;
		}
		return helper(s, sp, p, pp + 2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
