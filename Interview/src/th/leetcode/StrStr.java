package th.leetcode;

public class StrStr {
	
	public static String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(needle.length() == 0) return haystack;
        if(needle.length() > haystack.length()) return null;
        
        int start = 0;
        int running = 0;
        
        boolean find = false;
        for(int i = 0; i < haystack.length(); i++) {
        	if(haystack.charAt(i) == needle.charAt(0)) {
        		find = true;
        		start = i;
        		running = 1;
        		while(running < needle.length()) {
        			if((start+running) >= haystack.length()){
        				find = false;
        				break;
        			}
        			if(needle.charAt(running) == haystack.charAt(start+running)) {
        				running++;
        				find = true;
        			} else {
        				find = false;
        				break;
        			}
        		}
        		
        		if(find) break;
        	}
        }
        String result = "";
        if(find) result = haystack.substring(start);
        else result = null;
		return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(strStr("mississippi", "issi"));
	}

}
