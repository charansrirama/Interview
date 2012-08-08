package th.pocket.gems;

import java.util.*;

public class SpiralPrint {
	public static ArrayList<Integer> spiralPrint(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int A = 0, B = matrix.length-1;
		int C = 0, D = matrix[0].length-1;
		
		while(A <= B && C <= D) {
			for(int i = C; i <= D; i++) {
				result.add(matrix[A][i]);
			}
			A++;
			if(A>B) break;
			for(int i = A; i <= B; i++) {
				result.add(matrix[i][D]);
			}
			D--;
			if(D<C) break;
			for(int i = D; i >= C; i--) {
				result.add(matrix[B][i]);
			}
			B--;
			if(B<A) break;
			for(int i = B; i >= A; i--) {
				result.add(matrix[i][C]);
			}
			C++;
		}
		return result;
	}
	public static void main(String[] args) {
		int count = 0;
		int array[][] = new int[5][5];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = count++;
			}
		}
//		int matrix[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		int matrix[][] = {{1},{2},{3},{4}};
		ArrayList<Integer> result = spiralPrint(matrix);
		for(Integer i : result) {
			System.out.print(i + " ");
		}
	}
}
