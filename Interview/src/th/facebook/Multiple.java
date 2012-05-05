package th.facebook;

public class Multiple {

	public int multiple(int m, int n) {
		if(n == 1) return m;
		int k = multiple(m, n/2);
		return (n&1)==1? k+k+m:k+k;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
