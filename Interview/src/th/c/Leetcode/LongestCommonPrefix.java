package th.c.Leetcode;

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		String prefix = "";
		if(strs.length > 0) {
			prefix = strs[0];
			for(int i = 1; i < strs.length; i++) {
				String t = strs[i];
				int j = 0;
				for(; j < Math.min(t.length(), prefix.length()); j++) {
					if(prefix.charAt(j) != t.charAt(j)) break;
				}
				prefix = prefix.substring(0, j);
			}
		}
		return prefix;
    }
}
