package th.c.Leetcode;

import java.util.*;

// AC
public class Anagrams {

	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> results = new ArrayList<String>();
		if(strs == null || strs.length == 0) 
			return results;
		Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
		Set<String> key = new HashSet<String>();
		for(String s : strs) {
			if(s.length() == 0 )
				continue;
			char[] a = s.toCharArray();
			Arrays.sort(a);
			String tmp = new String(a);
			if(table.containsKey(tmp)) {
				ArrayList<String> result = table.get(tmp);
				result.add(s);
				key.add(tmp);
			} else {
				ArrayList<String> result = new ArrayList<String>();
				result.add(s);
				table.put(tmp, result);	
			}
		}
		for(String s : key) {
			ArrayList<String> t = table.get(s);
			for(String ss : t) {
				results.add(ss);
			}
		}
		return results;
	}
	
	public static void main(String[] args) {
		anagrams(new String[]{"c"});
	}
}
