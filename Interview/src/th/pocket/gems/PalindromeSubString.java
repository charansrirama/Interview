package th.pocket.gems;

public class PalindromeSubString {

	public static String subPalindrome(String str, int left, int right) {
		while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		
		return str.substring(left+1, right);
	}
	
	public static String longestSubPalindrome(String str) {
		String result = "";
		
		for(int i = 0; i < str.length()-1; i++) {
			String s1 = subPalindrome(str, i, i);
			String s2 = subPalindrome(str, i, i+1);
			if(s1.length() > result.length()) {
				result = s1;
			}
			if(s2.length() > result.length()) {
				result = s2;
			}
		}
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestSubPalindrome("qwertedcbabcd"));
		System.out.println(longestSubPalindrome("aaaaaa"));
	}

}
