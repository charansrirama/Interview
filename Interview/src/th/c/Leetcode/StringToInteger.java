package th.c.Leetcode;

public class StringToInteger {
	public int atoi(String str) {
		// Comment out following two lines to pass the OJ....
		if (str == null || str.length() == 0)
			throw new IllegalArgumentException();
		boolean innum = false;
		boolean sign = false;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		int preMax = Integer.MAX_VALUE / 10;
		int preMin = Integer.MIN_VALUE / 10;
		int re = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				innum = true;
				int digit = c - '0';
				boolean overflow = false;
				if (re - preMax >= 1)
					overflow = true;
				else if (re == preMax) {
					overflow = digit > 7;
				}
				if (overflow)
					return (sign) ? min : max;
				re = re * 10 + digit;
			} else {
				if (innum)
					break;
				if (c == '-') {
					sign = true;
					innum = true;
				} else if (c == '+')
					innum = true;
				else if (c != ' ')
					break;
			}
		}
		if (sign)
			return -re;
		else
			return re;
	}
}
