package th.c.Leetcode;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
	
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if(S == null || S.length() == 0 || L == null || L.length == 0) 
			return results;
		int N = L.length, M = L[0].length();
		Hashtable<String, Integer> map = new Hashtable<String, Integer>();
		Hashtable<String, Integer> cur = new Hashtable<String, Integer>();
		for(int i = 0; i < N; i++) 
			map.put(L[i], map.containsKey(L[i]) ? map.get(L[i])+1 : 1);
		
		for(int i = 0; i <= S.length()-N*M; i++) {
			cur.clear();
			int j = 0;
			for(; j < N; j++) {
				String w = S.substring(i+j*M, i+j*M+M);
				if(!map.containsKey(w)) break;
				cur.put(w, cur.containsKey(w) ? cur.get(w)+1 : 1);
				if(cur.get(w) > map.get(w)) break;
			}
			if(j == N) results.add(i);
		}
		return results;
    }
	
	public static void main(String[] args) {
		String str = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		findSubstring(str, L);
	}
}
