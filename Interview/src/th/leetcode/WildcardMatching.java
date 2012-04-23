package th.leetcode;

public class WildcardMatching {

	public static boolean isMatch1(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		s += "\0";
		p += "\0";
		int sLen = s.length();
		int pLen = p.length();

		boolean[] states = new boolean[pLen + 1];
		boolean[] old = new boolean[pLen + 1];
		old[0] = true;

		for (int i = 0; i < sLen; i++) {
			char c = s.charAt(i);
			states = new boolean[pLen + 1];
			for (int j = 0; j < pLen; j++) {
				char pc = p.charAt(j);
				if (old[j] && (pc == '*')){
					old[j + 1] = true;
					states[j] = true;
					states[j + 1] = true;
				}
				if (old[j] && (pc == c) || (pc == '?'))
					states[j + 1] = true;	
			}
			old = states;
		}

		return states[pLen];
	}

	// Recursion version of wildcard matching
	// Watch out: ** is legal
	public static boolean isMatch(char[] s, char[] p, int curIndex, int regIndex) {
		if(p.length == regIndex) return s.length == curIndex;
		
		if(s.length == curIndex) {
			while(regIndex+1 <= p.length && p[regIndex] == '*')
				regIndex += 1;
			return regIndex == p.length;
		}
		
		if(p[regIndex] == '?') {
			return isMatch(s, p, curIndex+1, regIndex+1);
		} else if(p[regIndex] == '*') {
			return isMatch(s, p, curIndex+1, regIndex) ||
					isMatch(s, p, curIndex+1, regIndex+1) ||
					isMatch(s, p, curIndex, regIndex+1);
		} else {
			return s[curIndex] == p[regIndex] && isMatch(s, p, curIndex+1, regIndex+1);
		}
	}
	
	public static boolean regexMatch(char[] src, char[] regex, int currIndex, int regexIndex) {
		if (regexIndex == regex.length) {
			return (currIndex == src.length);
		}

		// At no point in time, [star] cannot be our starting char in regex
		if (regex[regexIndex] == '*') {
			throw new RuntimeException("Invalid Regex ..");
		}

		if (currIndex == src.length) {
			// if the current char in regex is not followed by a [star], then
			// there is no match
			while (regex.length > regexIndex + 1
					&& regex[regexIndex + 1] == '*') {
				regexIndex += 2;
			}
			return (regex.length == regexIndex);
		}
		// If the char is a dot
		if (regex[regexIndex] == '.') {
			// See if the subsequent char is a [star]
			if (regexIndex + 1 < regex.length && regex[regexIndex + 1] == '*') {
				// Three cases are possible
				// a. consider there is a match and move the currIndex
				// b. consider there is a match and move both currIndex and
				// regexIndex
				// c. consider there is no match and move the regexIndex
				return regexMatch(src, regex, currIndex + 1, regexIndex)
						|| regexMatch(src, regex, currIndex + 1, regexIndex + 2)
						|| regexMatch(src, regex, currIndex, regexIndex + 2);
			} else {
				return regexMatch(src, regex, currIndex + 1, regexIndex + 1);
			}
		} else {
			// See if the subsequent char is a [star]
			if (regexIndex + 1 < regex.length && regex[regexIndex + 1] == '*') {
				if (src[currIndex] == regex[regexIndex]) {
					// Three cases are possible
					// a. consider there is a match and move the currIndex
					// b. consider there is a match and move both currIndex and
					// regexIndex
					// c. consider there is no match and move the regexIndex
					return regexMatch(src, regex, currIndex + 1, regexIndex)
							|| regexMatch(src, regex, currIndex + 1,
									regexIndex + 2);
				}
				// NOTE: this represents the (c) case, both when the char does
				// match and when it does not
				return regexMatch(src, regex, currIndex, regexIndex + 2);
			} else {
				return src[currIndex] == regex[regexIndex]
						&& regexMatch(src, regex, currIndex + 1, regexIndex + 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] a = new char[]{'a','a','b'};
		char[] b = new char[]{'a','a','b'};
		System.out.println(regexMatch(a, b, 0, 0));
		System.out.println(isMatch1("aba", "a*a"));
	}

}
