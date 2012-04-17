package th.leetcode;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
		StringBuilder result = new StringBuilder();
		if(strs.length == 0) return "";
		
		int length = strs[0].length();
		for(int i = 1; i < strs.length; i++) {
			if(strs[i].length() < length)
				length = strs[i].length();
		}
		
		for(int i = 0; i < length; i++) {
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
