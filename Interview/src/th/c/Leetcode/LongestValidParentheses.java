package th.c.Leetcode;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		int len = s.length();
		int count = 0;
		int runLen = 0;
		int max = 0;
		for(int i = 0; i < len; i++) {
			if(s.charAt(i) == '(') {
				count++;
				runLen++;
			} else if(s.charAt(i) == ')') {
				count--;
				runLen++;
			}
			if(count == 0 && runLen > max) {
				max = runLen;
			} else if(count < 0) {
				count = 0;
				runLen = 0;
			}
		}
		runLen = 0;
		count = 0;
		for(int i = len-1; i>= 0; i--) {
			if(s.charAt(i) == ')') {
				count++;
				runLen++;
			} else if(s.charAt(i) == '(') {
				count--;
				runLen++;
			}
			if(count == 0 && runLen > max) {
				max = runLen;
			} else if(count < 0) {
				count = 0; 
				runLen = 0;
			}
		}
		return max;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
