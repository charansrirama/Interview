package th.pocket.gems;

import java.util.*;

public class TwoSum {

	// Sorted method
	public static int[] twoSum(int[] array, int target) {
		Arrays.sort(array);
		int[] result = {-1,-1};
		int start = 0, end = array.length-1; 
		while(start < end) {
			if(array[start] + array[end] == target) {
				result[0] = array[start];
				result[1] = array[end];
				break;
			} else if(array[start] + array[end] > target) {
				end--;
			} else {
				start++;
			}
		}
		return result;
	}
	
	// Hashtable
	public static int[] twoSum2(int[] array, int target) {
		int[] result = {-1,-1};
		
		Hashtable table = new Hashtable();
		for(int i = 0; i < array.length; i++) {
			if(table.containsKey(array[i])) {
				int v = (Integer)table.get(array[i]);
				result[0] = v;
				result[1] = array[i];
				break;
			} else {
				int left = target - array[i];
				table.put(left, array[i]);
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,1,3,4,5,7,9,9};
		int[] result = twoSum(array, 9);
		System.out.println(result[0] + ", " + result[1]);
		int[] result2 = twoSum2(array, 10);
		System.out.println(result2[0] + ", " + result2[1]);
	}

}
