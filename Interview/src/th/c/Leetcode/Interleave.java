package th.c.Leetcode;

import java.util.Arrays;

public class Interleave {
	// AC
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length()+s2.length() != s3.length()) 
            return false;
        int[][] flag = new int[s1.length()+1][s2.length()+1];
        for(int i = 0; i < flag.length; i++) {
        	Arrays.fill(flag[i], -1);
        }
        return help(s1,s2,s3,0,0,flag);
        
    }
    
    public boolean help(String s1, String s2, String s3, int i, int j, int[][] flag) {
        if(flag[i][j] != -1) {
        	return flag[i][j] == 1;
        }
        flag[i][j] = 0;
        if(i+j == s3.length()) {
        	flag[i][j] = 1;
        } else {
        	if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && help(s1, s2, s3, i+1, j, flag)) 
        		flag[i][j] = 1;
        	if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && help(s1, s2, s3, i, j+1, flag)) 
        		flag[i][j] = 1;
        }
        return flag[i][j] == 1;
    }
	
	// Small test case AC
	public boolean isInterleave2(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length()+s2.length() != s3.length()) 
            return false;
        return help2(s1,s2,s3,0,0);
        
    }
    
    public boolean help2(String s1, String s2, String s3, int i, int j) {
        if(i+j == s3.length()) return true;
        if(i< s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            if(help2(s1, s2, s3, i+1, j))
                return true;
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            if(help2(s1,s2,s3,i, j+1))
                return true;
        }
        return false;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
