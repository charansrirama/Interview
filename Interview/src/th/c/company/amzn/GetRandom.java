package th.c.company.amzn;

import java.util.Random;

public class GetRandom {

	public static void randomPermutation(int[] A) {
		Random rand = new Random();
		for(int i = 0; i < A.length; i++) {
			int index = rand.nextInt(A.length - i) + i;
			swap(A, i, index);
		}
	}
	
	public static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6};
		randomPermutation(A);
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
