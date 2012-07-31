package amazon.leetcode;

public class WildcardMatch {
	// Failed with large input file
	public boolean isMatch(String s, String p) {
		return helper(s.toCharArray(), p.toCharArray(), 0, 0);
	}
	
	private boolean helper(char[] s, char[] p, int sIndex, int pIndex) {
		if(p.length == pIndex) return s.length == sIndex;
		
		if(s.length == sIndex) {
			while(pIndex < p.length && p[pIndex] == '*')
				pIndex++;
			return pIndex == p.length;
		}
		
		if(p[pIndex] == '?')
			return helper(s, p, sIndex+1, pIndex+1);
		else if(p[pIndex] == '*') 
			return helper(s, p, sIndex+1, pIndex+1) ||
					helper(s, p, sIndex+1, pIndex) ||
					helper(s, p, sIndex, pIndex+1);
		else 
			return s[sIndex] == p[pIndex] && helper(s, p, sIndex+1, pIndex+1);
	}
	
	public static void main(String args[]) {
		WildcardMatch w = new WildcardMatch();
		System.out.println(w.isMatch("aa", "a"));
	}
}
