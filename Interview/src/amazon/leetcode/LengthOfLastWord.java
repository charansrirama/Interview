package amazon.leetcode;

public class LengthOfLastWord {

	// Watch out the first and last space.
	// AC
	public int lengthOfLastWord(String s) {
        int length = 0; 
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                length = 0;
            } else {
                length++;
            }
        }
        return length;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
