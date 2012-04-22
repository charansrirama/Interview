package th.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
					found.put(sub, foundVal);
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
