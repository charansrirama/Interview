package th.facebook;

import java.util.*;

public class FindPath {

	public static boolean findPath(String[] m, String path) {
		if (path.length() == 0)
			return true;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length(); j++) {
				Set<String> set = new HashSet<String>();
				if (dfs(m, i, j, path, 0, set))
					return true;
			}
		}
		return false;
	}

	private static boolean dfs(String[] m, int i, int j, String path, int k,
			Set<String> set) {
		if (m[i].charAt(j) == path.charAt(k)) {
			set.add(i + ":" + j);
			if (k == path.length() - 1) {
				return true;
			}
			int[] x = new int[] { i - 1, i + 1, i, i };
			int[] y = new int[] { j, j, j + 1, j - 1 };
			for (int n = 0; n < x.length; n++) {
				if (x[n] < 0 || x[n] >= m.length || y[n] < 0
						|| y[n] >= m[0].length()) {
					continue;
				} else {
					if (set.contains(x[n] + ":" + y[n]))
						continue;
					set.add(x[n] + ":" + y[n]);
					if (dfs(m, x[n], y[n], path, k + 1, set)) {
						return true;
					}
					set.remove(x[n] + ":" + y[n]);
				}
			}
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] m = new String[]{"ABCE", "SFCS", "ADEE"};
		System.out.println(findPath(m, "ABFDAS"));
	}

}
