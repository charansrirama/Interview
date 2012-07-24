package amazon;

public class UniquePathsII {
	public int uniquePaths(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(m == 1 && n == 1) 
			return obstacleGrid[0][0] == 1 ? 0 : 1;
		if(obstacleGrid[m-1][n-1] == 1) 
			return 0;
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m-1; i++) {
			if(obstacleGrid[i][n-1] != 1) 
				matrix[i][n-1] = 1;
			else 
				matrix[i][n-1] = 0;
		}
		for(int i = 0; i < n-1; i++) {
			if(obstacleGrid[m-1][i] != 1) 
				matrix[m-1][i] = 1;
			else
				matrix[m-1][i] = 0;
		}
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				if(obstacleGrid[i][j] != 1)
					matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
				else 
					matrix[i][j] = 0;
			}
		}
		return matrix[0][0];
	}
}
