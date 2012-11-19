package th.c.Leetcode;

public class SudokuSolve {

	public void solveSudoku(char[][] board) {
		solve(0,0,board);
    }
	
	private boolean solve(int i, int j, char[][] board) {
		if(i == 9) {
			i = 0;
			if(++j == 9) return true;
		}
		if(board[i][j] != '.') 
			return solve(i+1, j, board);
		for(char val = '1'; val <= '9'; val++) {
			if(legal(i, j, val, board)) {
				board[i][j] = val;
				if(solve(i+1, j, board))
					return true;
			}
		}
		board[i][j] = '.';
		return false;
	}
	
	private boolean legal(int i, int j, char val, char[][] board) {
		for(int k = 0; k < 9; k++) 
			if(val == board[k][j]) return false;
		for(int k = 0; k < 9; k++)
			if(val == board[i][k]) return false;
		int boxRow = (i/3)*3;
		int boxCol = (j/3)*3;
		for(int k = 0; k < 3; k++){
			for(int m = 0; m < 3; m++) 
				if(val == board[boxRow+k][boxCol+m]) return false;
		}
		return true;
	}
}
