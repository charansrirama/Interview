package th.c.Leetcode.backtrack;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

	public static String mappings[][] = {
    	{"0"}, {"1"}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"},
        {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, 
        {"t", "u", "v"}, {"w", "x", "y", "z"}
	};
	
	public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<String>();
        if(digits.length() == 0) {
            results.add("");
            return results;
        }
        helper(results, "", digits);
        return results;
    }
	
	public void helper(ArrayList<String> results, String prefix, String remaining) {
		int digit = Integer.parseInt(remaining.substring(0,1));
		if(remaining.length() == 1) {
			for(int i = 0; i < mappings[digit].length; i++) {
				results.add(prefix + mappings[digit][i]);
			}
		} else {
			for(int i = 0; i < mappings[digit].length; i++) {
				helper(results, prefix+mappings[digit][i], remaining.substring(1));
			}
		}
	}
}
