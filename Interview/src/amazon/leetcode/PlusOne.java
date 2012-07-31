package amazon.leetcode;

// AC
public class PlusOne {

	public int[] plusOne(int[] digits) {
		int[] result = new int[digits.length];
		int up = 1;
		for(int i = digits.length-1; i>=0; i--) {
			result[i] = (digits[i]+up)%10;
			up = (digits[i]+up)/10;
		}
		if(up != 0) {
			int[] plusone = new int[digits.length+1];
			plusone[0] = up;
			System.arraycopy(plusone, 1, result, 0, result.length);
			result = plusone;
		}
		return result;
	}
}
