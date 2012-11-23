package th.c.Leetcode.backtrack;

import java.util.*;

public class GenerageParentheses {
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if(n <= 0) return result;
        helper(n, 0, "", result);
        return result;
    }
    
    private void helper(int open, int close, String t, ArrayList<String> result) {
        if(open == 0 && close == 0) {
            result.add(t);
            return;
        }    
        if(open > 0) 
            helper(open-1, close+1, t+"(", result);
        if(close > 0) 
            helper(open, close-1, t+")", result);
    }
}
