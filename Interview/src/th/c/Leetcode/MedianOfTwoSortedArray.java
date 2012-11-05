package th.c.Leetcode;

public class MedianOfTwoSortedArray {

	// O(m+n)
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length, n = B.length;
		if((m+n) %2 == 0) {
			return ((double)kthSmallNum(A, B, (m+n)/2) + (double)kthSmallNum(A, B, (m+n)/2+1))/2;
		} else 
			return kthSmallNum(A, B, ((m+n)+1)/2);
	}
	
	public static int kthSmallNum(int[] A, int[] B, int k) {
		int ia = 0, ib = 0;
		int ret = 0;
		while(--k >= 0 && ia < A.length && ib < B.length) {
			if(A[ia] < B[ib])
				ret = A[ia++];
			else 
				ret = B[ib++];
		}
		while(ia < A.length && k-- >= 0) ret = A[ia++];
		while(ib < B.length && k-- >= 0) ret = B[ib++];
		return ret;
	}
	
	// O(lg(m+n))
	public int kthSmall(int[] A, int aoffset, int m, int[] B, int boffset, int n, int k) {
		if(m > n) return kthSmall(B, boffset, n, A, aoffset, m, k);
		if(m == 0) return B[k-1];
		if(k == 1) return Math.min(A[aoffset], B[boffset]);
		int pa = Math.min(k/2, m);
		int pb = k - pa;
		
		if(A[aoffset + pa -1] < B[boffset + pb - 1])
			return kthSmall(A, aoffset + pa, m - pa, B, boffset, n, k - pa);
		return kthSmall(A, aoffset, m, B, boffset + pb, n - pb, k-pb);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {};
		int[] B = {1};
		System.out.println(findMedianSortedArrays(A, B));
	}

}
