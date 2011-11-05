package th.other;

public class Dec2Hex {

	public static int HexToDec(String hex) {
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		int result = 0;
		for(int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			int d = digits.indexOf(c);
			result = 16*result + d;
		}
		
		return result;
	}
	
	public static String DecToHex(int x) {
		String digits = "0123456789ABCDEF";
		if(0 == x) return "0";
		String hex = "";
		while(x > 0) {
			int digit = x%16;
			hex = digits.charAt(digit) + hex;
			x = x/16;
		}
		
		return hex;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int test = 145;
		System.out.println(DecToHex(test));
		String testString = "A0";
		System.out.println(HexToDec(testString));
	}

}
