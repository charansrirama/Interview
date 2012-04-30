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
	
	// Binary Search 
	public boolean searchMatrix1(int[][] matrix, int target) {
		int row = matrix.length;
		if(row <= 0) return false;
		int col = matrix[0].length;
		if(col <= 0) return false;
		
		int low = 0; 
		int high = row*col-1;
		int mid = 0;
		while(low <= high) {
			mid = (low+high)/2;
			int tmp = matrix[mid/row][mid%col];
			
			if(tmp < target) {
				low = mid-1;
			} else if(tmp > target) {
				high = mid+1;
			} else {
				return true;
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
