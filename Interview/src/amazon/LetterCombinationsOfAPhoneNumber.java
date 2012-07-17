package amazon;

import java.util.*;

// AC
public class LetterCombinationsOfAPhoneNumber {

	public static String mappings[][] = {
		{"0"}, {"1"}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"},
        {"J", "K", "L"}, {"M", "N", "O"}, {"P", "Q", "R", "S"}, 
        {"T", "U", "V"}, {"W", "X", "Y", "Z"}
	};
	
	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if(digits.length() != 0) 
			helper(result, "", digits);
		else {
			result.add("");
		}
		return result;
    }
	
	public static void helper(ArrayList<String> combos, String prefix, String remaining) {
		int digit = Integer.parseInt(remaining.substring(0, 1));
		if(remaining.length() == 1) {
			for(int i = 0; i < mappings[digit].length; i++) {
				combos.add(prefix+mappings[digit][i]);
			}
		} else {
			for(int i = 0; i < mappings[digit].length; i++) {
				helper(combos, prefix+mappings[digit][i], remaining.substring(1));
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = letterCombinations("");
		for(String s: result) {
			System.out.println(s);
		}
	}

}
