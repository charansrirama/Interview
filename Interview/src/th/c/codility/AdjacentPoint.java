package th.c.codility;

import java.util.Arrays;

public class AdjacentPoint {

	public static int findAdjacentPoint(int[] A) {
		int result = 0;
		Arrays.sort(A);
		int len = A.length;
		for(int i = 0; i < len-1; i++) {
			if(A[i] == 100000000) return -1;
			result++;
			for(int j = i+2; j < len; j++) {
				if(A[i] == 100000000) return -1;
				if(A[j] == A[i+1] || (A[i]==A[j-1] &&A[i]!=A[j]))
					result++;
				else 
					break;
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{
			0,3,3,7,5,3,11,1	
		};
		int[] B = new int[]{
				0,0,0,0
		};
		
		System.out.println(findAdjacentPoint(A));
		System.out.println(findAdjacentPoint(B));
	}

}
