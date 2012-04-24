package th.facebook;

public class LongestPalidromeSubstring {

	public static String expandAroundCenter(String s, int l, int r) {
		while(l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r)) {
			l--; r++;
		}
		return s.substring(l+1, r);
	}
	
	public static String longestPalidrome(String s) {
		int len = s.length();
		if(len == 0) return "";
		String longest = s.substring(0, 1);
		for(int i = 0; i < len-1; i++) {
			String s1 = expandAroundCenter(s, i, i);
			if(s1.length() > longest.length()){
				longest = s1;
			}
			String s2 = expandAroundCenter(s, i, i+1);
			if(s2.length() > longest.length()){
				longest = s2;
			}
		}
		return longest;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "";
		System.out.println(s.substring(0, 1));
	}

}
