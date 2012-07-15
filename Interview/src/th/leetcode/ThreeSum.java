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
	
	public static int[] threeNumZeroSum(int[] list) {
	    int[] result = null;
	    Set<Integer> set = new HashSet<Integer>();
	    for(int i = 0; i < list.length; i++) {
	        set.add(list[i]);
	    }
	    for(int i = 0; i < list.length; i++) {
	        for(int j = i+1; j < list.length; i++) {
	            int lookFor = -(list[i] + list[j]);
	            if(set.contains(lookFor)) {
	                result = new int[3];
	                result[0] = list[i];
	                result[1] = list[j];
	                result[2] = lookFor;
	                break;
	            }
	        }
	    }
	    return result;
	}
	
	public static void threesum(int[] A, int target) {
		Arrays.sort(A);
		int len = A.length;
		for(int i = 0; i < len; i++) {
			int tmp = target-A[i];
			int p = i+1;
			int q = len-1;
			while(p < q) {
				if(A[p]+A[q] == tmp) {
					System.out.println(A[i] + " " + A[p] + " " + A[q]);
					while(p < q && A[p] == A[p+1]){
						p++;
					}
					p++;
				} else if(A[p] + A[q] > tmp) {
					q--;
				} else {
					p++;
				}
			}
			while(i+1 < len && A[i] == A[i+1]){
				i++;
			}
		}
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
