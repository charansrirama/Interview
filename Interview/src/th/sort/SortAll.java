package th.sort;

public class SortAll {
	
	//O(n^2) TimeO(1)
	public static void insertSort(int[] input) {
		for(int i = 1; i < input.length; i++) {
			for(int j = i; j > 0; j--) {
				if(input[j] < input[j-1]) {
					int temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
				}
			}
		}
		for(int i : input)
			System.out.print(i + " ");
	}
	
	//O(n^2) TimeO(1)
	public static void bubbleSort(int[] input) {
		for(int i = 0; i < input.length; i++) {
			for(int j = i+1; j < input.length; j++) {
				if(input[i] > input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		for(int i : input)
			System.out.print(i + " ");
	}
	
	//O(n^2) TimeO(1)
	public static void shellSort(int[] input) {
		for(int increment = input.length/2; increment >0; increment/=2) {
			for(int i = increment; i < input.length; i++) {
				int temp = input[i];
				int j = 0;
				for(j = i; j >= increment; j -= increment) {
					if(temp < input[j - increment]) {
						input[j] = input[j - increment];
					} else {
						break;
					}
				}
				input[j] = temp;
			}
		}
		for(int i : input)
			System.out.print(i + " ");
	}
	
	//O(n^2) TimeO(1)
	public static void selectionSort(int[] input) {
		for(int i = 0; i < input.length; i++) {
			int lowerIndex = i;
			for(int j = i+1; j < input.length; j++) {
				if(input[j] < input[lowerIndex])
					lowerIndex = j;
			}
			int temp = input[i];
			input[i] = input[lowerIndex];
			input[lowerIndex] = temp;
		}
		for(int i : input)
			System.out.print(i + " ");
	}
	
	//O(nlogn) Time O(n)
	public static void merge(int[] input, int first, int n1, int n2) {
		int[] temp = new int[n1 + n2];
		int copied = 0; 
		int copied1 = 0; 
		int copied2 = 0;
		int i;
		
		while((copied1 < n1) && (copied2 < n2)) {
			if(input[first+copied1] < input[first+n1+copied2])
				temp[copied++] = input[first+(copied1++)];
			else
				temp[copied++] = input[first+n1+(copied2++)];
		}
		while(copied1 < n1)
			temp[copied++] = input[first + (copied1++)];
		while(copied2 < n2)
			temp[copied++] = input[first + n1 + (copied2++)];
		
		for(i = 0; i < n1 + n2; i++)
			input[first + i] = temp[i];
	}
	
	public static void mergeSort(int[] input, int first, int size) {
		int n1, n2;
		if(size > 1) {
			n1 = size/2; n2 = size - n1;
			mergeSort(input, first, n1);
			mergeSort(input, first+n1, n2);
			merge(input, first, n1, n2);
		}
	}
	
	//O(nlogn) Time O(logn)
	public static int partition(int[] input, int left, int right) {
		int i = left, j = right;
		int temp;
		int pivot = input[(left+right)/2];
		
		while(i <=j) {
			while(input[i] < pivot) 
				i++;
			while(input[j] > pivot)
				j--;
			if(i <= j) {
				temp = input[i];
				input[i] = input[j];
				input[j] = input[i];
				i++; j--;
			}
		}
		return i;
	}
	
	public static int partition2(int[] input, int left, int right) {
	    int x = input[right];
	    int i = left-1;
	    for(int j = left; j < right-1; j++) {
		if(input[j] <= x) {
		    i++;
		    int temp = input[i];
		    input[i] = input[j];
		    input[j] = temp;
		}
	    }
	    int temp = input[i+1];
	    input[i+1] = input[right];
	    input[right] = temp;
	    
	    return i+1;
	}
	
	public static void quickSort(int[] input, int left, int right) {
		int index = partition(input, left, right);
		if(left < index-1) 
			quickSort(input, left, index-1);
		if(index < right)
			quickSort(input, index, right);
	}
	
	public static void main(String[] args) {
	    int[] input = new int[] {2,3,1,6,4,5,11,33,10};
	    bubbleSort(input);
	}
}
