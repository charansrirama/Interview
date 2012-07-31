package amazon.leetcode;

import java.util.*;

public class Permutations {

	// Helper function
	public String arrayToString(int[] array) {
		StringBuilder str = new StringBuilder();
		for(int i : array)
			str.append(i);
		return str.toString();
	}

	public void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public boolean getNext(int[] array) {
		for(int i = array.length-2; i >= 0; i--) {
			if(array[i] < array[i+1]) {
				for(int j = array.length-1; j > i; j--) {
					if(array[j] > array[i]) {
						swap(array, i, j);
						int start = i+1;
						int end = array.length-1;
						while(start <= end) {
							swap(array, start, end);
							start++; end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/*****************************************************/
	// Permutation Sequence
	// Time limit exceed when run with large data set
	public String getPermutation(int n, int k) {
		ArrayList<String> perm = new ArrayList<String>();
		int[] array = new int[n];
		for(int i = 0; i < n; i++) 
			array[i] = i+1;
		perm.add(arrayToString(array));
		while(getNext(array)){
			perm.add(arrayToString(array));
		}
		return perm.get(k-1);
	}
	
	
	/*****************************************************/
	// AC
	// How to transfer from last condition back to first condition
	// 321 -> 123
	// Next Permutation
	public void nextPermutation(int[] num) {
		boolean result = getNext(num);
		if(!result) Arrays.sort(num); // Can't get next permutation. sort the array
 	}
	
	
	/*****************************************************/
	// AC 
	// Permutations
	// Watch out: array should be in order!!!!!!!!!
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i : num) result.add(i);
		results.add(result);
		while(getNext(num)) {
			result = new ArrayList<Integer>();
			for(int i : num) result.add(i);
			results.add(result);
		}
		return results;
	}
	
	
	/*****************************************************/
	// AC
	// PermutationsII
	// Same as Permutations
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i : num) result.add(i);
		results.add(result);
		while(getNext(num)) {
			result = new ArrayList<Integer>();
			for(int i : num) result.add(i);
			results.add(result);
		}
		return results;
	}
	
	/*****************************************************/
	// Recursion version of permutation
	public ArrayList<ArrayList<Integer>> recursionPermutation(int[] num) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		recursion(num, 0, num.length-1, results);
		return results;
	}
	
	public void recursion(int[] num, int start, int end, ArrayList<ArrayList<Integer>> results) {
		if(start > end) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int i : num) result.add(i);
			results.add(result);
		} else {
			for(int i = start; i <= end; i++) {
				swap(num, start, i);
				recursion(num, start+1, end, results);
				swap(num, start, i);
			}
		}
	}
	
	
	
	
	
	public static void main(String args[]) {
		Permutations p = new Permutations();
		System.out.println(p.getPermutation(9, 214267));
//		System.out.println(p.nextPermutation(new int[]{5, 1, 1}));
	}
}
