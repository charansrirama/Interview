package th.facebook;

import java.util.Arrays;

public class ThreeSum {

	public static void threeSum(int[] A, int target) {
		Arrays.sort(A);
		int len = A.length;
		for(int i = 0; i < len; i++) {
			int tmp = target-A[i];
			int p = i+1;
			int q = len-1;
			while(p < q) {
				if(A[p] + A[q] == tmp) {
					System.out.println(A[i] + " " + A[p] + " " + A[q]);
					while(p+1 < q && A[p] == A[p+1]) {
						p++;
					}
					p++;
				} else if(A[p]+A[q] < tmp) {
					p++;
				} else {
					q--;
				}
			}
			while(i+1 < len && A[i] == A[i+1]) {
				i++;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{0, 0, 0, 0, -1, -1, -1, -1, 2};
		threeSum(A, 0);
	}

}
