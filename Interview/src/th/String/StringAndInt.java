package th.String;

public class StringAndInt {

	public static int atoi(String para) {
		if (para == null || para.trim().length() == 0 || para.equals("0"))
			return 0;
		final char PLUS = '+';
		final char MINUS = '-';
		boolean negativeSign = false;
		
		int ret = 0;
		String str = para.trim();
		if(str.charAt(0) == MINUS) {
			negativeSign = true;
			str = str.substring(1);
		} else if(str.charAt(0) == PLUS){
			negativeSign = false;
			str = str.substring(1);
		}
		int len = str.length();
		
		
		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);

			if (!(ch >= '0' && ch <= '9')) {
				break;
			} else {
				ret = 10 * ret + (ch - 48);
			}
		}
		if (negativeSign)
			ret = ret * (-1);
		return ret;
	}

	public static String IntToString(int input) {
		if (input == 0)
			return "0";
		StringBuilder result = new StringBuilder();
		boolean minus = false;

		int hi = 0;

		if (input < 0) {
			minus = true;
			input = input * (-1);
		}

		while (input != 0) {
			hi = input % 10;
			input = input / 10;
			result.append(hi);
		}
		result.reverse();
		if (minus)
			result.insert(0, "-");

		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(atoi(" 123"));
		System.out.println(atoi("+123"));
		System.out.println(atoi("-123"));

		System.out.println(IntToString(123));
		System.out.println(IntToString(-123));
		System.out.println(IntToString(0));
	}

}
