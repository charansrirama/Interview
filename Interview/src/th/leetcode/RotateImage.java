package th.leetcode;

public class RotateImage {

	public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int len = matrix.length-1;
		for(int i = 0; i <= len/2; i++) {
			for(int j = i; j < len-i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[len-j][i];
				matrix[len-j][i] = matrix[len-i][len-j];
				matrix[len-i][len-j] = matrix[j][len-i];
				matrix[j][len-i] = tmp;
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
