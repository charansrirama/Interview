package th.c.Leetcode;

import java.util.*;

public class NQueen {
	
	public ArrayList<String[]> solveNQueens(int n) {
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

	}

}
