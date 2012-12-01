package th.c.PointToOffer;

public class JosephusProblem {
	public int josephu(int n, int m) {
		if(n < 1 || m < 1) return -1;
		int[] f = new int[n+1];
		f[0] = f[1] = 0;
		for(int i = 2; i <= n; i++) f[i] = (f[i-1]+m) % i;
		return f[n];
	}
}
