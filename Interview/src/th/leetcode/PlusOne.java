package th.leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--) {
            carry = digits[i] + carry;
            digits[i] = carry%10;
            carry = carry/10;
        }
        int[] result;
        
        if(carry != 0) {
            result = new int[digits.length+1];
            result[0] = carry;
            for(int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
        } else {
            result = new int[digits.length];
            for(int i = 0; i < digits.length; i++) {
                result[i] = digits[i];
            }
        }
        
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
