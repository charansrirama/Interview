package amazon;

public class SearchMatrix {
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		int col = matrix[0].length;
		for(int i = 0; i < matrix.length; i++) {
			if(target <= matrix[i][col-1]) {
				int low = 0;
				int high = col-1;
				while(low <= high) {
					int mid = (low+high)/2;
					if(matrix[i][mid] == target) return true;
					else if(matrix[i][mid] < target) low = mid+1;
					else high = mid-1;
				}
				break;
			}
		}
		return false;
	}
	
	// NOT AC
	public static boolean searchMatrix1(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;
		if(row<=0 || col<=0) return false;
		int low = 0, high = row*col-1;
		while(low <= high) {
			int mid = (low+high)/2;
			int tmp = matrix[mid/row][mid%col];
			if(tmp == target) return true;
			else if(tmp > target) high = mid-1;
			else low = mid+1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] array = {{1,3,4,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(array, 3));
	}
}
