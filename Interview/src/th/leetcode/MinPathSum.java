package th.leetcode;

public class MinPathSum {

	public static int minPathSum(int[][] grid) {
		int rLen = grid.length;
		int cLen = grid[0].length;
		for(int i = rLen-2; i>=0; i--) {
			grid[i][cLen-1] += grid[i+1][cLen-1];
		}
		for(int i = cLen-2; i>=0; i--) {
			grid[rLen-1][i] += grid[rLen-1][i+1];
		}
		
		for(int i = rLen-2; i >= 0; i--) {
			for(int j = cLen-2; j>= 0; j--) {
				grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
			}
		}
        return grid[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = new int[5][6];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				a[i][j] = i*j;
			}
		}
		System.out.println(minPathSum(a));
	}

}
