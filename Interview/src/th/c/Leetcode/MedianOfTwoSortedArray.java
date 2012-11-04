package th.c.Leetcode;

public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		if(lenA == 0) 
			return getMedian(B);
		else if(lenB == 0) 
			return getMedian(A);
		else if(lenA == 1) 
			return findMedianBaseCase(A[0], B, B.length);
		else if(lenB == 1) 
			return findMedianBaseCase(B[0], A, A.length);
		else if(lenA == 2) 
			return findMedianBaseCase2(A[0], A[1], B, B.length);
		else if(lenB == 2) 
			return findMedianBaseCase2(B[0], B[1], A, A.length);
		
		int i = lenA/2, j = lenB/2, k;
		if(A[i] <= B[j]) {
			k = ((lenA%2 == 0) ? min(i-1, lenB-j-1) : min(i, lenB-j-1));
		//	return findMedianSortedArrays()
		}
		return 0;
	}
	
	public double getMedian(int[] A) {
		if(A.length %2 == 0) {
			return (double)(A[A.length/2] + A[A.length/2+1])/2;
		} else {
			return A[A.length/2];
		}
	}
	
	public double findMedianBaseCase(int med, int[] A, int n) {
		if(n == 1) 
			return (A[0] + med)/2.0;
		
		if(n %2 == 0) {
			int a = A[n/2-1], b = A[n/2];
			if(med <= a) 
				return a;
			else if(med <= b) 
				return med;
			else 
				return b;
		} else {
			int a = A[n/2-1], b = A[n/2], c = A[n/2+1];
			if(med <= a) 
				return (a+b)/2.0;
			else if(med <= c) 
				return (med+b)/2.0;
			else 
				return (b+c)/2.0;
		}
	}
	
	public double findMedianBaseCase2(int med1, int med2, int A[], int n) {
		if(n%2 == 0) {
			int a = (((n/2-2)>=0) ? A[n/2-2]: Integer.MIN_VALUE);
			int b = A[n/2-1];
			int c = A[n/2];
			int d = (((n/2+1) <= n-1) ? A[n/2+1] : Integer.MAX_VALUE);
			if(med2 <= b) 
				return (b+max(med2, a))/2.0;
			else if(med1 <= b) 
				return (b+min(med2, c))/2.0;
			else if(med1 >= c) 
				return (c+min(med1, d))/2.0;
			else if(med2 >= c) 
				return (c+max(med1, b))/2.0;
			else 
				return (med1+med2)/2.0;
		} else {
			int a = A[n/2-1], b = A[n/2], c = A[n/2+1];
			if(med1 >= b) 
				return min(med1, c);
			else if(med2 <= b) 
				return max(med2, a);
			else 
				return b;
		}
	}
	
	public int max(int x, int y) {
		return x > y ? x : y;
	}
	
	public int min(int x, int y) {
		return x > y ? y : x;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
