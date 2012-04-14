package th.leetcode;

public class RemoveDuplicate {
	
	/*
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
	 * Do not allocate extra space for another array, you must do this in place with constant memory.
	 * For example.
	 * Given input array A[] = [1,1,2],
	 * Your function should return length = 2, and A[] is now [1,2].
	 */
	
	public static int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(A.length == 0) return 0;
		if(A.length == 1) return 1;
        int length = A.length;
        int i = 0, j = 0;
        
        while(j < length-1) {
            while((j+1) < length && A[j] == A[j+1]) {
                j++;
            }
            A[i] = A[j];
            i++; j++;
        }
        if(A[length-1] != A[length-2]) {
        	A[i] = A[length-1];
        	i++;
        }
        return i;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[]{1}));
	}

}
