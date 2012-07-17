package amazon;

public class StrStr {
	public String strStr(String haystack, String needle) {
		if(needle.length() == 0) return haystack;
		
		int start = 0;
		int running = 0;
		boolean find = false;
		
		for(int i = 0; i <= haystack.length()-needle.length(); i++) {
			if(haystack.charAt(i) == needle.charAt(0)) {
				start = i;
				running = 1;
				find = true;
				while(running < needle.length()) {
					if(haystack.charAt(start+running) != needle.charAt(running)) {
						find = false;
						break;
					}
					running++;
				}
				if(find) break;
			}
		}
		String result = "";
		if(find) result = haystack.substring(start);
		else result = null;
		return result;
	}
}
