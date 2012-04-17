package th.leetcode;

public class LongestSubstringWithoutDuplicate {
	
	public static int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s.length() == 0) return 0;
        int maxLen = 0;
        int runningLen = 0;
        int len = s.length();
        int flag[] = new int[26];
        for(int i = 0; i < len-maxLen; i++) {
        	clearAllBit(flag);
        	runningLen = 1;
        	flag[s.charAt(i) - 'a'] = 1;
        	for(int j = i+1; j < len; j++) {
        		if(flag[s.charAt(j)-'a'] == 0) {
        			flag[s.charAt(j)-'a'] = 1;
        			runningLen++;
        		} else {
        			break;
        		}
        	}
        	if(runningLen > maxLen) {
        		maxLen = runningLen;
        	}
        }
        return maxLen;
    }
	public static void clearAllBit(int[] flag) {
		flag = new int[26];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

}
