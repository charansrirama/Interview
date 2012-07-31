package amazon.leetcode;

public class ReverseIntegerBinary {
	public int reverseBinary(int x) {
		int b = 0;
		while(x != 0) {
			b |= (x&1);
			b >>= 1;
			x <<= 1;
		}
		return b;
	}
}
