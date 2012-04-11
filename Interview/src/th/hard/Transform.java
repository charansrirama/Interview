package th.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Transform {

	Set<String> getOneEditWords(String word) {
		Set<String> words = new TreeSet<String>();
		for(int i = 0; i < word.length(); i++) {
			char[] wordArray = word.toCharArray();
			for(char c = 'a'; c <= 'z'; c++) {
				wordArray[i] = c;
				words.add(wordArray.toString());
			}
		}
		return words;
	}
	
	LinkedList<String> transform(String start, String stop, Set<String> dictionary) {
		start = start.toLowerCase();
		stop  = stop.toLowerCase();
		Queue<String> actionQueue = new LinkedList<String>();
		Set<String> visitedSet = new HashSet<String>();
		
		Map<String, String> backtrackMap = new TreeMap<String, String>();
		
		actionQueue.add(start);
		visitedSet.add(start);
		
		while(!actionQueue.isEmpty()) {
			String w = actionQueue.poll();
			for(String v : getOneEditWords(w)) {
				if(v.equals(stop)) {
					LinkedList<String> list = new LinkedList<String>();
					list.add(v);
					while(w != null) {
						list.add(0, w);
						w = backtrackMap.get(w);
					}
					return list;
				}
				
				if(dictionary.contains(v)) {
					if(!visitedSet.contains(v)) {
						actionQueue.add(v);
						visitedSet.add(v);
						backtrackMap.put(v, w);
					}
				}
			}
		}
		
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
