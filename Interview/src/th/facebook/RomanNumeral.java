package th.facebook;

public class RomanNumeral {

	private static int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10,
			9, 5, 4, 1 };
	private static String[] letters = { "M", "CM", "D", "CD", "C", "XC", "L",
			"XL", "X", "IX", "V", "IV", "I" };

	public static String convertToRoman(int N) {
		String roman = "";
		for(int i = 0; i < numbers.length; i++) {
			while(N>=numbers[i]){
				roman += letters[i];
				N -= numbers[i];
			}
		}
		return roman;
	}
	
	public static int convertToInteger(String R) {
		R = R.toUpperCase();
		int result = 0;
		for(int i = 0; i < R.length(); i++) {
			char c = R.charAt(i);
			System.out.println(c);
			int j;
			for(j = 0; j < letters.length; j++) {
				if(letters[j].charAt(0) == c) {
					break;
				}
			}
			result += numbers[j];
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convertToRoman(153));
		System.out.println(convertToInteger("CLIII"));
	}

}
