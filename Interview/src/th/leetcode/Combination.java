package th.leetcode;

import java.util.*;

public class Combination {

	public static void combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] array = new int[n];
        for(int i = 0; i < n-k; i++) array[i]=0;
        for(int i = n-k; i < n; i++) array[i]=1;
        print(array);
        
        while(getNextPerm(array)) {
        	print(array);
        }
    }
	
	private static boolean getNextPerm(int[] array) {
		for(int i = array.length-2; i>=0; i--) {
			if(array[i]<array[i+1]) {
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
	
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	private static void print(int[] array) {
		for(int i = 0; i < array.length; i++)
			if(array[i] == 1) {
				System.out.print((i+1) + " ");
			}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		combine(4, 2);
	}

}
