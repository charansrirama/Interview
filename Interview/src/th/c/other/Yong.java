package th.c.other;

public class Yong {
	
	public static boolean yong(int[][] array, int target) {
		int row = array.length, col = array[0].length;
		int i = 0, j = col-1;
		while(true) {
			if(array[i][j] == target) 
				return true;
			else if(array[i][j] < target && i < row-1) {
				i++;
			} else if(array[i][j] > target && j > 0) {
				j--;
			} else 
				return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
