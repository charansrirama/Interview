package th.facebook;

import java.util.*;

public class Anagrams {

	public ArrayList<String> anagrams(String[] strs) {
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
		// TODO Auto-generated method stub

	}

}
