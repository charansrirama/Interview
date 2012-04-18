package th.leetcode;

public class WildcardMatching {
	
	public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
		s += "\0";
		p += "\0";
		int sLen = s.length();
		int pLen = p.length();
		
		boolean[] states = new boolean[pLen+1];
		boolean[] old    = new boolean[pLen+1];
		old[0] = true;
		
		for(int i = 0; i < sLen; i++) {
			char c = s.charAt(i);
			states = new boolean[pLen+1];
			for(int j = 0; j < pLen; j++) {
				char pc = p.charAt(j);
				if(old[j] && (pc == '*')) old[j+1] 	  = true;
				if(old[j] && (pc == c)) states[j+1]   = true;
				if(old[j] && (pc == '?')) states[j+1] = true;
				if(old[j] && (pc == '*')) states[j]   = true;
				if(old[j] && (pc == '*')) states[j+1] = true;
			}
			old = states;
		}
		
		return states[pLen];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
