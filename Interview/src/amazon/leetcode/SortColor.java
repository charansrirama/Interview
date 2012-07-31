package amazon.leetcode;

public class SortColor {
	public void sortColors(int[] A) {
		int start = 0;
		int tail = A.length-1;
		for(int i = 0; i <= tail;) {
			if(A[i] == 0) {
				int tmp = A[start];
				A[start] = A[i];
				A[i] = tmp;
				start++;
				i++;
			} else if(A[i] == 2) {
				int tmp = A[i];
				A[i] = A[tail];
				A[tail] = tmp;
				tail--;
			} else {
				i++;
			}
		}
    }
	
	public static void main(String args[]) {
		int arr[] = { 0, 1, 2, 1, 2, 1, 2, 0, 0, 2, 1, 0, 0, 2, 2, 1, 0 };
		SortColor test = new SortColor();
		test.sortColors(arr);
		th.util.Printer.arrayPrinter(arr);
	}
}
