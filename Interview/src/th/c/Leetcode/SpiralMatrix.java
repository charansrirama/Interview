package th.c.Leetcode;

import java.util.*;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int A = 0, B = matrix.length;
		if(B == 0) return result;
		B--;
		int C = 0, D = matrix[0].length;
		if(D == 0) return result;
		D--;
		if(B == 0) {
			for(int i = 0; i <= D; i++) 
				result.add(matrix[B][i]);
			return result;
		}
		if(D == 0) {
			for(int i = 0; i <= B; i++) 
				result.add(matrix[i][D]);
			return result;
		}
		while(A <= B && C <= D) {
			for(int i = C; i <= D; i++) 
				result.add(matrix[A][i]);
			A++;
			if(A > B) break;
			for(int i = A; i <= B; i++) 
				result.add(matrix[i][D]);
			D--;
			if(D < C) break;
			for(int i = D; i >= C; i--) 
				result.add(matrix[B][i]);
			B--;
			if(B < A) break;
			for(int i = B; i >= A; i--) 
				result.add(matrix[i][C]);
			C++;
		}
		return result;
    }
}
