package th.leetcode;

public class UniquePathTwo {
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
			return obstacleGrid[0][0] == 1?0:1;
		}
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		// Destination could be 1, weird   
		if(obstacleGrid[row-1][col-1] == 1) return 0;
		int[][] matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
		matrix[row-1][col-1] = 1;
		for(int i = row-2; i >= 0; i--) {
			if(obstacleGrid[i][col-1] == 1) {
				matrix[i][col-1] = 0;
			} else {
				matrix[i][col-1] = matrix[i+1][col-1];
			}
		}
		
		for(int i = col-2; i>=0; i--) {
			if(obstacleGrid[row-1][i] == 1){
				matrix[row-1][i] = 0;
			} else {
				matrix[row-1][i] = matrix[row-1][i+1];
			}
		} 
		
		for(int i = row-2; i>=0; i--) {
			for(int j = col-2; j>=0; j--) {
				if(obstacleGrid[i][j] == 1) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
				}
			}
		}
		
		return matrix[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = new int[][]{{0,0}};
		System.out.println(uniquePathsWithObstacles(grid));
	}

}
