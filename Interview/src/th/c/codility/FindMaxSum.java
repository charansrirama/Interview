package th.c.codility;

public class FindMaxSum {

	/*
	 * Problem Statement
	 * 
	 * A chessboard of size N * M (i.e. N rows and M columns) is given. Each
	 * field of the chessboard can be indexed using a pair of integers (P, Q)
	 * where and .
	 * 
	 * On each field of the chessboard there lies a number of rice grains. A
	 * pawn is initially located at field (0, 0). It can perform two kinds of
	 * moves:
	 * 
	 * •move from field (P, Q) to field (P+1, Q) or in right / column •move from
	 * field (P, Q) to field (P, Q+1). down/ row After N+M-2 moves the pawn will
	 * arrive at field (N-1, M-1). During its movement through the chessboard it
	 * collects all the rice grains from the fields it stands on.
	 * 
	 * Write a function
	 * 
	 * class Solution { public int rice_chessboard(int[][] A); }
	 * 
	 * that given a matrix of size N * M describing the number of rice grains
	 * lying on each field of a N * M chessboard returns the maximal number of
	 * rice grains a pawn can collect while moving from the field (0, 0) to the
	 * field (N-1, M-1) in the manner specified above. Assume that . Assume that
	 * each element of the matrix is a non-negative integer not exceeding 200.
	 * 
	 * For example, given matrix A such that 
	 * A[0][0]=2 A[0][1]=2 A[0][2]=3 A[0][3]=0 
	 * A[1][0]=0 A[1][1]=3 A[1][2]=1 A[1][3]=1 
	 * A[2][0]=1 A[2][1]=2 A[2][2]=2 A[2][3]=1 
	 * A[3][0]=4 A[3][1]=1 A[3][2]=2 A[3][3]=2
	 * 
	 * the function should return 15.
	 * 
	 * One of the paths that the pawn can take : A[0][0], A[0][1], A[1][1],
	 * A[2][1], A[2][2], A[3][2], A[3][3]
	 * 
	 * Following this path the pawn will collect A[0][0] + A[0][1] + A[1][1] +
	 * A[2][1] + A[2][2] + A[3][2] + A[3][3] = 2 + 2 + 3 + 2 + 2 + 2 + 2 = 15
	 * rice grains. There is no path the pawn can take to collect more than 15
	 * rice grains.
	 */
	
	public static int rice_chessboard(int[][] A) {
		if(A == null) return 0;
		if(A.length == 0 || A[0].length == 0) return 0;
		int m = A.length;
		int n = A[0].length;
		if(m == 1 && n == 1) return A[0][0];
		if (n < m) {
			int[] dp = new int[n];
			dp[n - 1] = A[m - 1][n - 1];
			for (int i = n - 2; i >= 0; i--) {
				dp[i] = A[m - 1][i] + dp[i + 1];
			}

			for (int i = m - 2; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (j == n - 1) {
						dp[j] += A[i][j];
					} else {
						dp[j] = A[i][j] + Math.max(dp[j], dp[j + 1]);
					}
				}
			}
			return dp[0];
		} else {
			int[] dp = new int[m];
			dp[m - 1] = A[m - 1][n - 1];
			for (int i = m - 2; i >= 0; i--) {
				dp[i] = A[i][n - 1] + dp[i + 1];
			}
			for (int i = n - 2; i >= 0; i--) {
				for (int j = m - 1; j >= 0; j--) {
					if (j == m - 1) {
						dp[j] += A[j][i];
					} else {
						dp[j] = A[j][i] + Math.max(dp[j], dp[j + 1]);
					}
				}
			}
			return dp[0];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {
			{2,2,3,0},
			{0,3,1,1},
			{1,2,2,1},
			{4,1,2,2}
		};
		int[][] A2 = {
			{2,2,3,0}
		};
		int[][] A3 = {
				{2},
				{0},
				{1},
				{4}
		};
		int[][] A4 = {{}};
		System.out.println(rice_chessboard(A));
		System.out.println(rice_chessboard(A2));
		System.out.println(rice_chessboard(A3));
		System.out.println(rice_chessboard(A4));
	}

}
