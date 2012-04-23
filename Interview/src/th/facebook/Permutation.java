package th.facebook;

import java.util.Arrays;

public class Permutation {
	
	// Recursion version getting permutation
	public void perm(int[] list){
		perm(list, 0, list.length-1);
	}
	
	public void perm(int[] list, int start, int end) {
		if(start > end) {
			th.util.Printer.arrayPrinter(list);
		} else {
			for(int i = start; i <= end; i++) {
				swap(list, i, start);
				perm(list, start+1, end);
				swap(list, i, start);
			}
		}
	}
	
	public void swap(int[] list, int start, int end) {
		int tmp = list[start];
		list[start] = list[end];
		list[end] = tmp;
	}
	
	// Dictionary order 
	// Input should be sorted
	public boolean getNextPerm(int[] list) {
		for(int i = list.length-2; i>=0; i--) {
			if(list[i] < list[i+1]) {
				for(int j = list.length-1; j > i; j--) {
					if(list[j] > list[i]) {
						swap(list, i, j);
						int start = i+1;
						int end = list.length-1;
						while(end >= start) {
							swap(list, start, end);
							start++; end--;
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	public void permDict(int[] list) {
		Arrays.sort(list);
		th.util.Printer.arrayPrinter(list);
		while(getNextPerm(list)) {
			th.util.Printer.arrayPrinter(list);
		}
	}
	
	public static void main(String args[]) {
		Permutation p = new Permutation();
		int[] array = new int[]{1,1,3};
		p.permDict(array);
	}
}


