package th.c.Leetcode;

public class PermutationSequence {

	public static void swap(int[] array, int start, int end) {
		int tmp = array[start];
		array[start] = array[end];
		array[end] = tmp;
	}
	
	public static boolean getNext(int[] array) {
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
	
	public static String getPermutation(int n, int k) {
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = i+1;
		}
		StringBuilder result = new StringBuilder();
		for(int i = 1; i <= k; i++) {
			getNext(array); 
		}
		for(int i : array) {
			result.append(i);
		}
		return result.toString();
	}
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3, 3));
	}

}
