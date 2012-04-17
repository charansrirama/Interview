package th.leetcode;

import java.util.ArrayList;

public class Permutation {

	public static void swap(int[] array, int i, int j) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static boolean getNextPerm(int[] list) {

		for (int i = list.length - 2; i >= 0; i--) {
			if (list[i] < list[i + 1]) {
				for (int j = list.length - 1; j > i; j--) {
					if (list[j] > list[i]) {
						swap(list, i, j);
						int start = i + 1;
						int end = list.length - 1;
						while (end >= start) {
							swap(list, start, end);
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
	
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0) return results;
        ArrayList<Integer> first = new ArrayList<Integer>();
        for(int i = 0; i < num.length; i++) {
        	first.add(num[i]);
        }
        results.add(first);
        while(getNextPerm(num)) {
        	ArrayList<Integer> result = new ArrayList<Integer>();
        	for(int i = 0; i < num.length; i++) {
        		result.add(num[i]);
        	}
        	results.add(result);
        }
        return results;
		
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] list = new int[]{-1,3,0,3};
		th.util.Sort.quickSort(list);
		//th.util.Printer.arrayPrinter(list);
		ArrayList<ArrayList<Integer>> result = permuteUnique(list);
		for(ArrayList<Integer> r : result) {
			for(Integer i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
