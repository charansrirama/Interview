package th.c.PointToOffer;

import java.util.*;

public class Permutation {

	public static ArrayList<String> allPermutation2(String str) {
		ArrayList<String> results = new ArrayList<String>();
		if(str == null) return results;
		helper(results, str.toCharArray(), 0, str.length()-1);
		return results;
	}
	
	public static void helper(ArrayList<String> results, char[] s, int start, int end) {
		if(start > end) results.add(new String(s));
		else {
			for(int i = start; i <= end; i++) {
				swap(s, i, start);
				helper(results, s, start+1, end);
				swap(s, i, start);
			}
		}
	}
	
	public static void swap(char[] t, int i, int j) {
		char tmp = t[i];
		t[i] = t[j];
		t[j] = tmp;
	}
	
	public static ArrayList<String> allPermutation(String str) {
		ArrayList<String> results = new ArrayList<String>();
		if(str == null || str.length() == 0) return results;
		char[] tmp = str.toCharArray();
		Arrays.sort(tmp);
		results.add(new String(tmp));
		while(getNext(tmp)) {
			results.add(new String(tmp));
		}
		return results;
	}
	
	public static boolean getNext(char[] A) {
		for(int i = A.length - 2; i >= 0; i--) {
			if(A[i+1] > A[i]) {
				for(int j = A.length-1; j > i; j--) {
					if(A[j] > A[i]) {
						char tmp = A[i];
						A[i] = A[j];
						A[j] = tmp;
						int start = i+1;
						int end = A.length-1;
						while(start <= end) {
							char t = A[start];
							A[start] = A[end];
							A[end] = t;
							start++; end--;
						}
						return true;
					}
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
		String test = "abc";
		ArrayList<String> re = allPermutation2(test);
		for(String t : re) {
			System.out.println(t);
		}
	}

}
