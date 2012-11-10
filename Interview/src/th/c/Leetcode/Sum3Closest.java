package th.c.Leetcode;

import java.util.Arrays;

public class Sum3Closest {

	public int threeSumClosest(int[] num, int target) {
		if(num == null || num.length == 0) return -1;
    	Arrays.sort(num);
		int diff = Integer.MAX_VALUE;
        int re = 0;
		for(int i = 0; i < num.length-2; i++) {
			int l = i+1, r = num.length-1;
			while(l < r) {
				if(num[i] + num[l] + num[r] == target) 
					return target;
				else {
					if(Math.abs(num[i] + num[l] + num[r] - target) < diff) {
						diff = Math.abs(num[i] + num[l] + num[r] - target);
                        re = num[i] + num[l] + num[r];
					}
					if(num[i] + num[l] + num[r] > target) 
						r--;
					else 
						l++;
				}
			}
		}
		return re;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
