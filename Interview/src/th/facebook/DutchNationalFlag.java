package th.facebook;

public class DutchNationalFlag {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 1, 2, 1, 2, 0, 0, 2, 1, 0, 0, 2, 2, 1, 0 };
		int arrLength = arr.length;
		int p = 0, q = arrLength - 1;
		for (int i = 0; i <= q;) {
			if (arr[i] == 0) {
				swap(arr, i, p);
				p++;
				i++;
			} else if (arr[i] == 2) {
				swap(arr, i, q);
				q--;
			} else {
				i++;
			}
		}
		System.out.println("Printing the sorted array:");
		for (int i = 0; i < arrLength; i++) {
			System.out.print(" " + arr[i]);
		}
	}

	public static void dutchFlag(int[] arr, int bar1, int bar2) {
		int len = arr.length;
		int start = 0, end = len-1;
		for(int i = 0; i <= end; ) {
			if(arr[i] < bar1) {
				swap(arr, start, i);
				start++;
				i++;
			} else if(arr[i] > bar2) {
				swap(arr, i, end);
				end--;
			} else {
				i++;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
