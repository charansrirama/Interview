package th.c.company.storm8;

import java.util.Arrays;

public class UniquePath {
	
	public int unique1(int m, int n) {
		if(m <= 0 || n <= 0) return 0;
		int[] b = new int[n];
		Arrays.fill(b, 1);
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				b[j] += b[j+1];
			}
		}
		return b[0];
	}
	
	public int unique2(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		if(m == 1 && n == 1) return obstacleGrid[0][0] == 1 ? 0 : 1;
		int[] b = new int[n];
		if(obstacleGrid[m-1][n-1] == 1) return 0;
		else b[n-1] = 1;
		for(int i = n-2; i >= 0; i--) {
			if(obstacleGrid[m-1][i] == 1) break;
			else b[i] = b[i+1]; 
		}
		
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-1; j >= 0; j--) {
				if(j == n-1) b[j] = obstacleGrid[i][j] == 1 ? 0 : b[j];
				else b[j] = obstacleGrid[i][j] == 1 ? 0 : b[j] + b[j+1];
			}
		}
		return b[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
