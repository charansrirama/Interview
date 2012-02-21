package th.Backtracking;

import java.util.Scanner;

/**
 * shijinliang
 * Feb 5, 2012
 * Interview
 **/
public class GetSubSet {

    public static String[] getSubSet(char[] aaa) {
	int Mi = mi2(aaa.length);
	String[] result = new String[Mi];
	
	if(aaa.length == 1) {
	    result[0] = "Empty Set";
	    result[1] = aaa[0] + "";
	} else {
	    int tempMi = mi2(aaa.length-1);
	    String[] tempResult = new String[tempMi];
	    char[] tempaaa = new char[aaa.length-1];
	    for(int i = 0; i < aaa.length-1; i++) {
		tempaaa[i] = aaa[i];
	    }
	    tempResult = getSubSet(tempaaa);
	    char an = aaa[aaa.length-1];
	    
	    for(int i = 0; i < tempResult.length; i++) 
		result[i] = tempResult[i];
	    for(int i = tempResult.length; i< result.length; i++) {
		if(tempResult[i-tempResult.length].equals("Empty Set"))
		    result[i] = an + "";
		else 
		    result[i] = tempResult[i - tempResult.length] + an;
	    }
	}
	return result;
    }
    
    public static String[] binarySubSet(char[] aaa) {
	int Mi = mi2(aaa.length);
	String[] result = new String[Mi];
	
	for(int i = 0; i < Mi; i++) { 
	    String binary = "";
	    int temp = i;
	    for(int j = 0; j < aaa.length; j++) {
		int remider = temp % 2;
		temp = temp/2;
		binary = remider + binary;
	    }
	    result[i] = binaryToString(aaa, binary);
	}
	return result;
    }
    
    private static String binaryToString(char[] aaa, String binary) {
	String result = "";
	
	for(int i = 0; i < binary.length(); i++)
	    if(binary.charAt(i) == '1')
		result = result+aaa[i];
	if(result.equals(""))
	    result = "Empty Set";
	return result;
    }
    
    private static int mi2(int n) {
	int result = 1;
	while(n!=0) {
	    result = result*2;
	    n--;
	}
	return result;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	
	char[] aaa = new char[n];
	String s = scan.next();
	for(int i = 0; i < s.length(); i++) 
	    aaa[i] = s.charAt(i);
	
	String[] result = getSubSet(aaa);
	for(int i = 0; i < result.length; i++) 
	    System.out.println(result[i]);
	
	String[] result2 = binarySubSet(aaa);
	for(int i = 0; i < result2.length; i++)
	    System.out.println(result2[i]);
    }

}
