package th.c.Leetcode;

public class LongestSubStringWithoutRepeat {
	// AC
	public static int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int i = 0, j = 0;
		int maxLen = 0;
		boolean[] exist = new boolean[256];
		while(j < len) {
			if(exist[s.charAt(j)]) {
				maxLen = Math.max(maxLen, j-i);
				while(s.charAt(i) != s.charAt(j)) {
					exist[s.charAt(i)] = false;
					i++;
				}
				i++;
				j++;
			} else {
				exist[s.charAt(j)] = true;
				j++;
			}
		}
		maxLen = Math.max(maxLen, len-i);
		return maxLen;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
