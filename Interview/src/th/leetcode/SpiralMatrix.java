package th.leetcode;

import java.util.ArrayList;

// watch out the if condition in while loop.

public class SpiralMatrix {
	public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        int A = 0, B = matrix.length-1;
        int C = 0, D = matrix[0].length-1;
        if(B == 0) {
        	for(int i = 0; i <= D; i++) 
        		result.add(matrix[0][i]);
        	return result;
        }
        if(D == 0) {
        	for(int i = 0; i <= B; i++) 
        		result.add(matrix[i][0]);
        	return result;
        }
        while(A <= B && C <= D){
        	for(int i = A; i <= D; i++) {
        		result.add(matrix[A][i]);
        	}
        	C++;
        	if(C>B)break;
        	for(int i = C; i <= B; i++) {
        		result.add(matrix[i][D]);
        	}
        	D--;
        	if(D<A)break;
        	for(int i = D; i >= A; i--) {
        		result.add(matrix[B][i]);
        	}
        	B--;
        	if(B < C)break;
        	for(int i = B; i >= C; i--) {
        		result.add(matrix[i][A]);
        	}
        	A++;
        }
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;
		int array[][] = new int[5][5];
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = count++;
			}
		}
		int matrix[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		ArrayList<Integer> result = spiralOrder(matrix);
		for(Integer i : result) {
			System.out.print(i + " ");
		}
	}

}
