package th.leetcode;

public class Palindrome {

	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int dev = 1;
		while (x / dev >= 10) {
			dev *= 10;
		}
		System.out.println(dev);
		while (x != 0) {
			int l = x / dev;
			int r = x % 10;
			if (l != r)
				return false;
			x = (x % dev) / 10;
			dev /= 100;

		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
	}

	/*
	 * -2147483648 false false
	 * 
	 * -2147447412 false false
	 * 
	 * -101 false false
	 * 
	 * -10 false false
	 * 
	 * -1 false false
	 * 
	 * 0 true true
	 * 
	 * 1 true true
	 * 
	 * 3 true true
	 * 
	 * 5 true true
	 * 
	 * 10 false false
	 * 
	 * 11 true true
	 * 
	 * 44 true true
	 * 
	 * 121 true true
	 * 
	 * 123 false false
	 * 
	 * 213 false false
	 * 
	 * 313 true true
	 * 
	 * 1001 true true
	 * 
	 * 1881 true true
	 * 
	 * 101 true true
	 * 
	 * 500 false false
	 * 
	 * 9999 true true
	 * 
	 * 88888 true true
	 * 
	 * 2222222 true true
	 * 
	 * 789656987 true true
	 * 
	 * 2147447412 true true
	 * 
	 * 2147483647 false false
	 */
}
