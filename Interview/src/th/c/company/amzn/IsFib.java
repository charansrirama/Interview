package th.c.company.amzn;

public class IsFib {

	// 判断一个序列是不是fib 序列。
	public static boolean isFib1(int[] A) {
		if(A == null || A.length == 0) return true;
		if(A.length == 1) return A[0] == 1 ? true : false;
		if(A.length == 2) return A[0] == 1 && A[1] == 1 ? true : false;
		int fib1 = A[0], fib2 = A[1];
		for(int i = 2; i < A.length; i++) {
			if(A[i] != fib1 + fib2) return false;
			fib1 = fib2;
			fib2 = A[i];
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A1 = {};
		int[] A2 = {1};
		int[] A3 = {1,2};
		int[] A4 = {2,3};
		int[] A5 = {1,1,2,3,5,8,13};
		System.out.println(isFib1(A1));
		System.out.println(isFib1(A2));
		System.out.println(isFib1(A3));
		System.out.println(isFib1(A4));
		System.out.println(isFib1(A5));
	}

}
