package th.pocket.gems;

import java.util.*;

public class ArrayNotAppear {
	
	public static int[] findDiff(int[] array1, int[] array2) {
		List<Integer> set = new ArrayList<Integer>();
		for(int i = 0; i < array1.length; i++) {
			set.add(array1[i]);
		}
		
		for(int i = 0; i < array2.length;) {
			if(set.contains(array2[i]))
				set.remove(set.indexOf(array2[i]));
			else 
				i++;
		}
		
		int[] result = new int[set.size()];
		int count = 0;
		for(int i : set) {
			result[count++] = i;
		}
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = new int[] {1,4,5,3,1,6,8,7,6};
		int[] array2 = new int[] {4,7,6};
		th.util.Printer.arrayPrinter(findDiff(array1, array2));
	}

}
