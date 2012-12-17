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
		k--;
		while(k-- >= 0 && ia < A.length && ib < B.length) {
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
	
	public static double findMedianSortedArrays1(int[] A, int[] B) {
		if((A == null || A.length == 0)&&(B == null || B.length == 0)) return 0;
		if(A.length >= B.length) 
			return help(B, A);
		else 
			return help(A, B);
	}
	
	public static double help(int[] A, int[] B) {
		int m = A.length, n = B.length;
		
		int k = (n+m-1)/2;
		int l = 0, r = m;
		while(l < r) {
			int mid = l + (r-l)/2, bldx = k-mid;
			if(bldx>k || A[mid]<B[bldx]) 
				l = mid+1;
			else 
				r = mid;
		}
		
		int a = l-1 >= 0 ? A[l-1] : Integer.MIN_VALUE;
		int b = k-1 >= 0 ? B[k-1] : Integer.MIN_VALUE;
		a = a >= b ? a : b;
		if((m+n)%2 == 1) return a;
		
		int c = k-l+1 >= n ? Integer.MAX_VALUE : B[k-l+1];
		int d = l >= m ? Integer.MAX_VALUE : A[l];
		c = c <= d ? c : d;
		return ((double)(a+c))/2;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,4,5,7,8};
		int[] B = {1,2,6};
		System.out.println(findMedianSortedArrays1(A, B));
	}

}
