package th.c.Leetcode;

public class JumpGameII {

	public int jump(int A[]) {
		int k = 0;
		int s = 0;
		int j = 0;
		int i = j+1;
		int n = A.length;
		while(i < n) {
			i = j+1;
			int f = k + A[k];
			j = f;
			for(; i <= j && i < n; i++) {
				if(f <= (A[i]+i)) {
					k = i; 
					f = A[i] + i;
				}
			}
			s++;
		}
		return s;
	}
}
