package th.hard;

import th.util.*;

// 1, 7, -5, 9, -12, 15 --> -5 -12 1 7 9 15
public class StableSwap {

	public static void swapRange(int a[], int nBeg, int nEnd) {
		while(nBeg < nEnd) {
			int temp = a[nBeg];
			a[nBeg] = a[nEnd];
			a[nEnd] = temp;
			nBeg++; nEnd--;
		}
	}
	
	public static void reArrage(int a[], int start, int end) {
		if((end-start)<=1) return;
		
		reArrage(a, start, start + (end-start)/2);
		reArrage(a, start+(end-start)/2+1, end);
		
		int nLft = 0;
		int nRgt = end;
		while(a[nLft] < 0) nLft++;
		while(a[nRgt] >= 0) nRgt--;
		
		if(nRgt <= nLft) return;
		
		swapRange(a, nLft, nRgt);
		
		int nBegRgt = nLft;
		
		while(a[nBegRgt] < 0) {
			nBegRgt++;
		}
		swapRange(a, nLft, nBegRgt-1);
		swapRange(a, nBegRgt, nRgt);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = new int[]{1, 7, -5, 9, -12, 15};
		reArrage(array, 0, array.length-1);
		Printer.arrayPrinter(array);
	}

}
