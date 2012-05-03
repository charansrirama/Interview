package th.leetcode;

public class SortedColor {

	// Dutch flag problem
	public static void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int p = 0; 
        int q = A.length-1;
        for(int i = 0; i <= q;) {
        	if(A[i] == 0) {
        		swap(A, i, p);
        		p++; i++;
        	} else if(A[i] == 2) {
        		swap(A, i, q);
        		q--;
        	} else 
        		i++;
        }
    }
	
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
