package th.leetcode;

import java.util.*;

public class SubstringWithAllWords {

	public static ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int m = L[0].length();
        Map<String, Integer> counts = new HashMap<String, Integer>();
        Map<String, Integer> found  = new HashMap<String, Integer>();
        
        for(String s: L) {
        	if(counts.get(s) == null) counts.put(s, 1);
        	else counts.put(s, counts.get(s)+1);
        }
        loop: for(int i = 0; i <= S.length() - L.length*m; i++) {
        	String sub = S.substring(i, i+m);
        	if(counts.get(sub) != null) {
        		found.clear();
        		found.put(sub, 1);
        		for(int j = 1; j < L.length; j++) {
        			int s = i+j*m;
        			sub = S.substring(s, s+m);
        			Integer toFind = counts.get(sub);
        			if(toFind == null) continue loop;
        			Integer foundVal = found.get(sub);
        			int k = foundVal==null?1:foundVal+1;
        			if(k > toFind) continue loop;
        			found.put(sub, k);
        		}
        		ans.add(i);
        	}
        }
        return ans;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
