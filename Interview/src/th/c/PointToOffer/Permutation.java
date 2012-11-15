package th.c.PointToOffer;

import java.util.*;

public class Permutation {

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
		ArrayList<String> re = allPermutation(test);
		for(String t : re) {
			System.out.println(t);
		}
	}

}
