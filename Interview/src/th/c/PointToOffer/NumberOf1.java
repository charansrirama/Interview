package th.c.PointToOffer;

public class NumberOf1 {
	public static int powerBase10(int n) {
		int result = 1;
		for (int i = 0; i < n; i++)
			result *= 10;
		return result;
	}

	public static int numberOf1(String str) {
		if (str == null)
			return 0;
		int len = str.length();
		int first = Integer.parseInt(str.substring(0, 1));
		if (len == 1 && first == 0)
			return 0;
		if (len == 1 && first > 0)
			return 1;
		int numFirstDigit = 0;
		if (first > 1)
			numFirstDigit = powerBase10(len - 1);
		else
			numFirstDigit = Integer.parseInt(str.substring(1)) + 1;
		int numOtherDigits = first * (len - 1) * powerBase10(len - 2);
		int numRecursive = numberOf1(str.substring(1));

		return numFirstDigit + numOtherDigits + numRecursive;
	}

	public static int numOf1(int n) {
		return numberOf1(Integer.toString(n));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(numOf1(n));
	}
}
