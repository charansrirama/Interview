package th.c.Leetcode;

import java.util.*;

public class GrayCode {

	public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int len = (int)java.lang.Math.pow(2, n);
        for(int i = 0; i < len; i++) {
            int t = i >> 1;
            result.add(i^t);
        }
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
