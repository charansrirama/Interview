package th.leetcode;

public class AddBinary {

	// Adding to binary code
	// Accepted by leetcode
	public static String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (a.equals("0"))
			return b;
		else if (b.equals("0"))
			return a;

		int aLen = a.length();
		int bLen = b.length();
		if (aLen > bLen) {
			for (int i = 0; i < aLen - bLen; i++) {
				b = "0" + b;
			}
		} else if (aLen < bLen) {
			for (int i = 0; i < bLen - aLen; i++) {
				a = "0" + a;
			}
		}

		int result[] = new int[a.length() + 1];
		int carry = 0;
		for (int i = 0; i < a.length(); i++) {
			int d1 = a.charAt(a.length() - 1 - i) - '0';
			int d2 = b.charAt(b.length() - 1 - i) - '0';
			carry = d1 + d2 + carry;
			result[i] = carry % 2;
			carry = carry / 2;
		}
		result[result.length - 1] = carry;
		int zeroIndex = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			if (result[i] == 0) {
				zeroIndex++;
			} else {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length - zeroIndex; i++) {
			sb.insert(0, result[i]);
		}

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addBinary("11111111111", "1"));
	}

}
