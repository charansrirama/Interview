package th.c.Leetcode;

// AC
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) 
            return 0;
        int last = 0;
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) ==' ') 
                last = i;
        }
        
        return last == 0? s.length(): s.length() - last-1;
    }
}
