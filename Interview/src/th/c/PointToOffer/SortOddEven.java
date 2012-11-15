package th.c.PointToOffer;

public class SortOddEven {
	
	public static void sort(int[] A) {
		if(A == null || A.length == 0) return;
		int tail = A.length-1;
		int i = 0;
		while(i <= tail) {
			if(A[i] % 2 == 0) {
				int tmp = A[i];
				A[i] = A[tail];
				A[tail] = tmp;
				tail--;
			} else {
				i++;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {
				1,2,3,4,5,6,7
		};
		sort(A);
		for(int i : A) {
			System.out.println(i);
		}
	}

}
