package th.facebook;

import java.util.*;

public class StringArrayPrefix {

	public static ArrayList<String> prefixFind(String[] array, String prefix) {
		ArrayList<String> result = new ArrayList<String>();
		int lower, higher;
		int start = 0, end = array.length-1;
		// find lower bound
		int mid = 0;
		while(start < end) {
			mid = (start + end)/2;
			int re = compare(array[mid], prefix);
			if(re > 0) {
				end = mid-1;
			} else if(re < 0) {
				start = mid+1;
			} else {
				end = mid;
			}
		}
		if(compare(array[mid], prefix)!= 0) return result;
		else lower = mid;
		
		// Find higher bound
		start = mid; 
		end = array.length-1;
		while(start < end) {
			mid = (start+end)/2;
			int re = compare(array[mid], prefix);
			if(re > 0) {
				end = mid-1;
			} else if(re < 0) {
				start = mid+1;
			} else {
				start = mid;
			}
		}
		higher = mid;
		for(int i = lower; i <= higher; i++) {
			result.add(array[i]);
		}
		return result;
	}
	
	private static int compare(String a, String prefix) {
		if(prefix.length() > a.length()) return -1;
		int len = prefix.length();
		for(int i = 0; i < len; i++) {
			if(a.charAt(i) > prefix.charAt(i)) return 1;
			else if(a.charAt(i) < prefix.charAt(i)) return -1;
		}
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "abc";
		String b = "aba";
		
		System.out.println(a.charAt(2) > b.charAt(2));
	}

}
