package th.pocket.gems;

public class Rotated2DArray {

	public static void rotate(int[][] m) {
		int len = m.length-1;
		for(int i = 0; i <= len/2; i++) {
			for(int j = i; j < len-i; j++) {
				int tmp = m[i][j];
				m[i][j] = m[len-j][i];
				m[len-j][i] = m[len-i][len-j];
				m[len-i][len-j] = m[j][len-i];
				m[j][len-i] = tmp;
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
