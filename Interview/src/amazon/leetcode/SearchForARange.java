package amazon.leetcode;

public class SearchForARange {
	// AC
	public int[] searchRange(int[] A, int target) {
		int start = 0, end = A.length-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(A[mid] == target) {
				int s = mid-1;
				int e = mid+1;
				while(s>=0 && A[s] == target) {
					s--;
				}
				s++;
				while(e<A.length && A[e] == target) {
					e++;
				}
				e--;
				return new int[]{Math.max(s, 0), Math.min(e, A.length-1)};
			} else if(A[mid] > target) {
				end = mid-1;
			} else if(A[mid] < target) {
				start = mid+1;
			}
		}
		return new int[]{-1,-1};
    }
}
