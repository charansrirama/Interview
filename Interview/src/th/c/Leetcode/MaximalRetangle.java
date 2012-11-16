package th.c.Leetcode;

import java.util.*;

public class MaximalRetangle {

	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0) return 0;
		int[][] auxillary = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < auxillary.length; i++) {
			for(int j = 0; j < auxillary[i].length; j++) {
				auxillary[i][j] = Character.getNumericValue(matrix[i][j]);
			}
		}
		for(int i = 1; i < auxillary.length; i++) {
			for(int j = 0; j < auxillary[i].length; j++) {
				if(auxillary[i][j] == 1) 
					auxillary[i][j] = auxillary[i-1][j] + 1;
			}
		}
		int max = 0;
		for(int i = 0; i < auxillary.length; i++) {
			max = Math.max(max, LargestRetangleArea(auxillary[i]));
		}
		return max;
    }
	
	public static int LargestRetangleArea(int[] height) {
		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indeces = new Stack<Integer>();
		int max = 0;
		for(int i = 0; i < height.length; i++) {
			if(heights.isEmpty() || heights.peek() < height[i]) {
				heights.push(height[i]);
				indeces.push(i);
			} else if(heights.peek() > height[i]){
				int lastIndex = 0;
				while(!heights.isEmpty() && heights.peek() > height[i]) {
					lastIndex = indeces.pop();
					int tmp = (i-lastIndex) * heights.pop();
					max = max < tmp ? tmp : max;
				}
				heights.push(height[i]);
				indeces.push(lastIndex);
			}
		}
		while(!heights.isEmpty()) {
			int tmp = (height.length-indeces.pop()) * heights.pop();
			max = max < tmp ? tmp : max;
		}
		return max;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
