package amazon;

public class RegularExpression {
	public boolean isMatch(String s, String p) {
		return helper(s.toCharArray(), p.toCharArray(), 0, 0);
    }
	
	private boolean helper(char[] s, char[] p, int sIndex, int pIndex) {
		if(pIndex == p.length) return sIndex == s.length;
		
		if(p[pIndex] == '*')
			throw new RuntimeException("Invalid regex...");
		
		if(sIndex == s.length) {
			while(pIndex+1 < p.length && p[pIndex+1] == '*')
				pIndex += 2;
			return pIndex == p.length;
		}
		
		if(p[pIndex] == '.') {
			if(pIndex+1 < p.length && p[pIndex+1] == '*') {
				return helper(s, p, sIndex, pIndex+2) ||
						helper(s, p, sIndex+1, pIndex+2) ||
						helper(s, p, sIndex+1, pIndex);
			} else 
				return helper(s, p, sIndex+1, pIndex+1);
		} else {
			if(pIndex+1 < p.length && p[pIndex+1] == '*') {
				if(s[sIndex] == p[pIndex]) 
					return helper(s, p, sIndex+1, pIndex) || 
							helper(s, p, sIndex+1, pIndex+2) ||
							helper(s, p, sIndex, pIndex+2);
				return helper(s, p, sIndex, pIndex+2);
			}  else 
				return s[sIndex] == p[pIndex] && helper(s, p, sIndex+1, pIndex+1);
		}
	}
}
