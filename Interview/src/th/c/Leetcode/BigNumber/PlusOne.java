package th.c.Leetcode.BigNumber;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		int [] result = new int[digits.length];
		int up = 1;
		for(int i = digits.length-1; i>=0; i--) {
			result[i] = (digits[i] + up)%10;
			up = (digits[i] + up)/10;
		}
		if(up != 0) {
			int[] plusOne = new int[digits.length+1];
			plusOne[0] = up;
			result = plusOne;
		}
		return result;
	}
}
