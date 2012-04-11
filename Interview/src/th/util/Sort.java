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
}
