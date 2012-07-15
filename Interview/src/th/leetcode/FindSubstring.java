package th.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9]
 */
public class FindSubstring {

	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int m = L[0].length();
		Map<String, Integer> count = new HashMap<String, Integer>();
		Map<String, Integer> found = new HashMap<String, Integer>();

		for (String l : L) {
			if (count.get(l) == null)
				count.put(l, 1);
			else
				count.put(l, count.get(l) + 1);
		}

		loop: for (int i = 0; i <= S.length() - L.length * m; i++) {
			String sub = S.substring(i, i + m);
			if (count.get(sub) != null) {
				found.clear();
				found.put(sub, 1);
				for (int j = 1; j < L.length; j++) {
					int s = i + j * m;
					sub = S.substring(s, s + m);
					Integer toFind = count.get(sub);
					if (toFind == null)
						continue loop;
					Integer foundVal = found.get(sub);
					int k = foundVal == null ? 1 : foundVal + 1;
					if (k > toFind)
						continue loop;
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
