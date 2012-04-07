package th.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Anagram {
	// Accepted by Leetcode.com
	public static ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
        for(int i = 0; i < strs.length; i++) {
        	char[] array = strs[i].toCharArray();
        	java.util.Arrays.sort(array);
        	map.put(new String(array), new LinkedList<String>());
        }
        
        for(int i = 0; i < strs.length; i++) {
        	char[] array = strs[i].toCharArray();
        	java.util.Arrays.sort(array);
        	String sorted = new String(array);
        	LinkedList<String> set = map.get(sorted);
        	set.add(strs[i]);
        	map.put(sorted, set);
        }
        
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
        	Map.Entry entry = (Map.Entry)iter.next();
        	LinkedList<String> set = (LinkedList<String>)entry.getValue();
        	if(set.size() > 1) {
        		Iterator it = set.iterator();
        		while(it.hasNext()) {
        			String w = (String)it.next();
        			result.add(w);
        		}
        	}
        }
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = new String[] {"tea","and","ace","ad","eat","eat","dan"};
		ArrayList<String> list = anagrams(strs);
		for(String word: list) {
			System.out.println(word);
		}
	}

}
