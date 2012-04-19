package th.leetcode;

public class UniquePathOne {
	
	public static int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// 0 for down move, 1 for right move
		int[] move = new int[n+m-2];
		for(int i = 0; i < m-1; i++) {
			move[i] = 0;
		}
		
		for(int i = 0; i < n-1; i++) {
			move[m-1+i] = 1;
		}
		th.util.Printer.arrayPrinter(move);
		int count = 1;
		while(getNextPerm(move)){
			count++;
		}
		return count;
    }
	
	public static boolean getNextPerm(int[] move) {
		for(int i = move.length-2; i >= 0; i--) {
			if(move[i] < move[i+1]){
				for(int j = move.length-1; j > i; j--) {
					if(move[j] > move[i]) {
						swap(move, i, j);
						int start = i+1;
						int end = move.length-1;
						while(end >= start) {
							swap(move, start, end);
							start++; end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static void swap(int[] move, int i, int j) {
		int temp = move[i];
		move[i] = move[j];
		move[j] = temp;
	}
	
	//DP method
	public static int uniquePaths2(int m, int n) {
		int[][] matrix = new int[m][n];
		for(int i = 0; i < matrix.length; i++) {
			matrix[i][matrix[0].length-1] = 1;
		}
		
		for(int i = 0; i < matrix[0].length; i++) {
			matrix[matrix.length-1][i] = 1;
		}
		
		for(int i = m-2; i>=0; i--) {
			for(int j = n-2; j >=0; j--) {
				matrix[i][j] = matrix[i+1][j] + matrix[i][j+1];
			}
		}
		return matrix[0][0];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(uniquePaths2(2,2));
	}

}
