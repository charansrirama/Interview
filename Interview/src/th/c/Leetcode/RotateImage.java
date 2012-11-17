package th.c.Leetcode;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int m = matrix.length-1;
		if(m <= 0) return;
		for(int i = 0; i <= m/2; i++) {
			for(int j = i; j < m-i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[m-j][i];
				matrix[m-j][i] = matrix[m-i][m-j];
				matrix[m-i][m-j] = matrix[j][m-i];
				matrix[j][m-i] = tmp;
			}
		}
	}
}
