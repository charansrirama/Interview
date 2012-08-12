package interviewstreet.evernote;

import java.util.*;

public class TopFour2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		int N = Integer.parseInt(reader.nextLine());
		int[] input = new int[N];
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(reader.nextLine());
		}
		select(input, 0, N-1, N-4);
		int[] result = new int[4];
		for(int i = N-4, j = 0; i < N; i++, j++) {
			result[j] = input[i];
		}
		Arrays.sort(result);
		for(int i = 3; i >= 0; i--) {
			System.out.println(result[i]);
		}
	}
	
	public static int partition(int[] input, int p, int q) {
		int x = input[p];
		int i = p;
		for(int j = (p+1); j <= q; j++) {
			if(input[j] <= x) {
				i = i+1;
				if(i < j) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		int tmp = input[p];
		input[p] = input[i];
		input[i] = tmp;
		return i;
	}

	public static void select(int[] list, int left, int right, int k) {
		int pivotIndex = partition(list, left, right);
		if(pivotIndex == k) return;
		else if(k < pivotIndex) {
			select(list, left, pivotIndex-1, k);
		} else {
			select(list, pivotIndex+1, right, k);
		}
	}
}
