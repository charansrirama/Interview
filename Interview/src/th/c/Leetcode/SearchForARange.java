package th.c.Leetcode;

public class SearchForARange {

	public static int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0) return null;
        int i = 0, j = A.length-1;
        int[] result = new int[2];
        while(i < j) {
            int mid = i + (j-i)/2;
            if(A[mid] == target) {
                int l = i, r = mid;
                while(l < r) {
                    int mi = l + (r-l)/2;
                    if(A[mi] < target) {
                        l = mi+1;
                    }else {
                        r = mi-1;
                    }
                }
                result[0] = l;
                l = mid; r = j;
                while(l < r) {
                    int mi = l + (r-l)/2;
                    if(A[mi] > target) 
                        r = mi-1;
                    else
                        l = mi+1;
                }
                result[1] = l-1;
                return result;
            } else if(A[mid] > target) {
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {
				5,7,7,8,8,10
		};
		searchRange(A, 8);
	}

}
