package th.c.Arrays;

/*
 * aabcccccaaa => a2b1c5a3
 */

public class CompressArray {

	public static String compress(String str) {
		if(str.length() <= 1) return str;
		StringBuilder result = new StringBuilder();
		char cur = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == cur) count++;
			else {
				result.append(cur);
				result.append(count);
				count = 1;
				cur = str.charAt(i);
			}
		}
		result.append(cur);
		result.append(count);
		return result.length() > str.length() ? str : result.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compress("abcdefgh"));
	}

}
