package th.c.Leetcode;

public class SearchA2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
    	if(m == 0) return false;
		int n = matrix[0].length;
        if(n == 0) return false;
		int i = 0, j = n-1;
		while(true) {
            if(i >= m || j < 0) return false;
			if(matrix[i][j] == target) 
				return true;
			else if(matrix[i][j] > target && j >= 0) {
				j--;
			} else if(matrix[i][j] < target && i < m) {
				i++;
			} else 
				return false;
		}
    }
	
}
