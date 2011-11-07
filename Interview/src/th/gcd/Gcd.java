package th.gcd;

public class Gcd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(gcd(14, 6));
	}

	public static int gcd(int m, int n){
		if (0 == m) {
			return n;
		}
		if (0 == n) {
			return m;
		}
		if (m < n) {
			int tmp = m;
			m = n;
			n = tmp;
		}
		while(0 != n){
			int rem = m%n;
			m = n;
			n = rem;
		}
		return m;
	}
}
