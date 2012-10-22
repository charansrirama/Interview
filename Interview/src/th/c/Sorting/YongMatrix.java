package th.c.Sorting;

public class YongMatrix {

	public static boolean search(int[][] array, int t) {
		int row = array.length, col = array[0].length;
		int i = 0, j = col-1;
		while(true) {
			if(array[i][j] == t) {
				return true;
			} else if(array[i][j] > t && j > 0) {
				j--;
			} else if(array[i][j] < t && i < row-1) {
				i++;
			} else {
				return false;
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
