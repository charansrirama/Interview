package th.pocket.gems;

public class Flip2DArray {
	
	public static void flip(int[][] m) {
		int row = m.length;
		int col = m[0].length;
		boolean firstR = false, firstC = false;
		
		for(int i = 0; i < row; i++) 
			if(m[i][0] == 0)
				firstC = true;
		for(int i = 0; i < col; i++) 
			if(m[0][i] == 0)
				firstR = true;
		
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				if(m[i][j] == 0) {
					m[0][j] = m[i][0] = 0;
				}
			}
		}
		
		for(int i = 0; i < row; i++) {
			if(m[i][0] == 0) {
				for(int j = 0; j < col; j++) {
					m[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < col; i++) {
			if(m[0][i] == 0) {
				for(int j = 0; j < row; j++) {
					m[j][i] = 0;
				}
			}
		}
		
		if(firstC) 
			for(int i = 0; i < row; i++) 
				m[i][0] = 0;
		if(firstR) 
			for(int i = 0; i < col; i++) 
				m[0][i] = 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
