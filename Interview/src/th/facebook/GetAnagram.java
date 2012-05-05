package th.facebook;

import java.util.*;

public class GetAnagram {
	
	public static String getAnagram(String text, String anagram) {
		if(text.length() < anagram.length()) return null;
		
		StringBuilder result = new StringBuilder();
		int target = 0;
		for(int i = 0; i < anagram.length(); i++) {
			target += anagram.charAt(i);
		}
		int len = anagram.length();
		Queue<Character> q = new LinkedList<Character>();
		int i = 0;
		int hash = 0;
		for(; i < len; i++) {
			q.add(text.charAt(i));
			hash += text.charAt(i);
		}
		if(hash == target) {
			while(!q.isEmpty()) {
				result.append(q.poll());
			}
			return result.toString();
		}
		while(i < text.length()) {
			char t = q.poll();
			hash -= t;
			q.add(text.charAt(i));
			hash += text.charAt(i);
			i++;
			if(hash == target) {
				while(!q.isEmpty()) {
					result.append(q.poll());
				}
				break;
			}
		}
		return result.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getAnagram("abcdbcsdaqdbahs", "scdcb"));
	}

}
