package th.c.other;

public class DutchFlag {
	public static void threeColors(int[] A) {
		int len = A.length;
		int p = 0, q = len - 1;
		for (int i = 0; i <= q;) {
			if (A[i] == 0) {
				swap(A, i, p);
				p++;
				i++;
			} else if (A[i] == 2) {
				swap(A, i, q);
				q--;
			} else {
				i++;
			}
		}
	}

	public static void fourColors(int[] A) {
		int len = A.length;
		int p = 0, q = len - 1, s = len - 1;
		for (int i = 0; i <= s;) {
			if (A[i] == 0) {
				swap(A, i, p);
				i++;
				p++;
			} else if (A[i] == 2) {
				swap(A, i, s);
				s--;
			} else if (A[i] == 3) {
				swap(A, i, q);
				q--;
				if (s > q) {
					s = q;
					swap(A, i, s);
				} else {
					swap(A, i, s);
					s--;
				}
			} else {
				i++;
			}
		}
	}

	public static void fourColors2(int[] a) {
		int len = a.length;
		int lo = 0;
		int mi = 0;
		int hi = len - 1;

		for (int i = 0; i <= hi; i++) {
			int n = a[i];
			if (n == 0) {
				swap(a, i, lo);
				lo++;
				if (mi < lo) {
					mi = lo;
					swap(a, i, mi);
				} else {
					swap(a, i, mi);
					mi++;
				}
			} else if (n == 1) {
				swap(a, i, mi);
				mi++;
			} else if (n == 3) {
				swap(a, i, hi);
				hi--;
				i--;
			}
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
		int[] A = new int[] { 1, 0, 3, 2, 0, 2, 3, 1, 2, 3, 0, 0, 1, 3 };
		int[] A2 = new int[] { 2, 0, 2, 1 };
		int[] A3 = new int[] { 1, 1, 3, 1, 0, 2, 3 };
		fourColors2(A);
		for (int i : A)
			System.out.print(i);
		System.out.println();
		fourColors2(A2);
		for (int i : A2)
			System.out.print(i);
		System.out.println();
		fourColors2(A3);
		for (int i : A3)
			System.out.print(i);
	}

}
