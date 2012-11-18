package th.c.Leetcode;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(nRows <= 1) return s;
		int size = s.length();
		int delta = 2*(nRows - 1);
		int k = nRows - 1;
		StringBuilder buffer = new StringBuilder();
		for(int i = 0; i < nRows; i++) {
			if(i == 0 || i == nRows-1) {
				for(int j = i; j < size; j+= delta) {
					buffer.append(s.charAt(j));
				}
			} else {
				k--;
				for(int j = i; j < size; j += delta) {
					buffer.append(s.charAt(j));
					if(j + delta-2*i < size) 
						buffer.append(s.charAt(j + delta-2*i));
				}
			}
		}
		return buffer.toString();
	}
}
