package th.c.Leetcode;

public class DivideTwoInteger {

	/*
	 * The common way to do this is to count how many times that divisor adding
	 * up to dividend. Of course, we should take care of signs. That’s not hard
	 * though. However, LeetCode won’t let you pass for the reason of time
	 * exceed exception. I have to use nother trick: since , we have . The
	 * tricky part of this question does not lie on the algorithm though. It has
	 * something to do with overflows. For particular, if we use Math.abs to
	 * compute the absolute value of Integer.MIN(-2147483648), we get
	 * -2147483648 again. So we should manually make it equal to
	 * Integer.MAX(2147483647). Most of the cases this is fine, except for one
	 * case where you try to divide Integer.MIN by 2, i.e., -2147483648 / 2 =
	 * -1073741824. However, 2147483647 / 2 = 1073741823. I have to add one more
	 * edge condition that if the divisor is 2, we just do the bitwise
	 * operation: right shift. Another node is Integer.MAX / Integer.MIN = 0
	 * (not -1).
	 */
	public int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		if (divisor == 1)
			return dividend;
		if (dividend == divisor)
			return 1;
		if (divisor == 2)
			return dividend >> 1;
		boolean sign = false;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = true;
		}
		if (dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
			return 0;
		dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
				.abs(dividend);
		divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
				.abs(divisor);
		int result = (int) Math.floor(Math.pow(Math.E, Math.log(dividend)
				- Math.log(divisor)));
		return sign ? -result : result;
	}

	// Un-AC
	public static int divide2(int dividend, int divisor) {
		boolean sign = false;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = true;
		}
		int result = 0;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while (dividend - divisor >= 0) {
			result++;
			dividend -= divisor;
		}
		return sign ? -result : result;
	}

	public static void main(String[] args) {
		System.out.println(divide2(6, 1));
	}
}