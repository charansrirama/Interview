package th.leetcode;

public class SearchRange {
	// Watch out two test case
	// 1. {1} 2. {1,1,1,1,1,1}
	// Line 35 handles this two situation
	public static int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0;
        int end = A.length-1;
        int s = 0; 
        int e = 0;
        while(start<=end) {
            int mid = (start+end)/2;
            if(A[mid] == target) {
                s = mid-1;
                e = mid+1;
                while(s >= 0) {
                    if(A[s] == target)
                        s--;
                    else {
                        s++; 
                        break;
                    }
                }
                while(e < A.length) {
                    if(A[e] == target) 
                        e++;
                    else {
                        e--;
                        break;
                    }
                }
                return new int[]{Math.max(s, 0), Math.min(e, A.length-1)};
            }else if(A[mid] < target) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return new int[]{-1, -1};
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[]{1,1,1};
		int[] range = searchRange(data, 1);
		for(int i : range) {
			System.out.print(i + " ");
		}
		
	}

}
