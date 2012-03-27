package th.hard;

import java.util.ArrayList;
import java.util.Hashtable;
import th.util.*;

public class TwoSum {

	public static ArrayList<ArrayList<Integer>> findTwoSumSimple(int array[], int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		
		Sort.quickSort(array);
		int i = 0;
		int j = array.length-1;
		while(i < j) {
			if(array[i] + array[j] < sum) 
				i++;
			else if(array[i] + array[j] > sum)
				j--;
			else if(array[i] + array[j] == sum) {
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(array[i]);
				pair.add(sum-array[i]);
				results.add(pair);
				i++; j--;
			}
		}
		
		return results;
	}
	
	public static ArrayList<ArrayList<Integer>> findTwoSum(int array[], int sum) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		
		Hashtable<Integer, Integer> pairs = new Hashtable<Integer, Integer>();
		for(int i = 0; i < array.length; i++) {
			if(pairs.containsValue(array[i])) {
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(array[i]);
				pair.add(sum-array[i]);
				results.add(pair);
			} else {
				pairs.put(array[i], sum-array[i]);
			}
		}
		return results;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[]{0,3,4,5,1,2,6};
		
		ArrayList<ArrayList<Integer>> results = findTwoSumSimple(array, 6);
		for(ArrayList<Integer> pair : results) {
			for(Integer i : pair) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
