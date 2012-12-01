package th.c.company.amzn;

/*
 * 000000000000000
 * 111011110000001
 * 010111000000000
 * 000000000000000
 * Ans = 3
 */
public class BlockNumber {
	public int getAdjArea(int[][] A) {
		if(A == null || A.length == 0) return 0;
		int m = A.length, n = A[0].length;
		int res = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(A[i][j] == 1) {
					res++;
					helper(A, i, j, m, n);
				}
			}
		}
		return res;
	}
	
	private void helper(int[][] A, int i, int j, int m, int n) {
		if(i < 0 || i > m-1 || j < 0 || j > m-1) return;
		A[i][j] = -1;
		if(i > 0 && A[i-1][j] == 1) 
			helper(A, i-1, j, m, n);
		if(i < m-1 && A[i+1][j] == 1)
			helper(A, i+1, j, m, n);
		if(j > 0 && A[i][j-1] == 1)
			helper(A, i, j-1, m, n);
		if(j < n-1 && A[i][j+1] == 1)
			helper(A, i, j+1, m, n);
	}
}
