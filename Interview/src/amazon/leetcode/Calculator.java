package amazon.leetcode;

public class Calculator {
	public int Add(int a, int b) {
		if(b==0) return 0;
		int sum = a^b;
		int carry = (a&b)<<1;
		return Add(sum, carry);
	}
}
