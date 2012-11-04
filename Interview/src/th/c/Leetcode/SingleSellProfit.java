package th.c.Leetcode;

public class SingleSellProfit {
	
	// O(n)
	public static int findMaxProfit1(int[] A) {
		if(A == null || A.length == 0) return 0;
		int profit = Integer.MIN_VALUE;
		for(int i = 0; i < A.length; i++) {
			for(int j = i; j < A.length; j++) {
				if(A[j] - A[i] > profit)
					profit = A[i] - A[j];
			}
		}
		return profit;
	}

	public static int max(int a, int b, int c) {
		if(a >= b && a >= c) 
			return a;
		else if( b >= a && b >= c) 
			return b;
		else if (c >= a && c >= b) 
			return c;
		else 
			return -1;
	}
	
	public static ret helper(int[] A, int begin, int end) {
		ret r = new ret(), r1 = new ret(), r2 = new ret();
		if(begin == end) {
			r.profit = 0;
			r.pMin = begin;
			r.pMax = begin;
		}
		
		int mid = (begin+end)/2;
		r1 = helper(A, begin, mid);
		r2 = helper(A, mid+1, end);
		r.pMin = A[r1.pMin] < A[r2.pMin] ? r1.pMin : r2.pMin;
		r.pMax = A[r1.pMax] > A[r2.pMax] ? r1.pMax : r2.pMax;
		r.profit = max(r1.profit, r2.profit, A[r.pMax] - A[r.pMin]);
		
		return r;
	}
	
	// O(nlgn)
	public static int findMaxProfit2(int[] A) {
		ret r = helper(A, 0, A.length-1);
		return r.profit;
	}
	
	// O(n)
	public static int findMaxProfit3(int[] A) {
		int profit = 0;
		int pmin = 0;
		for(int i = 0; i < A.length; i++) {
			if(A[i] - A[pmin] > profit) {
				profit = A[i] - A[pmin];
				continue;
			}
			if(A[i] < A[pmin]) 
				pmin = i;
		}
		return profit;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ret {
	int profit;
	int pMin;
	int pMax;
	
	public ret() {
		profit = 0;
		pMin = 0;
		pMax = 0;
	}
}
