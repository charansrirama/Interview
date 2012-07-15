package th.astar;

import java.util.*;

public class H {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int count = 1;
		while(true) {
			String line = cin.nextLine();
			if(line.equals("#")) break;
			
			System.out.println("Case: " + count);
			count++;
		}
	}

	public static String compare(String str1, String str2) {
		int length = Math.min(str1.length(), str2.length());
		for(int i = 0; i < length; i++) {
			if(str1.charAt(i) < str2.charAt(i)) return str1;
			else if(str1.charAt(i) > str2.charAt(i)) return str2;
		}
		
		return (str1.length() < str2.length()) ? str1 : str2;
	}
}
