package th.c.Leetcode;

import java.util.*;

public class PascalsTriangle {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		if(numRows < 0) return results;
		int[][] matrix = new int[numRows][numRows];
		for(int i = 0; i < numRows; i++) matrix[i][0] = 1;
		for(int i = 1; i < numRows; i++) {
			for(int j = 1; j < i+1; j++) {
				matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
			}
		}
		for(int i = 0; i < numRows; i++) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			for(int j = 0; j < i+1; j++) {
				result.add(matrix[i][j]);
			}
			results.add(result);
		}
		return results;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
