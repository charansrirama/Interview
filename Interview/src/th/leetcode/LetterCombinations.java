package th.leetcode;

import java.util.*;

public class LetterCombinations {

	public static String mappings[][] = {
		{"0"}, {"1"}, {"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"},
        {"J", "K", "L"}, {"M", "N", "O"}, {"P", "Q", "R", "S"}, 
        {"T", "U", "V"}, {"W", "X", "Y", "Z"}
	};
	
	public static ArrayList<String> letterCombinations(String number) {
		if(number == "") return new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		letterCombinationsHelper(result, "", number);
		return result;
	}
	
	private static void letterCombinationsHelper(ArrayList<String> combos, String prefix, String remaining) {
		int digit = Integer.parseInt(remaining.substring(0, 1));
		
		if(remaining.length() == 1) {
			for(int i = 0; i < mappings[digit].length; i++) {
				combos.add(prefix+mappings[digit][i]);
			}
		} else {
			for(int i = 0; i < mappings[digit].length; i++) {
				letterCombinationsHelper(combos, prefix + mappings[digit][i], remaining.substring(1));
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String phone = "7";
		ArrayList<String> re = letterCombinations(phone);
		for(String s : re) {
			System.out.println(s);
		}
	}

}
