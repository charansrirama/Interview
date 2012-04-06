package th.leetcode;

public class BigNumberMultipy {
	// Accepted by Leetcode
	public static String multipy(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) return "0";
		int numOfMinus = 0;
		if(num1.charAt(0) == '-') {
			num1 = num1.substring(1);
			numOfMinus++;
		}
		if(num2.charAt(0) == '-') {
			num2 = num2.substring(1);
			numOfMinus++;
		}
		int[] result = new int[num1.length() + num2.length()];
		for(int i = 0; i < num1.length(); i++) {
			int carry = 0;
			int d1 = num1.charAt(num1.length()-1-i) - '0';
			for(int j = 0; j < num2.length(); j++) {
				int d2 = num2.charAt(num2.length()-1-j) - '0';
				carry = d1*d2 + result[i+j] + carry;
				result[i+j] = carry%10;
				carry = carry/10;
			}
			result[i + num2.length()] = carry;
		}
		StringBuilder sb = new StringBuilder();
		int zeroIndex = 0;
		for(int i = result.length-1; i >= 0; i--) {
			if(result[i] == 0) {
				zeroIndex++;
			} else {
				break;
			}
		}
		for(int i = 0; i < result.length - zeroIndex; i++) {
			sb.insert(0, result[i]);
		}
		if(numOfMinus == 1) {
			sb.insert(0, '-');
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(multipy("456", "123"));
	}

}
