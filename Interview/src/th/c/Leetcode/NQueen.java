package th.c.Leetcode;

import java.util.*;

public class NQueen {
	
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if(n <= 0) return result;
		if(n == 1) {
			result.add(new String[] {"Q"});
			return result;
		}
 		int[] A = new int[n];
		for(int i = 0; i < n; i++) A[i] = i;
		while(getNext(A)) {
			if(isSafe(A)) {
				String[] board = new String[n];
				for(int i = 0; i < A.length; i++) {
					StringBuilder buffer = new StringBuilder();
					for(int j = 0; j < n; j++) {
						if(j == A[i]) buffer.append("Q");
						else buffer.append(".");
					}
					board[i] = buffer.toString();
				}
				result.add(board);
			}
		}
		return result;
	}
	public boolean getNext(int[] A) {
		for(int i = A.length-2; i >= 0; i--) {
			if(A[i] < A[i+1]) {
				for(int j = A.length-1; j > i; j--) {
					if(A[j] > A[i]) {
						swap(A, i, j);
						int start = i+1, end = A.length-1;
						while(start <= end) swap(A, start++, end--);
						return true;
					}
				}
			}
		} 
		return false;
	}
	
	public boolean isSafe(int[] A) {
		for(int i = 0; i < A.length; i++) {
			for(int j = i+1; j < A.length; j++) {
				if(A[i] == A[j] || Math.abs(A[i]-A[j]) == Math.abs(i-j)) 
					return false;
			}
		}
		return true;
	}
	
	public void swap(int[] A, int i, int j) {
		int tmp = A[i]; A[i] = A[j]; A[j] = tmp;
	}
	
	public ArrayList<String[]> solveNQueens2(int n) {
		int[] b = new int[n];
		ArrayList<String[]> list = new ArrayList<String[]>();
		int y = 0; 
		b[0] = -1;
		while(y >= 0) {
			do{
				b[y]++;
			} while((b[y] < n) && unsafe(y, b));
			if(b[y] < n) {
				if(y < n-1) {
					b[++y] = -1;
				} else {
					putboard(list, n, b);
				}
			} else {
				y--;
			}
		}
		return list;
	}

	private boolean unsafe(int y, int[] b) {
		int x = b[y];
		for(int i = 1; i <= y; i++) {
			int t = b[y-i];
			if(t == x || t == x-i || t == x+i)
				return true;
		}
		return false;
	}
	
	private void putboard(ArrayList<String[]> list, int n, int[] b) {
		String[] strs = new String[n];
		for(int y = 0; y < n; y++) {
			strs[y] = "";
			for(int x = 0; x < n; x++) {
				strs[y] += (b[y] == x) ? "Q" : ".";
			}
		}
		list.add(strs);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueen test = new NQueen();
		ArrayList<String[]> re = test.solveNQueens(1);
		for(String[] s : re) {
			for(String str : s) {
				System.out.println(str);
			}
			System.out.println();
		}
	}

}
