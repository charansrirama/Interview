package th.DP;

public class GridPath {
	
	public static int countGridPath(int row, int col) {
		int[][] grid = new int[row+1][col+1];
		for(int i = 0; i <= row; i++) {
			grid[i][row] = 1;
		}
		for(int i = 0; i <= col; i++) {
			grid[row][i] = 1;
		}
		
		for(int i = row-1; i >= 0; i--) {
			for(int j = col-1; j >= 0; j--) {
				grid[i][j] = grid[i+1][j] + grid[i][j+1];
			}
		}
		return grid[0][0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countGridPath(20,20));
	}

}
