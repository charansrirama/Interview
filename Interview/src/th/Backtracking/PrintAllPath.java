package th.Backtracking;

import java.util.HashSet;
import java.util.Set;

public class PrintAllPath {

	public static Set<String> pathSet = new HashSet<String>();
	
	// 1 for left move; 0 for down move
	public static void printAllPath(int x, int y) {
		int[] a = new int[x+y];
		for(int i = 0; i<x; i++) {
			a[i] = 1;
		}
		for(int i = x; i < x+y; i++) {
			a[i] = 0;
		}
		permutation(a, 0, a.length-1);
	}

	public static void permutation(int[] a, int start, int end) {
		if(start > end) {
			//th.util.Printer.arrayPrinter(a);
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < a.length; i++) {
				sb.append(a[i]);
			}
			pathSet.add(sb.toString());
		} else {
			for(int i = start; i <= end; i++) {
				th.util.Swap.swap(a, start, i);
				permutation(a, start+1, end);
				th.util.Swap.swap(a, start, i);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printAllPath(3,4);
		for(String path: pathSet) {
			System.out.println(path);
		}
	}

}
