package amazon.leetcode;

import java.util.ArrayList;

public class NQueen {

	// Swap version
	public void swap(int[] columnIndex, int i, int j) {
		int tmp = columnIndex[i];
		columnIndex[i] = columnIndex[j];
		columnIndex[j] = tmp;
	}
	
	public void solveQueens(int n) {
		int[] columnIndex = new int[n];
		for(int i = 0; i < n; i++) 
			columnIndex[i] = i;
		nQueens(columnIndex, 0, n-1);
	}
	
	private void nQueens(int[] columnIndex, int start, int end) {
		if(start > end) {
			printQueenLocation(columnIndex);
		} else {
			for(int i = start; i <= end; i++) {
				swap(columnIndex, start, i);
				nQueens(columnIndex, start+1, end);
				swap(columnIndex, start, i);
			}
		}
	}
	
	public void printQueenLocation(int[] columnIndex) {
		for(int i = 0; i < columnIndex.length; i++) {
//			System.out.println("(i, j) = (" + i + ", " + columnIndex[i] + ")");
			String line = "";
			for(int j = 0; j < columnIndex[i]; j++) {
				line = line+".";
			}
			line = line+"Q";
			for(int j = columnIndex[i]; j < columnIndex.length; j++) {
				line = line + ".";
			}
			System.out.println(line);
		}
		System.out.println("========");
	}
	
	//////////
	public String arrayToString(int[] queens) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < queens.length; i++) 
			sb.append(queens[i]);
		return sb.toString();
	}
	
	public ArrayList<String> nQueensII(int n) {
		int[] queens = new int[n];
		for(int i = 0; i < n; i++) {
			queens[i] = i;
		}
		ArrayList<String> result = new ArrayList<String>();
		result.add(arrayToString(queens));
		while(getNextPerm(queens)){
			result.add(arrayToString(queens));
		}
		return result;
	}
	
	public boolean getNextPerm(int[] queens) {
		for(int i = queens.length-2; i>=0; i--) {
			if(queens[i] < queens[i+1]) {
				for(int j = queens.length-1; j > i; j--) {
					if(queens[j] > queens[i]) {
						swap(queens, i, j);
						int start = i+1;
						int end = queens.length-1;
						while(end >= start){
							swap(queens, start, end);
							start++; end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
}
