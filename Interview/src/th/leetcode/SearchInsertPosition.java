package th.leetcode;

public class SearchInsertPosition {
	public static int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
		if(len == 0) return 0;
	
        if(target <= A[0]) return 0;
        if(target > A[len-1]) return len;
        int i;
        for(i = 0; i < len-1; i++) {
        	if(A[i] == target) 
        		break;
        	else if(A[i] > target) {
        		break;
        	}
        }
        
		return i;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[]{-5000,-4999,-4998,-4996,-4995,-4990};
		System.out.println(searchInsert(data, -4991));
	}

}
