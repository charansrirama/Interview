package th.c.Leetcode;

public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
		if(word == null || word.length() == 0) return true;
		if(board == null || board.length == 0) return false;
		boolean[][] table = new boolean[board.length][board[0].length];
		for(int i = 0; i < table.length; i++)
			for(int j = 0; j < table[0].length; j++)
				table[i][j] = false;
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				if(matchSuffix(board, i, j, word, 0, table))
					return true;
			}
		}
		return false;
    }
	
	public boolean matchSuffix(char[][] board, int i, int j, String word, int start, boolean[][] table) {
		int[] rowOffset = {-1,0,1,0};
		int[] colOffset = {0,1,0,-1};
		if(word.charAt(start) == board[i][j]) {
			if(start == word.length()-1)
				return true;
			table[i][j] = true;
			for(int k = 0; k < 4; k++) {
				int p = i+rowOffset[k];
				int q = j+colOffset[k];
				
				if(p >= 0 && q >= 0 && p < board.length && q < board[0].length && !table[p][q]) {
					boolean match = matchSuffix(board, p, q, word, start+1, table);
					if(match) return true;
				}
			}
			table[i][j] = false;
			return false;
		} else 
			return false;
	}
}
