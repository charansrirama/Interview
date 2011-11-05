package th.other;

import java.util.Hashtable;

public class FirstNonRepeated {

	public static Character findFirstNonRepeated(String input) {
		Hashtable<Character, Object> charHash = new Hashtable<Character, Object>();
		int i, length;
		Character c;
		Object seenOnce = new Object();
		Object seenTwice = new Object();
		
		length = input.length();
		
		for(i = 0; i < length; i++) {
			c = new Character(input.charAt(i));
			Object o = charHash.get(c);
			if(o == null) {
				charHash.put(c, seenOnce);
			} else if(o == seenOnce) {
				charHash.put(c, seenTwice);
			}
		}
		for(i = 0; i < length; i++) {
			c = new Character(input.charAt(i));
			if(charHash.get(c) == seenOnce) 
				return c;
		}
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findFirstNonRepeated("aabbccdde"));
	}

}
