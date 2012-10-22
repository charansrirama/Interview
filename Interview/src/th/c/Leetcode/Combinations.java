package th.c.Leetcode;

import java.util.*;

// AC
public class Combinations {
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(n < k || n <= 0) return results;
		int[] A = new int[n];
		for(int i = 0; i < k; i++) A[A.length-1-i] = 1;
		results.add(arrayToList(A));
		while(getNext(A)) {
			results.add(arrayToList(A));
		}
		return results;
	}
	
	private ArrayList<Integer> arrayToList(int[] A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < A.length; i++) {
			if(A[i] != 0) result.add(i+1);
		}
		return result;
	}
	
	private boolean getNext(int[] A) {
		for(int i = A.length-2; i >= 0; i--) {
			if(A[i] < A[i+1]) {
				for(int j = A.length-1; j > i; j--) {
					if(A[j] > A[i]) {
						swap(A, i, j);
						int start = i+1;
						int end = A.length-1;
						while(start <= end) {
							swap(A, start, end);
							start++;
							end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public static void main(String[] args) {
		Combinations test = new Combinations();
		test.combine(4,2);
	}
}
