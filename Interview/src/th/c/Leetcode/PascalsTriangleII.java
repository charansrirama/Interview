package th.c.Leetcode;

import java.util.*;

public class PascalsTriangleII {

	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(rowIndex < 0) return result;
		int[] mark = new int[rowIndex+1];
		mark[0] = 1;
		for(int i = 0; i < rowIndex; i++) {
			for(int j = i+1; j >= 0; j--) {
				if(j == i+1) mark[j] = 1;
				else if(j == 0) mark[j] = 1;
				else mark[j] = mark[j]+mark[j-1];
			}
		}
		for(int i = 0; i < mark.length; i++) 
			result.add(mark[i]);
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
