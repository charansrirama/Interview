package th.string;

import java.math.BigInteger;

public class ContainString {

	/*
	 * Given two strings, check whether one contains another.
	 */
	
	// Hashtable method
	public static boolean contains(char[] str1, char[] str2) {
		int[] flag = new int[26];
		for(int i = 0; i < str1.length; i++) {
			int index = str1[i] - 'A';
			flag[index]++;
		}
		
		for(int i = 0; i < str2.length; i++) {
			int index = str2[i] - 'A';
			flag[index]--;
			if(flag[index] < 0) 
				return false;
		}
		return true;
	}
	
	// Prime number method
	public static boolean containsPrime(char[] str1, char[] str2) {
		int[] prime = new int[]{
				2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,  
                61, 67, 71, 73, 79, 83, 89, 97, 101
		};
		
		BigInteger result = BigInteger.valueOf(0);
		for(int i = 0; i < str1.length; i++) {
			int index = str1[i] - 'A';
			result = result.multiply(BigInteger.valueOf(prime[index]));
		}
		
		for(int i = 0; i < str2.length; i++) {
			int index = str2[i] - 'A';
			if(result.divide(BigInteger.valueOf(prime[index])) != BigInteger.valueOf(0)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ABCDEFGHLMNOPQRS";
		String str2 = "DCGSRQPOM";
		
		System.out.println(containsPrime(str1.toCharArray(), str2.toCharArray()));
	}

}
