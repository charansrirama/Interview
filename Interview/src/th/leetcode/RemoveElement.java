package th.leetcode;

public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int j = A.length - 1;
		while (j >= 0 && A[j] == elem) {
			j--;
		}
		
		if(j < 0) return 0;
		
		for (int i = 0; i <= j; i++) {
			if (A[i] == elem) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
				
                while(j >= 0 && A[j] == elem)
				    j--;
			}
		}

		return j+1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = new int[]{0,0,1,2,4,1,0,4,4,0,1,3};
		int[] B = new int[]{2,2,2,2,2,2};
		System.out.println(removeElement(B, 2));
		System.out.println(removeElement(A, 1));
	}

}
