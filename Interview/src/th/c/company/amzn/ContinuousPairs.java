package th.c.company.amzn;

import java.util.Arrays;

public class ContinuousPairs {
	
	public static String continuousPairs(int[] A) {
		if(A == null || A.length == 0) return "";
		if(A.length == 1) return "(" + A[0] + "," + A[0] + ")";
		Arrays.sort(A);
		StringBuffer buffer = new StringBuffer();
		int start = 0;
		for(int i = 1; i < A.length; i++) {
			if(A[i] - A[i-1] != 1) {
				buffer.append("(" + A[start] + "," + A[i-1] + ")");
				start = i;
			}
			if(i == A.length-1) buffer.append("(" + A[start] + "," + A[i] + ")");
		}
		return buffer.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,4,5,7,8,14,15,16};
		int[] B = {1};
		System.out.println(continuousPairs(B));
	}

}
