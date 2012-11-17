package th.c.Leetcode;

public class Sqrt {
	public int sqrt(int x) {
		if (x >= 0) {
			int l = 0, r = x, mid = 0;
			while (l <= r) {
				mid = l + (r - l) / 2;
				long tmp = (long) mid * mid;
				if (tmp == x)
					return mid;
				else if (tmp < x)
					l = mid + 1;
				else
					r = mid - 1;
			}
			return r;
		} else {
			return -1;
		}
	}
}
