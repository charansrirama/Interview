package th.c.Sorting;

public class SearchWithEmpty {

	public static int search(String[] strs, String t) {
		if(strs == null || strs.length == 0 || t == null || t.length() == 0) {
			return -1;
		}
		return search(strs, t, 0, strs.length-1);
	}
	
	private static int search(String[] strs, String t, int s, int e) {
		if(s > e) return -1;
		int mid = (s+e)/2;
		if(strs[mid].isEmpty()) {
			int left = mid-1;
			int right = mid+1;
			while(true) {
				if(left < s || right > e) return -1;
				else if(right <= e && !strs[right].isEmpty()) {
					mid = right;
					break;
				} else if(left >= s && !strs[left].isEmpty()) {
					mid = left;
					break;
				}
				left--;
				right++;
			}
		}
		if(t.equals(strs[mid]))
			return mid;
		else if(strs[mid].compareTo(t) > 0) {
			return search(strs, t, s, mid-1);
		} else {
			return search(strs, t, mid+1, e);
		}
 	}
}
