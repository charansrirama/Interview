package amazon.leetcode;

// AC 
// Watch out the empty string in array
public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder result = new StringBuilder();
		if(strs.length == 0) return "";
		int minLen = Integer.MAX_VALUE;
		for(String str : strs) {
			if(str.length() < minLen) {
				minLen = str.length();
			}
			if(str.length() == 0) return "";
		}
		for(int i = 0; i < minLen; i++) {
			char t = strs[0].charAt(i);
			boolean isEqual = true;
			for(int j = 1; j < strs.length; j++) {
				if(strs[j].charAt(i) != t) {
					isEqual = false;
					break;
				}
			}
			if(!isEqual) {
				break;
			} else {
				result.append(t);
			}
		}
		return result.toString();
    }
	
	public static void main(String args[]) {
		String[] strs = new String[]{"aa", "aab"};
		
		System.out.println(longestCommonPrefix(strs));
	}
}
