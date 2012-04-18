package th.util;

public class Sort {
	
	private static int partition(int input[], int left, int right) {
		int i = left;
		int j = right;
		int temp;
		int pivot = input[(left+right)/2];
		
		while(i <= j) {
			while(input[i]<pivot) i++;
			while(input[j]>pivot) j--;
			if(i <= j) {
				temp = input[j];
				input[j] = input[i];
				input[i] = temp;
				i++; j--;
			}
		}
		return i;
	}
	
	private static void quickSort(int input[], int left, int right){
		int index = partition(input, left, right);
		if(left < index-1) quickSort(input, left, index-1);
		if(index < right) quickSort(input, index, right);
	}
	
	public static void quickSort(int input[]) {
		int left = 0;
		int right = input.length-1;
		quickSort(input, left, right);
	}
	
	// Merge Sort
	private static void merge(int[] data, int first, int n1, int n2) {
		int[] temp = new int[n1+n2];
		int copied = 0;
		int copied1 = 0;
		int copied2 = 0;
		
		while((copied1 < n1)&&(copied2 < n2)) {
			if(data[first+copied1] < data[first+n1+copied2]) {
				temp[copied++] = data[first+(copied1++)];
			} else {
				temp[copied++] = data[first+n1+(copied2++)];
			}
		}
		while(copied1 < n1) {
			temp[copied++] = data[first+(copied1++)];
		}
		while(copied2 < n2) {
			temp[copied++] = data[first+n1+(copied2++)];
		}
		for(int i = 0; i < n1+n2; i++) {
			data[first+i] = temp[i];
		}
	}
	
	private static void mergesort(int[] data, int first, int n) {
		int n1;
		int n2;
		if(n > 1) {
			n1 = n/2;
			n2 = n-n1;
			
			mergesort(data, first, n1);
			mergesort(data, first+n1, n2);
			
			merge(data, first, n1, n2);
		}
	}
	
	public static void mergesort(int[] data) {
		mergesort(data, 0, data.length);
	}
}
