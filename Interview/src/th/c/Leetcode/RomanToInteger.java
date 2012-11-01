package th.c.Leetcode;

import java.util.HashMap;

public class RomanToInteger {
	private static String[] bases = { "M", "CM", "D", "CD", "C", "XC", "L",
			"XL", "X", "IX", "V", "IV", "I" };

	private static HashMap<String, Integer> map = new HashMap<String, Integer>();

	private static void setup() {
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);
	}
	
	public int romanToInt(String s) {
		setup();
		int result = 0;
		for(String base : bases) {
			while(s.startsWith(base)) {
				result += map.get(base);
				s = s.substring(base.length());
			}
		}
		return result;
	}
}
