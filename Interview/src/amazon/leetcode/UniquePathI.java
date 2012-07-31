package amazon.leetcode;

public class UniquePathI {
	private void swap(int[] array, int i, int j) {
		int tmp  = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	private boolean getNextPerm(int[] array) {
		for(int i = array.length-2; i>=0; i--) {
			if(array[i] < array[i+1]) {
				for(int j = array.length-1; j > i; j--) {
					if(array[j] > array[i]) {
						swap(array, i, j);
						int start = i, end = array.length-1;
						while(start <= end) {
							swap(array, start, end);
							start++; end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public int uniquePaths(int m, int n) {
		int[] move = new int[m+n-2];
		for(int i = 0; i < m-1; i++) {
			move[i] = 0;
		}
		for(int i = 0; i < n-1; i++) {
			move[m-1+i] = 1;
		}
		int count = 1;
		while(getNextPerm(move)) {
			count++;
		}
		return count;
	}
	
	public int uniquePathsDP(int m, int n) {
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i++) 
			matrix[i][n-1] = 1;
		for(int i = 0; i < n; i++) 
			matrix[m-1][0] = 1;
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				matrix[i][j] = matrix[i+1][j] + matrix[i][j];
			}
		}
		return matrix[0][0];
	}
}
