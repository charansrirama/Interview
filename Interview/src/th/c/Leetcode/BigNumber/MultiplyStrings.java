package th.c.Leetcode.BigNumber;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "0";
		boolean neg = false;
		if(num1.charAt(0) == '-') {neg = !neg; num1 = num1.substring(1);}
		if(num2.charAt(0) == '-') {neg = !neg; num2 = num2.substring(1);}
		int[] results = new int[num1.length() + num2.length()];
		for(int i = 0; i < num1.length(); i++) {
			int carry = 0;
			int d1 = num1.charAt(num1.length()-i-1) - '0';
			for(int j = 0; j < num2.length(); j++) {
				int d2 = num2.charAt(num2.length()-j-1) - '0';
				carry = d1*d2 + results[i+j] + carry;
				results[i+j] = carry%10;
				carry /= 10;
			}
			results[i + num2.length()] = carry;
		}
		StringBuilder buffer = new StringBuilder();
		int zero = results.length-1;
		for(int i = results.length-1; i >= 0; i--) {
			if(results[i] != 0) break;
			else zero--;
		}
		if(zero < 0) return "0";
		for(int i = zero; i >= 0; i--) 
			buffer.append(results[i]);
		if(neg) buffer.insert(0, '-');
		return buffer.toString();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
