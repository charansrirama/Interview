package th.c.Arrays;

// ooyala 电面

public class DiagonalPrint {
	
	public static void print(int[][] matrix) {
		int m = matrix.length-1, n = matrix[0].length-1;
		for(int k = 0; k <= m+n; k++) {
			int i = Math.min(k, n);
			for(int j = k-i; i >= 0 && j <=m; j++,i--) {
				System.out.print(matrix[j][i] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		print(m);
	}

}
