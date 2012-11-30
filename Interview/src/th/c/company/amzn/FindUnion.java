package th.c.company.amzn;

import java.util.*;

public class FindUnion {
	// 找两个数组的并集
	public static ArrayList<Integer> findUnion(int[] A, int[] B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(A == null || B == null || A.length == 0 || B.length == 0) return result;
		int ia = A.length-1, ib = B.length-1;
		while(ia >= 0 || ib >= 0) {
			while(ia > 0 && A[ia] == A[ia-1]) ia--;
			while(ib > 0 && A[ib] == A[ib-1]) ib--;
			int ta = ia >= 0 ? A[ia] : Integer.MIN_VALUE;
			int tb = ib >= 0 ? B[ib] : Integer.MIN_VALUE;
			if(ta < tb) {
				result.add(B[ib--]);
			} else if(ta > tb) {
				result.add(A[ia--]);
			} else {
				result.add(A[ia]);
				ia--; ib--;
			}
		}
		return result;
	}

	// Miss understanding. This solution find 交集.
	public static ArrayList<Integer> findUnion1(int[] A, int[] B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(A == null || B == null || A.length == 0 || B.length == 0) return result;
		int ia = 0, ib = 0;
		while(ia < A.length && ib < B.length) {
			if(A[ia] == B[ib]) break;
			if(A[ia] > B[ib]) ib++;
			if(A[ia] < B[ib]) ia++;
		}
		if(ia == A.length || ib == B.length) return result;
		int iia = ia, iib = ib;
		while(iia < A.length && iib < B.length) {
			if(A[iia] != B[iib]) break;
			iia++; iib++;
		}
		for(int i = iia-1; i >= ia; i--) {
			result.add(A[i]);
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		int[] B = {3,4,5,6,7,8};
		int[] A1 = {1,2};
		int[] B1 = {3,4,5,6,7,8};
		ArrayList<Integer> re = findUnion1(A, B);
		for(Integer i : re) System.out.println(i);
	}

}
