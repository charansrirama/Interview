package th.hard;

import java.util.Arrays;
import java.util.HashMap;

public class LongestWord {
	
	private static boolean canBuilder(String str, boolean isOrignial, HashMap<String, Boolean> map) {
		if(map.containsKey(str) && !isOrignial) {
			return map.get(str);
		}
		
		for(int i = 1; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i);
			if(map.containsKey(left) && map.get(left) == true && canBuilder(right, false, map)) {
				return true;
			}
		}
		map.put(str, false);
		return false;
	}
	
	public static String printLongestWord(String arr[]) {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(String word : arr) {
			map.put(word, true);
		}
		sort(arr);
		for(String word : arr) {
			if(canBuilder(word, true, map)){
				System.out.println(word);
				return word;
			}
		}
		return null;
	}
	
	private static void sort(String[] words) {
		String temp;
		for(int i = 0; i < words.length; i++) {
			for(int j = i+1; j < words.length; j++) {
				if(words[i].length() < words[j].length()) {
					temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String words[] = new String[]{"aa", "bbb", "ccc", "aabbb", "cccbbb"};
	}

}
