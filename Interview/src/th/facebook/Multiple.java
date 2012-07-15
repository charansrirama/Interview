package th.facebook;

public class Multiple {

	public static int multiple(int m, int n) {
		if(m == 0 || n == 0) return 0;
		if(n == 1) return m;
		int k = multiple(m, n/2);
		return (n&1)==1? k+k+m:k+k;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiple(5, 0));
	}

}
