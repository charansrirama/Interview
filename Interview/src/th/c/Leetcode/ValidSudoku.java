package th.c.Leetcode;

import java.util.Arrays;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[] check = new boolean[10];
		int row = board.length;
		int col = board[0].length;
		// Check row
		for(int i = 0; i < row; i++) {
			clearCheck(check);
			for(int j = 0; j < col; j++) {
				if(board[i][j] != '.') {
					int index = board[i][j] - '0';
					if(check[index]) return false;
					check[index] = true;
				}
			}
		}
		// Check col
		for(int j = 0; j < col; j++) {
			clearCheck(check);
			for(int i = 0; i < row; i++) {
				if(board[i][j] != '.') {
					int index = board[i][j] - '0';
					if(check[index]) return false;
					check[index] = true;
				}
			}
		}
		
		// Check sub box
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				clearCheck(check);
				for(int ii = 0; ii < 3; ii++) {
					for(int jj = 0; jj< 3; jj++) {
						int r = i*3+ii;
						int c = j*3+jj;
						if(board[r][c] != '.') {
							int index = board[r][c] - '0';
							if(check[index]) return false;
							check[index] = true;
						}
					}
				}
			}
		}
//		for(int i = 0; i < row; i++) {
//		clearCheck(check);
//		for(int j = 0; j < col; j++) {
//			int r = i/3*3 + j/3;
//			int c = i%3*3 + j%3;
//			if(board[i][j]  != '.') {
//				int index = board[r][c] - '0';
//				if(check[index]) return false;
//				check[index] = true;
//			}
//		}
//	}
		return true;
    }
	
	private void clearCheck(boolean[] check) {
		Arrays.fill(check, false);
	}
}
