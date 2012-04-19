package th.leetcode;

import java.util.ArrayList;

import java.util.*;

public class ThreeSum {
	// doesnt handle the duplicate problem now.
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(num.length == 0) return results;
		
		HashSet set = new HashSet();
		
		quickSort(num);
		
		for(int i = 0; i < num.length; i++) {
			int rest = 0-num[i];
			int start = i+1;
			int end = num.length-1;
			while(end > start) {
				if(num[start] + num[end] == rest) {
					ArrayList<Integer> result = new ArrayList<Integer>();
					result.add(num[i]);
					result.add(num[start]);
					result.add(num[end]);
					set.add(result);
					start++; end--;
				} else if(num[start] + num[end] < rest) {
					start++;
				} else if(num[start] + num[end] > rest) {
					end--;
				}
			}
		}
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			results.add((ArrayList<Integer>)it.next());
		}
		
		return results;
	}
	
	private static int partition(int input[], int left, int right) {
		int i = left;
		int j = right;
		int temp;
		int pivot = input[(left+right)/2];
		
		while(i <= j) {
			while(input[i]<pivot) i++;
			while(input[j]>pivot) j--;
			if(i <= j) {
				temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				i++; j--;
			}
		}
		return i;
	}
	
	private static void quickSort(int input[], int left, int right){
		int index = partition(input, left, right);
		if(left < index-1) quickSort(input, left, index-1);
		if(index < right) quickSort(input, index, right);
	}
	
	public static void quickSort(int input[]) {
		int left = 0;
		int right = input.length-1;
		quickSort(input, left, right);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = new int[]{-2,0,1,1,2};
		ArrayList<ArrayList<Integer>> results = threeSum(num);
		for(ArrayList<Integer> re : results) {
			for(int i : re) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
