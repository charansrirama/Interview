package th.leetcode;

public class ZigZagConversion {

	public static String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(nRows < 2) return s;
        int len = s.length();
        int patternSize = (nRows-1)*2;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < len; i+=patternSize) {
        	result.append(s.charAt(i));
        }
        for(int i = 1; i < nRows-1; i++) {
        	for(int j = i; j < len; j+=patternSize) {
        		result.append(s.charAt(j));
        		int k = (j-i) + (patternSize-i);
        		if(k < len) result.append(s.charAt(k));
        	}
        }
        for(int i = nRows-1; i < len; i+=patternSize) {
        	result.append(s.charAt(i));
        }
        return result.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
	}

}
