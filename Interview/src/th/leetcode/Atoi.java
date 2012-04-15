package th.leetcode;

public class Atoi {
	// Accepted by Leetcode.com
	// Watch out the max and min situation. 
	
	public static int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        str = str.trim();
        if(str.length() == 0) return 0;
        boolean neg = false;
        String mark = "0123456789";
        if(str.charAt(0) == '-') {
        	neg = true;
        	str = str.substring(1);
        } else if(str.charAt(0) == '+'){
        	str = str.substring(1);
        }
        
        long result = 0; 
        
        for(int i = 0; i < str.length(); i++) {
        	int digit = mark.indexOf(str.charAt(i));
        	if(digit != -1) {
        		result = result*10 + digit;
        	} else {
        		break;
        	}
        }
        
        result = neg? -result : result;
        if(result > Integer.MAX_VALUE) {
        	result = Integer.MAX_VALUE;
        } else if(result < Integer.MIN_VALUE) {
        	result = Integer.MIN_VALUE;
        }
        return (int)result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(atoi(""));
		System.out.println(atoi("-123"));
		System.out.println(atoi("123"));
	}

}
