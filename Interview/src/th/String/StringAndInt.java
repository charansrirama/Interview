package th.String;

public class StringAndInt {

    public static int atoi(String para) {
	if (para == null || para.trim().length() == 0)
	    return 0;
	final char PLUS = '+';
	final char MINUS = '-';

	int ret = 0;
	String str = para.trim();
	int len = str.length();
	boolean negativeSign = false;

	for (int i = 0; i < len; i++) {
	    char ch = str.charAt(i);
	    if (i == 0) {
		if (ch == PLUS) {
		    negativeSign = false;
		    continue;
		} else if (ch == MINUS) {
		    negativeSign = true;
		    continue;
		}
	    }

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
