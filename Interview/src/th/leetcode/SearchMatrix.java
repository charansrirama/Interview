package th.leetcode;

public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int col = matrix[0].length;
		for(int i = 0; i < matrix.length; i++) {
			if(target <= matrix[i][col-1]) {
				int start = 0; 
				int end = col-1;
				while(start <= end) {
					int mid = (start + end)/2;
					if(matrix[i][mid] == target)
						return true;
					else {
						if(matrix[i][mid] < target) {
							start = mid+1;
						} else {
							end = mid-1;
						}
					}
				}
				break;
			}
		}
		
		return false;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
