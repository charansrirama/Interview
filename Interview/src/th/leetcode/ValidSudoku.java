package th.leetcode;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
		for(int i = 0; i < row; i++){
			clearCheck(check);
			for(int j = 0; j < col; j++) {
				int r = i/3*3 + j/3;
				int c = i%3*3 + j%3;
				if(board[r][c] != '.'){
					int index = board[r][c] - '0';
					if(check[index]) return false;
					check[index] = true;
				}
			}
		}
		
        return true;
    }
	
	private static void clearCheck(boolean[] check) {
		for(int i = 0; i < check.length; i++) {
			check[i] = false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.println((i/3*3+j/3) + " " + (i%3*3 + j%3)); 
			}
		}
	}

}
