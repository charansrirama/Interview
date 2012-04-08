package th.leetcode;

public class ClimbStair {

	public static int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int[] result = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
        	if(i <= 2) result[i] = i;
        	else {
        		result[i] = result[i-1] + result[i-2];
        	}
        }
        return result[n];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
	}

}
