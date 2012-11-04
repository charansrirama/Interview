package th.c.Leetcode;

public class ImplementStrStr {

	public static String strStr(String haystack, String needle) {
		if(haystack.length() == 0) 
			return needle.length() == 0 ? "" : null;
		if(needle.length() > haystack.length()) 
			return null;
		int len = needle.length();
		int prime = 10;
		int mod = 9999991; 
		int rolling = 0;
		int rolling2 = 0;
		for(int i = 0; i < len; i++) {
			rolling += (needle.charAt(i) - 96)* Math.pow(prime, len-i-1) % mod;
			rolling2 += (haystack.charAt(i) - 96)* Math.pow(prime, len-i-1) % mod;
		}
		if(rolling == rolling2) return haystack;
		for(int i = len; i < haystack.length(); i++) {
			rolling2 = (int) ((rolling2-((haystack.charAt(i-len) - 96) * Math.pow(prime, len-1))%mod)*prime + (haystack.charAt(i) - 96)) % mod;
			if(rolling2 == rolling) {
				return haystack.substring(i-len+1);
			}
		}
		return null;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(strStr("ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb", "abbabbbabaa"));
		
	}

}
