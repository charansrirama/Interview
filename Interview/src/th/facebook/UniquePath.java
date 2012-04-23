package th.facebook;

public class UniquePath {

	public static int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];
		if(m == 0 || n == 0) return 1;
		matrix[m-1][n-1] = 1;
		for(int i = m-2; i >= 0; i--) {
			matrix[i][n-1] = matrix[i+1][n-1];
		}
        for(int i = n-2; i >= 0; i--) {
        	matrix[m-1][i] = matrix[m-1][i+1];
        }
        
        for(int i = m-2; i>= 0; i--) {
        	for(int j = n-2; j >= 0; j--) {
        		matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
        	}
        }
        return matrix[0][0];
    }
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		if(row == 0 && col == 0) {
			return obstacleGrid[0][0] == 0 ? 1: 0;
		}
		if(obstacleGrid[row-1][col-1] == 1) return 0;
		int[][] matrix = new int[row][col];
		matrix[row-1][col-1] = 1;
		
		for(int i = row-2; i>=0; i--) {
			if(obstacleGrid[i][col-1] == 1) 
				matrix[i][col-1] = 0;
			else 
				matrix[i][col-1] = matrix[i+1][col-1];
		}
		
		for(int i = col-2; i>=0; i--) {
			if(obstacleGrid[row-1][i] == 1) 
				matrix[row-1][i] = 0;
			else 
				matrix[row-1][i] = matrix[row-1][i+1];
		}
		
		for(int i = row-2; i>=0; i--) {
			for(int j = col-2; j>=0; j--) {
				if(obstacleGrid[i][j] == 1) {
					matrix[i][j] = 0;
				} else 
					matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
			}
		}
		return matrix[0][0];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(uniquePaths(0,2));
	}

}
