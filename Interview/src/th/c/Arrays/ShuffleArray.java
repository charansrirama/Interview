package th.c.Arrays;

import java.util.*;

public class ShuffleArray {

	public static void shuffle(int[] array) {
		int n = array.length;
		Random random = new Random();
//		random.nextInt();
		for(int i = 0; i < n; i++) {
			int change = i+random.nextInt(n-i);
			swap(array, i, change);
		}
	}
	
	public static void swap(int[] a, int i, int change) {
		int tmp = a[i];
		a[i] = a[change];
		a[change] = tmp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
	    shuffle(a);
	    for (int i : a) {
	      System.out.println(i);
	    }
	}

}
