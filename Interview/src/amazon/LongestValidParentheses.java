package amazon;


// AC
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int count = 0;
		int maxLength = 0;
		int runningLength = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				count++;
				runningLength++;
			} else if(s.charAt(i) == ')') {
				count--;
				runningLength++;
			}
			if(count == 0 && runningLength > maxLength) {
				maxLength = runningLength;
			} else if(count < 0) {
				runningLength = 0; 
				count = 0;
			}
		}
		count = 0;
		runningLength = 0;
		for(int i = s.length()-1; i>=0; i--) {
			if(s.charAt(i) == ')') {
				count++;
				runningLength++;
			} else if(s.charAt(i) == '(') {
				count--;
				runningLength++;
			}
			if(count == 0 && runningLength > maxLength) {
				maxLength = runningLength;
			} else if(count < 0) {
				runningLength = 0;
				count = 0;
			}
		}
		return maxLength;
	}
}
