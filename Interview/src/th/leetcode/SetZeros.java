package th.leetcode;

public class SetZeros {

	public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i = 0; i < row; i++) {
        	if(matrix[i][0] == 0) {
        		firstCol = true;
        		break;
        	}
        }
        for(int i = 0; i < col; i++) {
        	if(matrix[0][i] == 0) {
        		firstRow = true;
        		break;
        	}
        }
        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[0][j] = matrix[i][0] = 0;
        		}
        	}
        }
        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		if(matrix[i][0] == 0 || matrix[0][j] == 0)
        			matrix[i][j] = 0;
        	}
        }
        if(firstRow) {
        	for(int i = 0; i < col; i++) {
        		matrix[0][i] = 0;
        	}
        }
        if(firstCol) {
        	for(int i = 0; i < row; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
