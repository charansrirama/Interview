package amazon;

public class LongestSubstringWithoutDuplicate {
	public static int lengthOfLonestSubstring(String s) {
		int[] flag = new int[26];
		int maxLen = 0;
		int len = 0;
		for(int i = 0; i < s.length(); i++) {
			if(flag[s.charAt(i)-'a'] == 0) {
				flag[s.charAt(i)-'a'] = 1;
				len++;
			} else {
				if(len > maxLen) maxLen = len;
				len = 1;
				clearAllBits(flag);
				flag[s.charAt(i) - 'a'] = 1;
			}
		}
		return maxLen;
	}
	
	public static void clearAllBits(int[] array) {
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLonestSubstring("aaasaaaaaa"));
	}
}


