package amazon.leetcode;

// AC
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int c = grid[0].length;
		int r = grid.length;
		for(int i = r-2; i >= 0; i--) 
			grid[i][c-1] += grid[i+1][c-1];
		for(int i = c-2; i >= 0; i--) 
			grid[r-1][i] += grid[r-1][i+1];
		
		for(int i = r-2; i >= 0; i++) {
			for(int j = c-2; j >= 0; j++) {
				grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
			}
		}
		return grid[0][0];
	}
}
