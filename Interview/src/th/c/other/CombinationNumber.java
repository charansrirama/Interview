package th.c.other;

public class CombinationNumber {
	
	public static long C(int m, int n) {
		if(m-n < n) return C(m, m-n);
		long ans = 1;
		for(int i = 1; i <= n; i++) {
			ans *= (m+1-i);
			ans /= i;
		}
		return ans;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(C(5,2));
	}

}
