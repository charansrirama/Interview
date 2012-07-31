package amazon.leetcode;

import java.util.*;

public class Anagram {

	public ArrayList<String> anagrams(String[] strs) {
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
        	LinkedList<String> list = map.get(new String(array));
        	list.add(strs[i]);
        	map.put(new String(array), list);
        }
        
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
        	Map.Entry entry = (Map.Entry)iter.next();
        	LinkedList<String> set = (LinkedList<String>)entry.getValue();
        	if(set.size() > 1) {
        		for(String str : set) {
        			result.add(str);
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
