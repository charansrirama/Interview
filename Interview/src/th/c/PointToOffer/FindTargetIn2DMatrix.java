package th.c.PointToOffer;

public class FindTargetIn2DMatrix {
	
	public static boolean findIn2DArray(int[][] A, int target) {
		if(A == null) return false;
		int row = A.length;
		int col = A[0].length;
		
		int i = 0, j = col-1;
		while(i < row && j >= 0) {
			if(A[i][j] == target) 
				return true;
			else if(A[i][j] > target) 
				j--;
			else 
				i++;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = {
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		System.out.println(findIn2DArray(A, 7));
		System.out.println(findIn2DArray(A, 1));
		System.out.println(findIn2DArray(A, 15));
		System.out.println(findIn2DArray(A, 0));
	}

}
