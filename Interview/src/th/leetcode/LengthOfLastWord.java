package th.leetcode;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		s = s.trim();
		if (s.length() == 0)
			return 0;
		int spaceIndex = 0;
		int running = 0;
		while (running < s.length()) {
			if (s.charAt(running) == ' ') {
				spaceIndex = running;
			}
			running++;
		}
		if (spaceIndex == 0)
			return running;
		else
			return running - spaceIndex - 1;
	}
}
